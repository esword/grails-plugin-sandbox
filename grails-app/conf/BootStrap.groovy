import org.codehaus.groovy.grails.commons.ConfigurationHolder

class BootStrap {
    def fixtureLoader

    def init = { servletContext ->
        loadFixtures()
    }

    def destroy = {
    }

    def loadFixtures() {

        //setup the resource sharing user if it doesn't exist
        fixtureLoader.load("SecurityFixture")

        if (ConfigurationHolder.config.library.init.createTestUsers) {
            fixtureLoader.load("test/TestUsersFixture")
        }

        if (ConfigurationHolder.config.library.init.createTestData) {
            fixtureLoader.load("test/AuthorsFixture")
            fixtureLoader.load("test/BooksFixture")
        }

        //If you didn't want to do the above all the time, you could insert these lines into the grails
        //console plugin
        //import grails.plugins.sandbox.ApplicationContextHolder as ACH
        //def fixtureLoader = ACH.getBean('fixtureLoader')
        //fixtureLoader.load('test/AuthorsFixture')
        //fixtureLoader.load('test/BooksFixture')
    }

}
