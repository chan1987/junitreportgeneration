pipeline {
	agent any
	stages {
		stage("Test") {
			steps {
				slackSend (color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
				sh 'mvn surefire:test surefire-report:report'
				//sh  'cd /var/lib/jenkins/workspace/junitreportgeneration/target/surefire-reports'
				//sh 'touch *.xml'
			}
		}
		stage("build") {
			steps {
				//slackSend channel: 'junittesting', message: 'Build Phase running'
				 sh  'mvn -Dmaven.test.skip=true surefire-report:report'
				 sh  'sudo cp $(pwd)/target/site/surefire-report.html $(pwd)/surefire-report.html'
				 sh  'sudo chmod 777 $(pwd)/surefire-report.html'
				 sh  'ls -l $(pwd)/surefire-report.html'
			}
		}
		stage("Slack notification") {
			steps {
				slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#junittesting', color: 'good', message: 'Jenkins Build Completed', teamDomain: 'a1devopsconsulting', tokenCredentialId: 'slackunit', username: 'Chandrakanth'

			}

		}

	}
	post {
		success {
			archiveArtifacts "target/**/*"
			junit '**/surefire-reports/*.xml'
			slackSend (color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
			slackUploadFile channel: '#junittesting', credentialId: 'slackunit', filePath: '*.html', initialComment: 'Test Reports'
		 }
		 failure {
			  slackSend (color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")

			   emailext (
					 subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
					 body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
					 recipientProviders: [[$class: 'DevelopersRecipientProvider']]
				   )
		 }
		}
	}