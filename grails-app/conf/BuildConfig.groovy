grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

def webDriverVersion = '2.24.1'
def gebVersion = '0.6.3'

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
        test "org.codehaus.geb:geb-junit4:$gebVersion"
        test "org.codehaus.geb:geb-spock:$gebVersion"
        test "org.seleniumhq.selenium:selenium-support:$webDriverVersion"
        test "org.seleniumhq.selenium:selenium-firefox-driver:$webDriverVersion"
        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$webDriverVersion") {
            exclude 'xml-apis'
        }
    }

    plugins {
        //Built in plugins
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.2"
        runtime ":resources:1.2-RC1"
        build ":tomcat:$grailsVersion"
		compile ':webxml:1.4.1'

        //Security
        compile ':spring-security-core:1.2.7.3'
        compile ":audit-logging:0.5.4"

        //Metrics
        test ":code-coverage:1.2.5"
        compile ":codenarc:0.17"
        compile ":gmetrics:0.3.1"

        //Debugging and Monitoring
        //compile ":app-info:0.4.3" - compile error
        compile ':grails-melody:1.12'
        compile ":console:1.1"
        compile ':runtime-logging:0.4'

        //Domain Augmentation
        //http://blog.armbruster-it.de/2011/04/a-perfect-team-grails-taggable-plugin-and-jquery-tagit/
        compile ':taggable:1.0.1'
        compile ':searchable:0.6.3'

        //Web Layer
        compile ':jquery-ui:1.8.15'
        compile ':browser-detection:0.4.1'
        //http://freeside.co/grails-fields/guide/
        //compile ":fields:1.0.4"
        compile ':tagcloud:0.3'

        //Testing
        //http://gpc.github.com/grails-fixtures/docs/index.html
        compile ':fixtures:1.1'
        compile ':svn:1.0.2'
        //https://bitbucket.org/tednaleid/grails-test-data/wiki/Home
        test ':build-test-data:2.0.2'
        test ":geb:$gebVersion"

		compile ":cloud-foundry:1.2.3"
	}
}

//See this article about getting codenarc output in Jenkins:
//http://www.saltwebsites.com/2011/grails-codenarc-jenkins-integration
codenarc {
    reports = {
        MyXmlReport('xml') {
            outputFile = 'target/test-reports/codenarc/CodeNarcReport.xml'
            title = 'Sample Report'
        }
        MyHtmlReport('html') {
            outputFile = 'target/test-reports/codenarc/CodeNarcReport.html'
            title = 'Sample Report'
        }
    }
    extraIncludeDirs=['grails-app/jobs','grails-app/test/functional']
}

coverage {
    //sourceInclusions = ['grails-app/jobs']
    exclusions = [
            '**/*Config*',
            '**/*Resources*',
            '**/LoginController*',
            '**/LogoutController*'
    ]
}

server.port=8880
