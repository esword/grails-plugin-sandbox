grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
    }

    plugins {
        //built in plugins
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.5"
        build ":tomcat:$grailsVersion"

        //Security
        compile ':spring-security-core:1.2.7.2'

        compile ":audit-logging:0.5.4"

        //Build time plugins
        //compile ":app-info:0.4.3" - compile error

        compile ':grails-melody:1.11'

        //Debugging and Monitoring
        compile ":console:1.1"
        compile ':runtime-logging:0.4'

        //Metrics
        compile ":code-coverage:1.2.4"
        compile ":codenarc:0.15"
        compile ":gmetrics:0.3.1"
	
        //System Init
        //http://gpc.github.com/grails-fixtures/docs/index.html
        compile ':fixtures:1.0.7'

        //Web Layer
        compile ':browser-detection:0.3.3'
        //Testing
        // test ":geb:0.6.1"
        compile ':build-test-data:1.1.1'

        // test ":geb:0.6.1"
    }
}

server.port=8880
