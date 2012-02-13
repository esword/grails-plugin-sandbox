grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

def webDriverVersion = '2.18.0'

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
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

        //see: http://www.gebish.org/manual/current/build-integrations.html#grails
        test "org.codehaus.geb:geb-junit4:0.6.2"
        test "org.codehaus.geb:geb-spock:0.6.2"
        test "org.seleniumhq.selenium:selenium-support:$webDriverVersion"
        test "org.seleniumhq.selenium:selenium-firefox-driver:$webDriverVersion"
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$webDriverVersion") {
            exclude 'xml-apis'
        }
    }

    plugins {
        //Built in plugins
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"
        build ":tomcat:$grailsVersion"

        //Security
        compile ':spring-security-core:1.2.7.2'
        compile ":audit-logging:0.5.4"

        //Metrics
        compile ":code-coverage:1.2.5"
        compile ":codenarc:0.16.1"
        compile ":gmetrics:0.3.1"

        //Debugging and Monitoring
        //compile ":app-info:0.4.3" - compile error
        compile ':grails-melody:1.11'
        compile ":console:1.1"
        compile ':runtime-logging:0.4'

        //System Init

        //Web Layer
        compile ':browser-detection:0.3.3'

        //Testing
        //http://gpc.github.com/grails-fixtures/docs/index.html
        compile ':fixtures:1.1'
        compile ':svn:1.0.2'
        //https://bitbucket.org/tednaleid/grails-test-data/wiki/Home
        test ':build-test-data:2.0.0'
        test ":geb:0.6.2"
    }
}

server.port=8880
