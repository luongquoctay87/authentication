pipeline {
    agent any
    tools {
        maven 'MAVEN'
    }
    environment {
        dockerHub = "luongquoctay87"
        repository = "auth"
        tag = "1.0.0-${BUILD_NUMBER}"
        imageName = "${dockerHub}/${repository}:${tag}"
    }
    stages {
        stage('GitSCM') {
            steps {
                git changelog: false, credentialsId: 'GitHub', poll: false, url: 'https://github.com/luongquoctay87/authentication'
            }
        }
        stage('Build Maven') {
            steps {
                sh 'mvn clean package -P dev'
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t ${imageName} .'
            }
        }
        stage('Push image to DockerHub') {
            steps {
                withCredentials([string(credentialsId: 'Dockerhub', variable: 'dockerhub_pwd')]) {
                    sh 'docker login -u ${dockerHub} -p ${dockerhub_pwd}'
                }
                sh 'docker push ${imageName}'
                sh 'docker push ${dockerHub}/${repository}:latest'
            }
        }
        stage('Deploy to K8s') {
            steps {
                sh 'kubectl apply -f deploy.yaml'
            }
        }
        stage('Remove unused container/images') {
            steps {
                sh 'docker rm -vf $(docker ps -aq)' // remove all unused containers
                sh 'docker rmi -f $(docker images -aq)' // remove all unused images
            }
        }
    }
}
