pipeline {
    agent any

    environment {
        USER_DOCKERHUB_CREDENTIALS = credentials('dockerhub-credentials')
    }

    stages {

        stage('Build test delivery') {
            agent {
                docker {
                    image 'adoptopenjdk/maven-openjdk11'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'mvn test'
                stash name: 'jar', includes: '**/*.jar'
            }
        }

        stage('build docker image') {
            agent any
            steps {
                unstash 'jar'
                sh 'docker build -t hamer123/simple-java-maven-app .'
                sh 'docker login -u $USER_DOCKERHUB_CREDENTIALS_USR -p $USER_DOCKERHUB_CREDENTIALS_PSW'
                sh 'docker push hamer123/simple-java-maven-app'
            }
        }

        stage('Deploy to k8s') {
            agent any
            steps {
                sh 'kubectl delete -f deployment.yaml'
                sh 'kubectl apply -f deployment.yaml'
            }
        }

        stage('Deploy to k8s via helm') {
            agent any
            steps {
                sh 'helm list'
                script {
                    def test = 'test'
                    sh 'echo ${test}'
                }
            }
        }
    }
}