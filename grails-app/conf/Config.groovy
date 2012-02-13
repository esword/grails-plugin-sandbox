// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }


grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// enable query caching by default
grails.hibernate.cache.queries = true

// set per-environment serverURL stem for creating absolute links
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

//*****************************************************************************
// Application config file overrides
//*****************************************************************************
grails.config.locations = [SecurityConfig, AppDefaultConfig]

// JVM arg method: Useful mainly in dev. By passing in -Dapp.config.location=<FULL_PATH_OF_CONFIG_FILE>
// when starting the app you can specify any config file you desire
def appConfigPath = System.properties["app.config.location"]
if (appConfigPath && (new File(appConfigPath).exists())) {
    grails.config.locations << "file:" + appConfigPath

} else {

    // This section checks through a series of possible locations based on the current environment
    // As it's much easier to supply a checklist of locations here than to externalize this unfortunately
    // looks a bit excessive but provides many options to deploy to different prod environments
    environments {
        // When running in the production environment the config file can be one any of a number
        // of different places. Specific file locations are checked first to see if they exist
        // and will eventually default to a file somewhere on the classpath if no others are found.
        production {
            if (new File("/etc/libraryapp/custom_libraryapp_config.groovy").exists()) {
                grails.config.locations << "file:/etc/libraryapp/custom_config.groovy"
            } else if (new File("${userHome}/.libraryapp/user_config.groovy").exists()) {
                grails.config.locations << "file:${userHome}/.libraryapp/user_config.groovy"
            } else {
                grails.config.locations << "classpath:custom_libraryapp_config.groovy"
            }
        }
        // When running in development or test mode defaults to a specific file in the your home directory
        development {
            grails.config.locations << "file:${userHome}/.libraryapp/user_config.groovy"
        }
        test {
            grails.config.locations << "file:${userHome}/.libraryapp/user_config.groovy"
        }
    }
}

// Last we merge in an empty file which can contain settings for each instance
grails.config.locations << "classpath:application.instance.properties"
