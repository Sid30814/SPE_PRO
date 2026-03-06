pipeline {
    agent any

    // Triggers for SCM Polling - checks for changes every minute
    // triggers {
    //     pollSCM('* * * * *')
    
    // }

    environment {
        // Replace with your actual Docker Hub username and credentials ID
        DOCKER_HUB_USER = 'siddheshmahajan'
        IMAGE_NAME = 'scientific_calculator'
        DOCKER_HUB_CREDENTIALS = 'DockerHubCred'
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
                  // withDockerRegistry is a declarative step that handles the login
                  // without needing a 'script' wrapper.
                  withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: "${DOCKER_HUB_CREDENTIALS}"]) {
                      sh "docker push ${DOCKER_HUB_USER}/${IMAGE_NAME}:latest"
                  }
              }
          }
        stage('Pull & Deploy with Ansible') {
           steps {
                   // Use the 'withCredentials' block to securely pass Docker Hub credentials to Ansible
                   withCredentials([usernamePassword(credentialsId: 'DockerHubCred',
                                                    usernameVariable: 'DOCKER_USER',
                                                    passwordVariable: 'DOCKER_PASS')]) {

                       sh """
                          ansible-playbook -i ansible/inventory ansible/playbook_pull.yml \
                          --extra-vars "docker_user=${DOCKER_USER} docker_password=${DOCKER_PASS}"
                       """
                   }
               }
        }

        stage('Ansible Post-Configuration') {
            steps {
                // Final setup or health check via Ansible
                sh 'ansible-playbook -i ansible/inventory ansible/playbook_pull.yml'
            }
        }
        
    }// Add this post block at the end of your pipeline
    post {
        success {
            mail to: 'mamtamahajan37@gmail.com',
                 subject: "Success: Pipeline ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build successful! View details: ${env.BUILD_URL}"
        }
        failure {
            mail to: 'mamtamahajan37@gmail.com',
                 subject: "Failure: Pipeline ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build failed! Please check the logs here: ${env.BUILD_URL}"
        }
    }


}
