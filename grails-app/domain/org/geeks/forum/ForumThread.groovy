package org.geeks.forum

class ForumThread {
	String title

	Date dateCreated
	Date lastUpdated

	boolean deleted = false

	ForumUser author
	Forum forum
	
	List posts
	static hasMany = [ posts:ForumPost ]

	static constraints = {
		title blank:false, nullable:false
		author nullable:false

		forum nullable:false
	}

	static namedQueries = {
		forum { forum ->
			eq "forum", forum
		}

		enabled {
			eq "deleted", false
		}

		countedByForum {
			projections {
				groupProperty("forum")
				rowCount()
			}

			forum { }
		}
	}
}
