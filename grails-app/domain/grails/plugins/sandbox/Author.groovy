package grails.plugins.sandbox

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Author {
    static searchable = true
    static auditable = true

    static constraints = {
    }
    
    String lastName
    String firstName
    Date dob

}
