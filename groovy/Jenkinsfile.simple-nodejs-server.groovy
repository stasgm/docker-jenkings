pipeline {
	agent any
	
	tools {
		nodejs 'nodejs18'
	}

	stages {
		stage('Cloning our Git') {
			steps {
				git url: "https://github.com/stasgm/docker-node-test1.git"
			}
		}
		stage('Build') {
			steps {
				sh 'yarn'
			}
		}
		stage('Test') {
			steps {
				sh 'yarn test'
			}
		}
		stage('Deliver') {
			steps {
				sh 'yarn start'
			}
		}
	}
}