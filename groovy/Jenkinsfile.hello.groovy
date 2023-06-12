pipeline {
	agent none
	
	stages {
		stage('Hello') {
			steps {
				echo 'hello'
			}
		}
	}
}