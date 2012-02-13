/*
 * $Id$
 * Copyright (c) Eric Sword 2012
 */
package grails.plugins.sandbox

import geb.Page

/**
 * 
 * @version \$Revision$
 * @author esword
 */
class LoginPage extends Page {
    static url = '/login'
    static at = {  assert title == 'Login'; return true }

    static content = {
        loginForm   { $('form', id:'loginForm')}
        username    { loginForm.find('input', name:'j_username') }
        password    { loginForm.find('input', name:'j_password')  }
        loginButton { $('input', type:'submit') }
    }
}
