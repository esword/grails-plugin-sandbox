package grails.plugins.sandbox



import grails.test.mixin.*
import org.junit.*
import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Author)
@Build(Author)
class AuthorTests {

    void testEquals() {
        def a1 = Author.build()
        def a2 = new Author(firstName: a1.firstName, lastName: a1.lastName, dob: a1.dob)
        assert a1 == a2
    }
}
