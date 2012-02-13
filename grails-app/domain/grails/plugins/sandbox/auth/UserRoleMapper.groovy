package grails.plugins.sandbox.auth

import org.apache.commons.lang.builder.HashCodeBuilder
class UserRoleMapper implements Serializable {
    static auditable = true

	LibraryUser user
	AuthRole role

    static mapping = {
        id composite: ['role', 'user']
        version false
    }

	boolean equals(other) {
		if (!(other instanceof UserRoleMapper)) {
			return false
		}

		other.user?.id == user?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

    String toString() {
        "UserRoleMapper(${user?.username}, ${role?.authority})"
    }
    
	static UserRoleMapper get(long userId, long roleId) {
		find 'from UserRoleMapper where user.id=:userId and role.id=:roleId',
			[userId: userId, roleId: roleId]
	}

	static UserRoleMapper create(LibraryUser user, AuthRole role, boolean flush = false) {
		new UserRoleMapper(user: user, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(LibraryUser user, AuthRole role, boolean flush = false) {
		UserRoleMapper instance = UserRoleMapper.findByLibraryUserAndLibraryGroup(user, role)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(LibraryUser user) {
		executeUpdate 'DELETE FROM UserRoleMapper WHERE user=:user', [user: user]
	}

	static void removeAll(AuthRole role) {
		executeUpdate 'DELETE FROM UserRoleMapper WHERE role=:role', [role: role]
	}
}
