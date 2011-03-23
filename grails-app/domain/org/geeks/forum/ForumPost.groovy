package org.geeks.forum

class ForumPost {
	String title
	String body

	Date dateCreated
	Date lastUpdated

	Forum forum
	ForumThread thread
	ForumUser author
	String ip

	boolean deleted = false
	ForumPost parent = null

	Integer upVote = 0
	Integer downVote = 0

	static mapping = {
		body type:'text'
	}

	static constraints = {
		title blank:false, nullable:false
		body blank:false, nullable:false

		author nullable:false
		ip nullable:true, blank:true

		parent nullable:true
	}

	static namedQueries = {
		thread { thread ->
			eq "thread", thread
		}

		enabled {
			eq "deleted", false
		}
	}
}
