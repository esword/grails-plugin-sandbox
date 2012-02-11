package grails.plugins.sandbox

class Book {

    static constraints = {
    }
    
    String title
    Integer pages

    static hasMany = [authors:Author]
}
