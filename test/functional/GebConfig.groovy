/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver

// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = {
/*
    System.properties.with { p ->
        p['org.apache.commons.logging.Log']='org.apache.commons.logging.impl.SimpleLog'
        p['org.apache.commons.logging.simplelog.log.com.gargoylesoftware.htmlunit']='FATAL'
    }
*/
    def driver = new HtmlUnitDriver()
    driver.javascriptEnabled = true
    driver
}

waiting {
    timeout = 10
    retryInterval = 0.3
}

environments {

    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }

}

//set defaults for baseUrl and reportsDir for when running outside of grails
/*
if (!System.properties['geb.build.baseUrl'])
    baseUrl = "http://localhost:8880/grails-plugins-sandbox"
if (!System.properties['geb.build.reportsDir'])
    reportsDir = "target/test-reports/geb"
*/
