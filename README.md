# Scientific Calculator CI/CD Project

This project demonstrates a fully automated **CI/CD pipeline** for a Java-based Scientific Calculator using **Jenkins, Docker, and Ansible**.  
The pipeline automatically builds, tests, containerizes, and deploys the application whenever the pipeline is triggered.

---

# Project Overview

The goal of this project is to implement **DevOps automation** for a Java application.  
The CI/CD pipeline performs the following tasks automatically:

- Fetches source code from GitHub
- Builds and tests the application using Maven
- Creates a Docker image
- Pushes the image to Docker Hub
- Deploys the application using Ansible
- Sends a notification based on pipeline status

---

# Tools Used

- **Version Control:** Git & GitHub  
- **Automation Server:** Jenkins  
- **Build Tool:** Maven  
- **Containerization:** Docker & Docker Hub  
- **Configuration Management:** Ansible  
- **Testing:** JUnit  

---

# CI/CD Pipeline Stages

The Jenkins pipeline consists of the following stages:

## 1. Checkout

The pipeline retrieves the latest source code from the GitHub repository.

```groovy
stage('Checkout') {
    steps {
        git branch: 'main', url: 'https://github.com/Sid30814/SPE_PRO.git'
    }
}
```

---

## 2. Build & Test

The project is compiled and tested using Maven.  
JUnit tests are executed during this stage.

```groovy
stage('Build & Test') {
    steps {
        sh 'mvn clean package'
    }
}
```

---

## 3. Docker Build

A Docker image is created using the Dockerfile in the project.

```groovy
stage('Docker Build') {
    steps {
        sh "docker build -t ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest ."
    }
}
```

---

## 4. Push to Docker Hub

The generated Docker image is pushed to Docker Hub using stored Jenkins credentials.

```groovy
stage('Push to Docker Hub') {
    steps {
        withCredentials([usernamePassword(credentialsId: "${DOCKER_HUB_CREDENTIALS}",
        passwordVariable: 'PASS', usernameVariable: 'USER')]) {

            sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
            sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
        }
    }
}
```

---

## 5. Pull & Deploy with Ansible

The Ansible playbook pulls the latest Docker image and deploys the container.

```groovy
stage('Pull & Deploy with Ansible') {
    steps {
        sh 'ansible-playbook -i ansible/inventory.ini ansible/playbook_pull.yml'
    }
}
```

---

## 6. Pipeline Notification

After the pipeline execution completes, Jenkins checks whether the build was successful or failed and triggers a notification.

```groovy
post {
    success {
        // Triggered when pipeline execution succeeds
    }
    failure {
        // Triggered when pipeline execution fails
    }
}
```

---

# Prerequisites

Before running the project, ensure the following tools are installed:

- Java 11
- Maven 3.x
- Docker
- Docker Hub Account
- Jenkins
- Ansible

---

# Running the Project

Clone the repository:

```bash
git clone https://github.com/Sid30814/SPE_PRO.git
```

Navigate to the project directory:

```bash
cd SPE_PRO
```

Build the project:

```bash
mvn clean package
```

Build the Docker image:

```bash
docker build -t siddheshmahajan/scientific_calculator:latest .
```

Deploy using Ansible:

```bash
ansible-playbook -i ansible/inventory.ini ansible/playbook_pull.yml
```

---

# Author

**Siddhesh Mahajan**

GitHub: https://github.com/Sid30814
