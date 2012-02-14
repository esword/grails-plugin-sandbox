<%@ page import="grails.plugins.sandbox.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="book.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${bookInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'isbn', 'error')} required">
	<label for="isbn">
		<g:message code="book.isbn.label" default="Isbn" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="isbn" required="" value="${bookInstance?.isbn}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'authors', 'error')} required">
	<label for="authors">
		<g:message code="book.authors.label" default="Authors" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="authors" from="${grails.plugins.sandbox.Author.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${bookInstance?.authors*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'pages', 'error')} required">
	<label for="pages">
		<g:message code="book.pages.label" default="Pages" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pages" required="" value="${fieldValue(bean: bookInstance, field: 'pages')}"/>
</div>

