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
                 subject: "SUCCESS: Jenkins Automation Alert - Build #${env.BUILD_NUMBER}",
                 body: "Hi Disha,\n\nThe E-Commerce Order Validation Pipeline completed successfully!\n\nLogs: ${env.BUILD_URL}"
        }
    }
}
