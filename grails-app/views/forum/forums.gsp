<html>
	<body>
		<h1>Forums</h1>
		<g:each in="${forums}" var="forum">
		<div>
			<h2>${forum.title}</h2>
			<g:link action="editForum" id="${forum.id}">Edit forum</g:link>
		</div>
		</g:each>

		<g:link action="newForum">New forum</g:link>
	</body>
</html>
