pipeline{
    agent agent1
    stages {
        stage ('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_23') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage ('Test Stage') {
            steps {
                withMaven(maven: 'maven_3_23') {
                    sh 'mvn test'
                }
            }
        }
        stage ('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE"
                fileIncludePattern: "**/cucumber.json"
                jsonReportDirectory: 'target/cucumber-reports'
            }
        }
    }
   }