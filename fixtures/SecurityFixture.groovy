/*
 * Copyright (c) Eric Sword 2012
 */
import grails.plugins.sandbox.auth.*

fixture {
    if (!AuthRole.findByAuthority('ROLE_USER'))
        userRole(AuthRole, authority: 'ROLE_USER')
    if (!AuthRole.findByAuthority('ROLE_ADMIN'))
        adminRole(AuthRole, authority: 'ROLE_ADMIN')

    if (!AuthUser.findByUsername(AuthUser.DEFAULT_USERNAME))
        systemUser(AuthUser, username: AuthUser.DEFAULT_USERNAME, name: AuthUser.DEFAULT_NAME, password: 'password', enabled: true)
}

post {
    def systemUser = AuthUser.findByUsername(AuthUser.DEFAULT_USERNAME)
    def adminRole = AuthRole.findByAuthority('ROLE_ADMIN')
    def userRole = AuthRole.findByAuthority('ROLE_USER')
    if (!UserRoleMapper.findByUserAndRole(systemUser, adminRole))
        UserRoleMapper.create systemUser, adminRole
    if (!UserRoleMapper.findByUserAndRole(systemUser, userRole))
        UserRoleMapper.create systemUser, userRole
}