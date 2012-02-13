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
class BooksPage extends Page {
    static url = '/book/list'
    static at = { assert title == 'Book List'; return true }

    static content = {
        newBook { $('a', text:'New Book') }
    }
}
