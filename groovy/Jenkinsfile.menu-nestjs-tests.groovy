pipeline {
	agent any

	stages {
		stage('Cloning our Git') {
			steps {
			    sh 'git clone https://github.com/stasgm/nestjs-menu.git'
				sh 'cd nestjs-menu'
			}
		}
		stage('Install dependencies') {
			steps {
				sh 'yarn'
			}
		}
		stage('Migrate and seed the database') {
			steps {
				sh 'yarn t-env:db-migrate && yarn t-env:db-seed'
			}
		}
		stage('Run unit tests') {
			steps {
				sh 'yarn t-env:test'
			}
		}
	}
}