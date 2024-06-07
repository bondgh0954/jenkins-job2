def buildJar(){
    echo "building jar file from application code"
    sh "mv package"
}

def buildImage(){
    echo "building docker image from the application code"
    withCredentials([usernamePassword(credentialsId:"dockerhub-credentials",usernameVariable:'USERNAME',passwordVariable:"PASSWORD")]){
        sh "docker build -t nanaot/java-app:pip.1 ."
        sh "echo $PASSWORD |docker login -u $USERNAME --password-stdin"
        sh "docker push nanaot/java-app:pip.1"
    }
}
return this