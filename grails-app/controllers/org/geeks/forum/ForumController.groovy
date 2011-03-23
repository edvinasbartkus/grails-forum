package org.geeks.forum

class ForumController {
	def defaultAction = "forums"

	// Handle forums
	def forums = {
		[ forums:Forum.enabled.list() ]
	}

	def newForum = {
		[ forum:new Forum() ]
	}

	def saveForum = {
		Forum forum = params.long("id") ? Forum.get(params.long("id")) : new Forum()
		forum.properties = params

		if(forum.save()) {
			flash.message = "Forum was saved."
			redirect action:"forums"
		} else {
			flash.message = "Forum was not saved."
			render view:"newForum", model: [ forum:forum ]
		}
	}

	def deleteForum = {
		def forum = Forum.get(params.long("id"))
		forum.delete()

		[ ]
	}

	def editForum = {
		def forum = Forum.get(params.long("id"))
		render view:"newForum", model:[ forum:forum ]
	}

	// Handle threads
	def threads = {
		def forum = Forum.get(params.long(forum))

		[ forum:forum, topics:ForumThread.enabled.forum(forum).list() ]
	}

	// Handle posts
	def posts = {
		def thread = Thread.get(params.long("thread"))

		[ thread:thread, posts:ForumPost.enabled.thread(thread).list() ]
	}
}
