package grails.plugins.sandbox

class Author {
    static auditable = true

    static constraints = {
    }
    
    String lastName
    String firstName
    Date dob

}
