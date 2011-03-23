package org.geeks.forum.integration

import grails.test.*
import org.geeks.forum.Forum

class ForumTests extends GroovyTestCase {
	protected void setUp() {
		super.setUp()
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testForumSave() {
		def forum = new Forum()
		assertNull forum.save()

		forum.title = "Hello world!"
		assert forum.save(failOnError:true)

		assert Forum.count() > 0
	}
}
