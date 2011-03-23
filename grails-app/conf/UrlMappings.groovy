class UrlMappings {

	static mappings = {
		"/forum" {
			controller = "forum"
			action = "forums"
		}

		"/forum/new" {
			controller = "forum"
			action = "newForum"
		}

		"/forum/save/$id?" {
			controller = "forum"
			action = "saveForum"
		}

		"/forum/delete/$id?" {
			controller = "forum"
			action = "deleteForum"
		}

		"/forum/edit/$id?" {
			controller = "forum"
			action = "editForum"
		}

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
