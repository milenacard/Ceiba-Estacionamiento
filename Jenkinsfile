pipeline {
 	//Donde se va a ejecutar el Pipeline
	agent {
 		label 'Slave_Induccion'
 	}
 	
 	//Opciones especÃ­ficas de Pipeline dentro del Pipeline
 	options {
		//Mantener artefactos y salida de consola para el # especÃ­fico de ejecuciones recientes del Pipeline.
		buildDiscarder(logRotator(numToKeepStr: '3'))
		//No permitir ejecuciones concurrentes de Pipeline
		disableConcurrentBuilds()
 	}
 	
	 //Una secciÃ³n que define las herramientas para â€œautoinstalarâ€� y poner en la PATH
	 tools {
	 	jdk 'JDK8_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
		gradle 'Gradle4.5_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
	 }
	 
	 //AquÃ­ comienzan los â€œitemsâ€� del Pipeline
	 stages{
	 	stage('Checkout') {
	 		steps{
				echo "------------>Checkout<------------"
				checkout([$class: 'GitSCM', branches: [[name: '*/master']],
				doGenerateSubmoduleConfigurations: false, extensions: [], gitTool:	'Git_Centos', 
				submoduleCfg: [], userRemoteConfigs: [[credentialsId:	'GitHub_milenacard', 
				url: 'https://github.com/milenacard/Ceiba-Estacionamiento']]])
				sh 'gradle clean'
	 		}
	 	}
	 	
		 stage('Unit Tests') {
			steps{
		 		echo "------------>Unit Tests<------------"
		 		sh 'gradle test'
		 		junit 'Parqueadero-service/build/test-results/test/*.xml'
		 	}
		 }
		 
		 stage('Integration Tests') {
		 	steps {
		 		echo "------------>Integration Tests<------------"
		 	}
		 }
		 
		 stage('Static Code Analysis') {
		 	steps{
		 		echo "------------>Analisis de codigo estatico<--------------"
				withSonarQubeEnv('Sonar') {
				sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"}
		 	}
		 }
		 
		 stage('Build') {
		 	steps {
		 		echo "------------>Build<------------"
		 		sh 'gradle --b ./Parqueadero-service/build.gradle build -x test'
		 	}
		 }		  
	 }
	 
	 post {
	 	always {
	 		echo 'This will always run'
	 	}	
		 success {
		 		echo 'This will run only if successful'
		 }
		 failure {
		 	echo 'This will run only if failed'
		 	mail (to: 'milena.cardenas@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
		 }
		 unstable {
		 	echo 'This will run only if the run was marked as unstable'
		 }
		 changed {
		 	echo 'This will run only if the state of the Pipeline has changed'
		 	echo 'For example, if the Pipeline was previously failing but is now successful'
		 }
	 }
}