pipeline {
	agent any
	
	tools {
		nodejs 'nodejs18'
	}

	stages {
		stage('Check node version') {
			steps {
				sh 'npm version'
			}
		}
		stage('Check yarn version') {
			steps {
				sh 'yarn -v'
			}
		}
	}
}