pipeline {
    agent any

    // Triggers for SCM Polling - checks for changes every minute
    triggers {
        pollSCM('* * * * *')
    }

    environment {
        // Replace with your actual Docker Hub username and credentials ID
        DOCKER_HUB_USER = 'SiddheshMahajan'
        IMAGE_NAME = 'scientific_calculator'
        DOCKER_HUB_CREDS = 'DockerHubCred'
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from your GitHub repository
                git branch: 'main', url: 'https://github.com/Sid30814/SPE_PRO.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Compiles code and runs JUnit tests using Maven
                sh 'mvn clean package'
            }
        }

     stage('Docker Build') {
                 steps {
                     // Use the variable names defined in the environment block
                     sh "docker build -t ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest ."
                 }
             }

             stage('Push to Docker Hub') {
                 steps {
                     // Use the variable for the Credentials ID as well
                     withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: "${DOCKER_HUB_CREDS}"]) {
                         sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
                     }
                 }
             }
        stage('Pull & Deploy with Ansible') {
            steps {
                // Configuration Management: Use Ansible to pull and run the container
                // This replaces the Kubernetes logic
                sh 'ansible-playbook -i ansible/inventory ansible/playbook_pull.yml'
            }
        }

        stage('Ansible Post-Configuration') {
            steps {
                // Final setup or health check via Ansible
                sh 'ansible-playbook -i ansible/inventory ansible/playbook.yml'
            }
        }
    }


}