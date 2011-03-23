package org.geeks.forum.integration

import grails.test.*
import org.geeks.forum.ForumUser

class ForumUserTests extends GroovyTestCase {
	protected void setUp() {
		super.setUp()
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testUserSave() {
		def user = new ForumUser()
		assert user.save()
		assert user.count() > 0
	}
}
