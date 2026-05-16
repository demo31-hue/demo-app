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
            script {
                // Safely grab console logs directly via workspace file path string interpolation
                String logPath = "${env.JENKINS_HOME}/jobs/${env.JOB_NAME}/builds/${env.BUILD_NUMBER}/log"
                String consoleLogContent = ""
                
                try {
                    consoleLogContent = readFile(logPath)
                } catch (Exception e) {
                    consoleLogContent = "Could not attach log automatically. View online: ${env.BUILD_URL}console"
                }
                
                mail to: 'dishadayanand09@gmail.com',
                     subject: "SUCCESS: Jenkins Automation Alert - Build #${env.BUILD_NUMBER}",
                     body: "Hi Disha,\n\nThe E-Commerce Order Validation Pipeline completed successfully!\n\nProject: E-Commerce Order Validation\nJob Name: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}\n\nConsole URL Reference:\n${env.BUILD_URL}\n\n=========================================\nFULL CONSOLE OUTPUT LOGS:\n=========================================\n\n" + consoleLogContent
            }
        }
    }
}
