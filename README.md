# Scientific Calculator CI/CD Project

This project demonstrates a fully automated **CI/CD pipeline** for a Java-based Scientific Calculator. It covers the entire development lifecycle, including automated testing, containerization, and automated deployment.

---

## Project Overview

This project applies **DevOps best practices** to automate the process from source code to a running application. Every commit triggers an automated pipeline that ensures code quality, builds a containerized application, and deploys it without manual intervention.

---

## Tools Used

- **Version Control:** Git & GitHub  
- **Automation Server:** Jenkins  
- **Containerization:** Docker & Docker Hub  
- **Configuration Management:** Ansible  
- **Quality Assurance:** JUnit (via Maven)  
- **Connectivity:** ngrok  

---

## Architecture

The CI/CD workflow follows these steps:

1. **Code Repository**  
   The source code is maintained in a GitHub repository. Any changes pushed to the repository trigger the Jenkins pipeline.

2. **Build & Test**  
   Maven compiles the source code and executes JUnit tests to ensure the application's correctness.

3. **Containerization**  
   The application is packaged into a Docker image using a Dockerfile and pushed to Docker Hub.

4. **Deployment**  
   An Ansible playbook pulls the Docker image and deploys the container on the local machine.

---

## Prerequisites

Before running this project, ensure the following tools are installed:

- Java 11  
- Maven 3.x  
- Docker & Docker Hub Account  
- Ansible  
- Jenkins  

---

## Getting Started

Follow these steps to replicate the project:

1. **Clone the repository**

```
git clone https://github.com/Sid30814/SPE_PRO.git
```

2. **Build the project**

```bash
mvn clean package
```

3. **Build the Docker image**

```bash
docker build -t <dockerhub-username>/scientific_calculator:latest .
```

4. **Deploy the application using Ansible**

```bash
ansible-playbook -i ansible/inventory.ini ansible/playbook_pull.yml
```

---

## Testing

Unit tests are integrated into the build process. To run the tests manually:

```bash
mvn test
```




  
Roll Number: **MT2025122**
