pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }
    stages {
        stage('Build') {
            steps { sh 'mvn clean compile' }
        }
        stage('Test') {
            steps { sh 'mvn test' }
        }
        stage('Package') {
            steps { sh 'mvn package' }
        }
    }
    post {
        success {
            mail to: 'dishadayanand09@gmail.com',
                 subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Build Successful\n\nProject: E-Commerce Fraud Detection System\nJob Name: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}\n\nConsole Output:\n${env.BUILD_URL}console"
        }
    }
}
