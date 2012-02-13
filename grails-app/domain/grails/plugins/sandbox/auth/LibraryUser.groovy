package grails.plugins.sandbox.auth

class LibraryUser {
    /**
     * The name of the auto-created user which owns resources (e.g. default preferences that are auto-created by the
     * system
     */
    static final String DEFAULT_USERNAME = "system_user"
    static final String DEFAULT_NAME = "System User"

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    String name

	static constraints = {
		username blank: false, unique: true
        name(blank:false)
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<AuthRole> getAuthorities() {
		UserRoleMapper.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
