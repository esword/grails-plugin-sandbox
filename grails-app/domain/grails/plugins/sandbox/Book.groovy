package grails.plugins.sandbox

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Book {
    static auditable = true

    static constraints = {
        title(blank: false)
        isbn(blank: false, unique:true)
        authors(nullable: false)
    }
    
    String title
    String isbn
    Integer pages

    static hasMany = [authors:Author]
}
