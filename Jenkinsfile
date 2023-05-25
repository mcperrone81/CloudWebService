pipeline {
    agent any
    tools{
        maven 'Maven 3.9.2'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mcperrone81/CloudWebService.git']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t mcperrone81/demojenkinstwo .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{

                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u mcperrone81 -p${dockerhubpwd}'
}

                    sh 'docker push mcperrone81/demojenkinstwo'
                }
            }
        }
    }
}