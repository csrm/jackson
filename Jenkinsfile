pipeline {
    agent { node { label 'local-docker'} }
    stages {
        stage('build') {
            steps {
                sh 'gradle --version'
            }
        }
    }
}