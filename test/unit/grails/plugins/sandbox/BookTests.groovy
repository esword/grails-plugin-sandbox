package grails.plugins.sandbox



import grails.test.mixin.*
import org.junit.*
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
@Build([Book, Author])
class BookTests {

    void testEquals() {
        def b1 = Book.build()
        println b1.authors
        def b2 = new Book(title: b1.title, isbn: b1.isbn, pages: b1.pages, authors:([].addAll(b1.authors)))
        assert b1 == b2
        b2.title = 'Some other title'
        assert b1 != b2
    }
}
