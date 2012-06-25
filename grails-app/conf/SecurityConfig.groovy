/*
The security config contains the primary settings for the spring-security plugin,
including the url-access mapping
 */

//*****************************************************************************
// SPRING SECURITY SETTINGS
//*****************************************************************************
import grails.plugins.springsecurity.SecurityConfigType

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'grails.plugins.sandbox.auth.AuthUser'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'grails.plugins.sandbox.auth.UserRoleMapper'
grails.plugins.springsecurity.authority.className = 'grails.plugins.sandbox.auth.AuthRole'
//grails.plugins.springsecurity.rejectIfNoRule = true

//when we use an external auth service, like LDAP or CAS, we need to be notified when a user
//logs in so we can create a user instance for the username if necessary.  There is no harm
//in keeping this on all the time.  It just means extra events are generated.
//The code for this is not in this demo.  See this blog entry:
//http://swordsystems.com/2011/12/12/auto-create-user-domain-object-with-spring-security/
grails.plugins.springsecurity.useSecurityEventListener = true

grails.plugins.springsecurity.securityConfigType = SecurityConfigType.InterceptUrlMap
grails.plugins.springsecurity.interceptUrlMap = [
        //'/monitoring': ["hasRole( 'ROLE_ADMIN' )", 'IS_AUTHENTICATED_FULLY'],
        '/monitoring': ['ROLE_ADMIN'],
        '/monitoring/**': ['ROLE_ADMIN'],
        //'dbconsole': ['ROLE_ADMIN'],
        'dbconsole*/**': ['ROLE_ADMIN'],

        '/securityInfo*/**': ['ROLE_ADMIN'],

        '/': ['permitAll'],
        '/index': ['permitAll'],

        //'/book/**': ['ROLE_ADMIN'],
        //'/author/**': ['IS_AUTHENTICATED_FULLY'],

        '/login/*': ['permitAll'],
        '/static/**': ['permitAll'],
        '/error': ['permitAll'],
        '/logout/*': ['permitAll'],

        "/**": ['IS_AUTHENTICATED_FULLY']
        //"/**": ['permitAll']
]

environments {
    production {
        grails.plugins.springsecurity.interceptUrlMap.'dbconsole/**' = ['IS_AUTHENTICATED_FULLY']
    }
}
