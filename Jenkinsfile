pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "ecom-proj"
        DOCKER_TAG = "latest"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/27-Nikhil/Ecom-project.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${ecom-proj}:${latest} ."
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    sh "docker stop ${ecom-proj} || true"
                    sh "docker rm ${ecom-proj} || true"
                    sh "docker run -d --name ${ecom-proj} -p 8080:8080 ${ecom-proj}:${latest}"
                }
            }
        }
    }

    post {
        success {
            echo "Deployment Successful ✅"
        }
        failure {
            echo "Deployment Failed ❌"
        }
    }
}
