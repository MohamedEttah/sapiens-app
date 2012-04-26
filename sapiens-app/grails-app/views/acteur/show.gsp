
<%@ page import="sapiens.Acteur" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'acteur.label', default: 'Acteur')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-acteur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-acteur" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list acteur">
			
				<g:if test="${acteurInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="acteur.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${acteurInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acteurInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="acteur.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${acteurInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acteurInstance?.domainesEnEvaluation}">
				<li class="fieldcontain">
					<span id="domainesEnEvaluation-label" class="property-label"><g:message code="acteur.domainesEnEvaluation.label" default="Domaines En Evaluation" /></span>
					
						<g:each in="${acteurInstance.domainesEnEvaluation}" var="d">
						<span class="property-value" aria-labelledby="domainesEnEvaluation-label"><g:link controller="domaineCompetences" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${acteurInstance?.role}">
				<li class="fieldcontain">
					<span id="role-label" class="property-label"><g:message code="acteur.role.label" default="Role" /></span>
					
						<span class="property-value" aria-labelledby="role-label"><g:link controller="role" action="show" id="${acteurInstance?.role?.id}">${acteurInstance?.role?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${acteurInstance?.suivisCompetences}">
				<li class="fieldcontain">
					<span id="suivisCompetences-label" class="property-label"><g:message code="acteur.suivisCompetences.label" default="Suivis Competences" /></span>
					
						<g:each in="${acteurInstance.suivisCompetences}" var="s">
						<span class="property-value" aria-labelledby="suivisCompetences-label"><g:link controller="suiviCompetence" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${acteurInstance?.id}" />
					<g:link class="edit" action="edit" id="${acteurInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
