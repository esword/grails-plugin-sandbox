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
class HomePage extends Page {
    static at = {title == 'Welcome to the Library'}

    static content = {
        logoutLink {$('a', text:'Logout')}
        controllers {$('div', id:'controller-list')}

        toBookController {controllers.$('a',text:contains('Book'))}
    }}
