package org.geeks.forum

class ForumUser {
	Long userId

	Date lastSeen = new Date()

	Date dateCreated
	Date lastUpdated

	static constraints = {
		userId nullable:true
	}
}
