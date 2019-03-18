// curl wrapper
// Usage:
// curl url:<URL>, with_authentication: <true/false>

def call(params = [:]) {

    String curl = "curl -s"
    String url = params.url

    if (params.containsKey('with_authentication') && params.with_authentication == true) {
        withCredentials([usernamePassword(credentialsId: globals.CREDENTIALS_ID,
                                          passwordVariable: 'password',
                                          usernameVariable: 'username')]) {

            return sh(script: "${curl} -u ${username}:${password} ${url}",
                      returnStdout: true).trim()
        }
    }
    else {
        return sh(script: "${curl} ${url}",
                  returnStdout: true).trim()
    }
}
