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

    }

}
