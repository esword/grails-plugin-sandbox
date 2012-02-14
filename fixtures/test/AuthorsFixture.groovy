import grails.plugins.sandbox.Author

/**
 * This fixture is for use with the console plugin to demonstrate creating lots of data when needed
 */
fixture {

    def numAuthors = 50
    def firstNames = ['Kelly', 'Sam', 'Chris', 'Alex', 'Lon', 'Mac', 'Pat', 'Ross', 'Ty', 'Vic', 'Ash', 'Jordan', 'Tyler', 'Taylor', 'Cameron', 'Casey', 'Dakota', 'Devon', 'Drew', 'Sasha', 'Leslie', 'Ashley', 'Maddy', 'Sam', 'Jo', 'Danny/Dani', 'Cameron', 'Ceri', 'Morgan', 'Jade', 'Frankie', 'Jean', 'Alex', 'Riley', 'Charlie']
    def lastNames = firstNames.collect {"${it}son"}

    def random = new Random()
    def startDate = Date.parse('MM/dd/yyyy', '09/21/1950')
    numAuthors.times {count ->
        def firstName = firstNames[random.nextInt(firstNames.size())]
        def lastName = lastNames[random.nextInt(lastNames.size())]
        def dob = startDate + random.nextInt(55*365)
        "a${count}"(Author, lastName:lastName, firstName:firstName, dob:dob)
    }
}