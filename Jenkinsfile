import java.text.SimpleDateFormat

def TODAY = (new SimpleDateFormat("yyyyMMdd")).format(new Date())

pipeline {
    agent any
    environment {
        strDockerTag = "${TODAY}_${BUILD_ID}"
        strDockerImage ="sunnykid7/guestboard:${strDockerTag}"
    }

    stages {
        stage('Github Clone') {
            steps {
                git branch: 'main', url:'https://github.com/sunnykid/guestboard.git'
            }
        }
        stage('Build') {
            steps {
                sh 'chmod u+x mvnw'
                sh './mvnw clean package -Dmaven.test.skip=true'
            }
        }

        stage('Docker Image Build') {
            steps {
                script {
                    oDockImage = docker.build(strDockerImage, "--build-arg VERSION=${strDockerTag} -f Dockerfile .")
                }
            }
        }
        stage('Docker Image Push') {
            steps {
                script {
                    docker.withRegistry('', 'docker-auth') {
                        oDockImage.push()
                    }
                }
            }
        }
        stage('Staging Deploy') {
            steps {
                sshagent(credentials: ['Staging-PrivateKey']) {
                    sh "ssh -o StrictHostKeyChecking=no ubuntu@43.202.3.58 docker container rm -f guestboard"
                    sh "ssh -o StrictHostKeyChecking=no ubuntu@43.202.3.58 docker container run -d -p 80:8080 --name=guestboard ${strDockerImage} "
                }
            }
        }
    }
}