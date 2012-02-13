package grails.plugins.sandbox

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Author {
    static auditable = true

    static constraints = {
    }
    
    String lastName
    String firstName
    Date dob

}
