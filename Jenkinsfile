pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
            }
        }

        stage('Build') {
            steps {
                sh 'docker ps'
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again!'
        }
    }
}