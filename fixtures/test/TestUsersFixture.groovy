
import grails.plugins.sandbox.auth.*

load('SecurityFixture')

fixture {
    def defaultPassword = 'password'

    //create 10 dev users if they don't already exist
    (1..10).each {count ->
        def username = "user${count}"
        if (!LibraryUser.findByUsername(username)) {
            "$username"(LibraryUser, username: username, name: username, password: defaultPassword, enabled: true)
        }
    }

    //create 5 admin users if they don't already exist
    (1..5).each {count ->
        def username = "admin${count}"
        if (!LibraryUser.findByUsername(username)) {
            "$username"(LibraryUser, username: username, name: username, password: defaultPassword, enabled: true)
        }
    }
}

post {
    def userRole = AuthRole.findByAuthority('ROLE_USER')
    def adminRole = AuthRole.findByAuthority('ROLE_ADMIN')

    (1..10).each {count ->
        def u = LibraryUser.findByUsername("user${count}")
        if (!UserRoleMapper.findByUserAndRole(u, userRole)) {
            UserRoleMapper.create u, userRole
        }
    }

    (1..5).each {count ->
        def u = LibraryUser.findByUsername("admin${count}")
        if (!UserRoleMapper.findByUserAndRole(u, userRole)) {
            UserRoleMapper.create u, userRole
            UserRoleMapper.create u, adminRole
        }
    }
}
