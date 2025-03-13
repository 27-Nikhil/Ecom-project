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
                    sh '/usr/local/bin/mvn  clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "/usr/local/bin/docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    sh "/usr/local/bin/docker stop ${DOCKER_IMAGE} || true"
                    sh "/usr/local/bin/docker rm ${DOCKER_IMAGE} || true"
                    sh "/usr/local/bin/docker run -d --name ${DOCKER_IMAGE} -p 8080:8080 ${DOCKER_IMAGE}:${DOCKER_TAG}"
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
    tools {
        maven 'Maven_3'
    }
}
