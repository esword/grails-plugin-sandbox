/*
 * Copyright (c) Eric Sword 2012
 */
import grails.plugins.sandbox.auth.*

fixture {
    if (!AuthRole.findByAuthority('ROLE_USER'))
        userRole(AuthRole, authority: 'ROLE_USER')
    if (!AuthRole.findByAuthority('ROLE_ADMIN'))
        adminRole(AuthRole, authority: 'ROLE_ADMIN')

    if (!LibraryUser.findByUsername(LibraryUser.DEFAULT_USERNAME))
        sharingUser(LibraryUser, username: LibraryUser.DEFAULT_USERNAME, name: LibraryUser.DEFAULT_NAME, password: 'password', enabled: true)
}

post {
    def sharingUser = LibraryUser.findByUsername(LibraryUser.DEFAULT_USERNAME)
    def adminRole = AuthRole.findByAuthority('ROLE_ADMIN')
    def userRole = AuthRole.findByAuthority('ROLE_USER')
    if (!UserRoleMapper.findByUserAndRole(sharingUser, adminRole))
        UserRoleMapper.create sharingUser, adminRole
    if (!UserRoleMapper.findByUserAndRole(sharingUser, userRole))
        UserRoleMapper.create sharingUser, userRole
}