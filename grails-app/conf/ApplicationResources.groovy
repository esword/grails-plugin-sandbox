modules = {
    application {
        resource url:'js/application.js'
    }

    'tagit' {
        dependsOn 'jquery-ui'
        resource 'css/tagit-gradient-blue.css'
        resource 'js/jquery/tagit.js'
    }
}