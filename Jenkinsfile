
pipeline {
  agent any
  tools{
    maven 'maven-3'
  }

  stages{

    stage('build Jar'){
      steps{
        script{
          echo 'building jar file from application code'
          sh 'mvn package'
        }
      }
    }
    stage('build Image'){
      steps{
        script{
          echo 'building docker image from the application code'
          withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',usernameVariable:'USERNAME',passwordVariable:'PASSWORD')]){
            sh 'docker build -t nanaot/java-app:pip.1 .'
            sh 'echo $PASSWORD |docker login -u $USERNAME --password-stdin'
            sh 'docker push nanaot/java-app:pip.1'
          }
        }
      }
    }


  }

}