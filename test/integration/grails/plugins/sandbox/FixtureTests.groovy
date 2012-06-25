/*
 * Copyright (c) Eric Sword 2012
 */
package grails.plugins.sandbox

import org.junit.Test

import grails.plugins.sandbox.auth.AuthRole
import grails.plugins.sandbox.auth.UserRoleMapper
import grails.plugins.sandbox.auth.AuthUser

/**
 * 
 * @version \$Revision$
 * @author esword
 */
class FixtureTests {

    def fixtureLoader

    @Test
    void "SecurityFixture inited correctly"() {
        def f = fixtureLoader.load('SecurityFixture')
        
        assert AuthUser.count == 1
        assert AuthRole.count == 2
        assert UserRoleMapper.count == 2
    }
    
    @Test
    void "usersFixture inited correctly"() {
        fixtureLoader.load('SecurityFixture')
        def f = fixtureLoader.load('test/TestUsersFixture')
        assert AuthUser.count == 16
        def admin1 = AuthUser.findByUsername('admin1')
        assert admin1 != null
        assert admin1.authorities.size() == 2
    }

    @Test
    void "dataFixture inited correctly"() {
        def f = fixtureLoader.load('test/TestDataFixture')
        assert f.a1 != null
        assert f.a1.firstName == 'Stephen'

        assert (f.b1.authors as List) == [f.a1]
    }

    @Test
    void "authors fixture inited correctly"() {
        fixtureLoader.load('test/AuthorsFixture')
        assert Author.count == 100
    }

    @Test
    void "books fixture inited correctly"() {
        fixtureLoader.load('test/AuthorsFixture')
        fixtureLoader.load('test/BooksFixture')
        assert Book.count == 200
    }
}
