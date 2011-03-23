<html>
	<body>
		<h1>New forum</h2>
		<g:form action="saveForum">
			<g:if test="${forum?.id}">
				<input type="hidden" name="id" value="${forum.id}" />
			</g:if>
			<input type="text" name="title" value="${forum?.title}" />
			<input type="submit" name="save" value="Save" />
		</g:form>
	</body>
</html>
