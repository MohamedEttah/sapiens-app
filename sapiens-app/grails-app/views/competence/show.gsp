
<%@ page import="sapiens.Competence" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'competence.label', default: 'Competence')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-competence" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-competence" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list competence">
			
				<g:if test="${competenceInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="competence.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${competenceInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${competenceInstance?.libelleCourt}">
				<li class="fieldcontain">
					<span id="libelleCourt-label" class="property-label"><g:message code="competence.libelleCourt.label" default="Libelle Court" /></span>
					
						<span class="property-value" aria-labelledby="libelleCourt-label"><g:fieldValue bean="${competenceInstance}" field="libelleCourt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${competenceInstance?.libelleLong}">
				<li class="fieldcontain">
					<span id="libelleLong-label" class="property-label"><g:message code="competence.libelleLong.label" default="Libelle Long" /></span>
					
						<span class="property-value" aria-labelledby="libelleLong-label"><g:fieldValue bean="${competenceInstance}" field="libelleLong"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${competenceInstance?.domaine}">
				<li class="fieldcontain">
					<span id="domaine-label" class="property-label"><g:message code="competence.domaine.label" default="Domaine" /></span>
					
						<span class="property-value" aria-labelledby="domaine-label"><g:link controller="domaineCompetences" action="show" id="${competenceInstance?.domaine?.id}">${competenceInstance?.domaine?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${competenceInstance?.id}" />
					<g:link class="edit" action="edit" id="${competenceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
