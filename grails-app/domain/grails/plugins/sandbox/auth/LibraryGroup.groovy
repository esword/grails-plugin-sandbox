package grails.plugins.sandbox.auth

class LibraryGroup {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
