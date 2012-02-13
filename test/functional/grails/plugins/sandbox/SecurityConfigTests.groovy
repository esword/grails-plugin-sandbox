/*
 * $Id$
 * Copyright (c) Eric Sword 2012
 */
package grails.plugins.sandbox

import org.junit.Test
import geb.junit4.GebReportingTest
import org.junit.BeforeClass
import org.junit.Before
import grails.plugins.sandbox.ApplicationContextHolder as ACH

/**
 * 
 * @version \$Revision$
 * @author esword
 */
class SecurityConfigTests extends GebReportingTest {
    //fixture bean is not inited automatically in functional tests
    def fixtureLoader = ACH.getBean('fixtureLoader')

    @BeforeClass
    static void setup() {
        System.properties.with { p ->
            p["geb.env"] = "firefox"
        }
    }

    @Before
    void setUp() {
    }

    @Test
    void "home page requires no login"() {
        go()
        assert at(HomePage)
    }

    @Test
    void "book controller requires login"() {
        fixtureLoader.load('SecurityFixture')
        fixtureLoader.load('test/TestUsersFixture')
        fixtureLoader.load('test/TestDataFixture')

        to HomePage
        toBookController.click()
        assert at(LoginPage)

        username.value('user1')
        password.value('password')
        loginButton.click(BooksPage)
        waitFor { at BooksPage }
    }
}
