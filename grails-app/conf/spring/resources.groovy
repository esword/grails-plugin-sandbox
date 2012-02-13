// Place your Spring DSL code here
import grails.plugins.sandbox.ApplicationContextHolder

beans = {
    //See http://burtbeckwith.com/blog/?p=1017
    applicationContextHolder(ApplicationContextHolder) { bean ->
        bean.factoryMethod = 'getInstance'
    }
}
