pipeline{
	agent any
environment{
	}
    stages{
		stage('Build'){
			steps{
				echo 'Building the project'
                sh 'npm install'
            }
        }
        stage('Test'){
			when{
				expression{
					env.BRANCH_NAME == 'master' || env.BRANCH_NAME == 'feature001'
				}
			}
			steps{
				echo 'Testing the project'
            }
        }
        stage('Deploy'){
			steps{
				echo 'Deploying the project'
            }
        }
        post{
			always{
			}
			failure{
			}
			success{

			}
		}
		}
    }