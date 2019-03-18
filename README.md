# jenkins-pipelines-helpers
Some stuff to help your pipelines


## Global variables in libraries

You can use `vars/globals.groovy`. Add variable to `globals.groovy`:

```groovy
class globals {
    final String FOO = "foo!"
}
```

Get global variable from pipeline or library with

```groovy
@Field final String FOO = globals.FOO
stage('foo') {
    echo FOO
}
```

## `curl` wrapper

You can use simple `curl` wrapper `vars/curl.groovy` for `curl`\`ing:

```groovy
stage('curl it') {
    curl url: "http://example.com", with_authentication: false
}
```
