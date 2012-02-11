package grails.plugins.sandbox.auth

import org.apache.commons.lang.builder.HashCodeBuilder

class LibraryUserLibraryGroup implements Serializable {

	LibraryUser libraryUser
	LibraryGroup libraryGroup

	boolean equals(other) {
		if (!(other instanceof LibraryUserLibraryGroup)) {
			return false
		}

		other.libraryUser?.id == libraryUser?.id &&
			other.libraryGroup?.id == libraryGroup?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (libraryUser) builder.append(libraryUser.id)
		if (libraryGroup) builder.append(libraryGroup.id)
		builder.toHashCode()
	}

	static LibraryUserLibraryGroup get(long libraryUserId, long libraryGroupId) {
		find 'from LibraryUserLibraryGroup where libraryUser.id=:libraryUserId and libraryGroup.id=:libraryGroupId',
			[libraryUserId: libraryUserId, libraryGroupId: libraryGroupId]
	}

	static LibraryUserLibraryGroup create(LibraryUser libraryUser, LibraryGroup libraryGroup, boolean flush = false) {
		new LibraryUserLibraryGroup(libraryUser: libraryUser, libraryGroup: libraryGroup).save(flush: flush, insert: true)
	}

	static boolean remove(LibraryUser libraryUser, LibraryGroup libraryGroup, boolean flush = false) {
		LibraryUserLibraryGroup instance = LibraryUserLibraryGroup.findByLibraryUserAndLibraryGroup(libraryUser, libraryGroup)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(LibraryUser libraryUser) {
		executeUpdate 'DELETE FROM LibraryUserLibraryGroup WHERE libraryUser=:libraryUser', [libraryUser: libraryUser]
	}

	static void removeAll(LibraryGroup libraryGroup) {
		executeUpdate 'DELETE FROM LibraryUserLibraryGroup WHERE libraryGroup=:libraryGroup', [libraryGroup: libraryGroup]
	}

	static mapping = {
		id composite: ['libraryGroup', 'libraryUser']
		version false
	}
}
