import grails.plugins.sandbox.Author
import grails.plugins.sandbox.Book
import static java.util.UUID.randomUUID

// the build method triggers integration with the build-test-data plugin to populate any required fields
// that we have not set.  See:
// http://gpc.github.com/grails-fixtures/docs/guide/single.html#2.2%20Build-Test-Data%20Integration
fixture {

    def numBooks = 200
    def first = ['Encyclopedia', 'Compilation', 'Dictionary', 'Journal', 'Atlas', 'Thesaurus',
            'Reference', 'Guide', 'Volume']
    def last = ['Science', 'Popular Culture', 'Math', 'Biology', 'Chemistry', 'Engineering',
            'History', 'Politics', 'Economics', 'Art', 'Theater', 'Movies']

    def random = new Random()
    def startDate = Date.parse('MM/dd/yyyy', '09/21/1950')
    def allAuthors = Author.findAll()
    numBooks.times {count ->
        def f = first[random.nextInt(first.size())]
        def l = last[random.nextInt(last.size())]
        def title = (random.nextInt(2) >= 1) ? "$f of $l" : "$l $f"
        def pubDate = startDate + random.nextInt(55*365)
        //ensure isbn is unique
        def isbn = randomUUID() as String;
        while (Book.findByIsbn(isbn)) {
            println isbn
            isbn = randomUUID() as String;
        }
        //get some number of authors
        def numAuthors = random.nextInt(5) + 1
        def authors = (1..numAuthors).collect {allAuthors[random.nextInt(allAuthors.size())]}
        "book${count}"(Book, title:title, isbn:isbn, pages:random.nextInt(2000), authors:authors)
    }
}