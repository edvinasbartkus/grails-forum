package org.geeks.forum

class Forum {
	String title
	String description

	boolean enabled = true
	List threads
	
	static hasMany = [ posts:ForumThread ]

	static constraints = {
		title blank:false, nullable:false
		description blank:true, nullable:true
	}

	static namedQueries = {
		enabled {
			eq "enabled", true
		}
	}
}
