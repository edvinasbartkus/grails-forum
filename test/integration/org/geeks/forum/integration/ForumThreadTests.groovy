package org.geeks.forum.integration

import grails.test.*
import org.geeks.forum.Forum
import org.geeks.forum.ForumUser
import org.geeks.forum.ForumThread

class ForumThreadTests extends GroovyTestCase {
	ForumUser user
	Forum forum
	protected void setUp() {
		super.setUp()
		user = new ForumUser().save()
		forum = new Forum(title:"Hello world!").save()
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testThreadSave() {
		def thread = new ForumThread()
		assertNull thread.save()

		thread.forum = forum
		thread.author = user
		thread.title = "Hello thread!"
		assert thread.save()
		assert thread.count() > 0
	}

	void testDeletedThreads() {
		def thread = new ForumThread()
		thread.forum = forum
		thread.author = user
		thread.title = "Hello thread!"
		thread.deleted = true
		assert thread.save()
		assertNull ForumThread.enabled.get(thread.id)
	}

	void testCountProjection() {
		def newForum = new Forum(title:"Something")

		def thread = new ForumThread()
		thread.forum = forum
		thread.author = user
		thread.title = "Hello there!"
		assert thread.save()

		def count = ForumThread.countedByForum.list()
		assert count[forum] == 3
	}
}
