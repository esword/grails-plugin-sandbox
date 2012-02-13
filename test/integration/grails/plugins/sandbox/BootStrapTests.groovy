/*
 * $Id$
 * Copyright (c) Eric Sword 2012
 */
package grails.plugins.sandbox

import org.junit.Test
import org.codehaus.groovy.grails.commons.ConfigurationHolder

/**
 *
 * @version $Revision$
 * @author esword
 */

class BootStrapTests {
    
    @Test
    void testConfigLoad() {
        println ConfigurationHolder.config.grails.plugins.springsecurity.interceptUrlMap
        println ConfigurationHolder.config.library.init.createTestUsers
    }
}
