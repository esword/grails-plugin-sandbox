package grails.plugins.sandbox

class Book {
    static auditable = true

    static constraints = {
    }
    
    String title
    Integer pages

    static hasMany = [authors:Author]
}
