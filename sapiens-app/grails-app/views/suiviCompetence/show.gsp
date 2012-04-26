
<%@ page import="sapiens.SuiviCompetence" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'suiviCompetence.label', default: 'SuiviCompetence')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-suiviCompetence" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-suiviCompetence" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list suiviCompetence">
			
				<g:if test="${suiviCompetenceInstance?.etat}">
				<li class="fieldcontain">
					<span id="etat-label" class="property-label"><g:message code="suiviCompetence.etat.label" default="Etat" /></span>
					
						<span class="property-value" aria-labelledby="etat-label"><g:fieldValue bean="${suiviCompetenceInstance}" field="etat"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${suiviCompetenceInstance?.acteur}">
				<li class="fieldcontain">
					<span id="acteur-label" class="property-label"><g:message code="suiviCompetence.acteur.label" default="Acteur" /></span>
					
						<span class="property-value" aria-labelledby="acteur-label"><g:link controller="acteur" action="show" id="${suiviCompetenceInstance?.acteur?.id}">${suiviCompetenceInstance?.acteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${suiviCompetenceInstance?.competence}">
				<li class="fieldcontain">
					<span id="competence-label" class="property-label"><g:message code="suiviCompetence.competence.label" default="Competence" /></span>
					
						<span class="property-value" aria-labelledby="competence-label"><g:link controller="competence" action="show" id="${suiviCompetenceInstance?.competence?.id}">${suiviCompetenceInstance?.competence?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${suiviCompetenceInstance?.id}" />
					<g:link class="edit" action="edit" id="${suiviCompetenceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
