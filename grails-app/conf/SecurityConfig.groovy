/*
The security config contains the primary settings for the spring-security plugin,
including the url-access mapping
 */

//*****************************************************************************
// SPRING SECURITY SETTINGS
//*****************************************************************************
import grails.plugins.springsecurity.SecurityConfigType

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'grails.plugins.sandbox.auth.LibraryUser'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'grails.plugins.sandbox.auth.UserRoleMapper'
grails.plugins.springsecurity.authority.className = 'grails.plugins.sandbox.auth.AuthRole'
//grails.plugins.springsecurity.rejectIfNoRule = true

//when we use an external auth service, like LDAP or CAS, we need to be notified when a user
//logs in so we can create a user instance for the username if necessary.  There is no harm
//in keeping this on all the time.  It just means extra events are generated.
//The code for this is not in this demo.  See this blog entry:
//http://swordsystems.com/2011/12/12/auto-create-user-domain-object-with-spring-security/
grails.plugins.springsecurity.useSecurityEventListener = true

//make ldap explicitly inactive by default.  Need to do this because the default is active since we include
//the ldap plugin
grails.plugins.springsecurity.ldap.active = false
grails.plugins.springsecurity.cas.active = false
//grails.plugins.springsecurity.active = false

grails.plugins.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
grails.plugins.springsecurity.interceptUrlMap = [
        '/monitoring*/**': ["hasRole( 'ROLE_ADMIN' )"],
        '/securityInfo*/**': ["hasRole( 'ROLE_ADMIN' )"],

        '/index': ['permitAll'],
        '/main': ['IS_AUTHENTICATED_FULLY'],
        '/book/**': ['IS_AUTHENTICATED_FULLY'],
        '/author/**': ['IS_AUTHENTICATED_FULLY'],

        '/login/*': ['permitAll'],
        '/static/**': ['permitAll'],
        '/js/*': ['permitAll'],
        '/js/processing/**': ['permitAll'],
        '/images/**': ['permitAll'],
        '/grails-errorhandler/**': ['permitAll'],
        '/startPage': ['permitAll'],
        '/error': ['permitAll'],
        '/logout': ['permitAll'],
        '/public': ['permitAll'],
        'dbConsole/**': ['permitAll'],

        //"/**": ['IS_AUTHENTICATED_FULLY']
        "/**": ['permitAll']
]

environments {
    production {
        grails.plugins.springsecurity.interceptUrlMap.'dbConsole/**' = ['IS_AUTHENTICATED_FULLY']
    }
}
