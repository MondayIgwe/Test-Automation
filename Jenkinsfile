pipeline{
	agent any
environment{
		NEW_VERSION = '1.3.0'
	}
    stages{
		stage('Build'){
			steps{
				echo 'Building the project'
                sh 'npm install'
                echo "Version: ${NEW_VERSION}"
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
				env.BRANCH_IS_PRIMARY = true  $% env.CHANGE_AUTHOR = "John Doe"
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