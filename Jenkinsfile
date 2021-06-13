node {
    stage('Get Code') {
    // Get code from Github repository
        git credentialsId: 'rorymer.pg@gmail.com', url: 'https://github.com/rorymer1989/FirstTestJenkisMaven'
    }

    stage('Execute test then generate the report') {
        // Clean project
        bat label: 'Clean Project', script: 'mvn clean'
        // Execute test
        bat label: 'Execute test', script: 'mvn clean verify'
    }

    stage('Public HTML report to Jenkins') {
        cucumber cucumber-pretty: -1, failed : -1, surefile-reports: -1, fileIncludePattern: '**/*.json'
    }
}