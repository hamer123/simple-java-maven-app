pipeline {
    agent any
    stages {

        stage('Build test delivery') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
                sh 'mvn test'
                sh './jenkins/scripts/deliver.sh'
                stash name: 'jar', includes: '**/*.jar'
            }
        }

        stage('build docker image') {
            agent any
            steps {
                unstash 'jar'
                sh 'docker build -t hamer123/simple-java-maven-app .'

                sh 'docker push hamer123/simple-java-maven-app'
            }
        }
    }
}