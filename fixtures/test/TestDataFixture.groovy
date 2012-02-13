import grails.plugins.sandbox.Author
import grails.plugins.sandbox.Book

// the build method triggers integration with the build-test-data plugin to populate any required fields
// that we have not set.  See:
// http://gpc.github.com/grails-fixtures/docs/guide/single.html#2.2%20Build-Test-Data%20Integration
build {
    a1(Author, lastName:'King', firstName:'Stephen', dob:Date.parse('MM/dd/yyyy', '09/21/1947'))
    a2(Author, lastName:'Rowling', firstName:'JK', dob:Date.parse('MM/dd/yyyy', '07/31/1965'))

    b1(Book, title:'Shining', authors:[a1])
    b2(Book, title:'Chamber of Secrets', authors:[a2])
}