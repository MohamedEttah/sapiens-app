
<%@ page import="sapiens.DomaineCompetences" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domaineCompetences.label', default: 'DomaineCompetences')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-domaineCompetences" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-domaineCompetences" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list domaineCompetences">
			
				<g:if test="${domaineCompetencesInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="domaineCompetences.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${domaineCompetencesInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domaineCompetencesInstance?.libelleCourt}">
				<li class="fieldcontain">
					<span id="libelleCourt-label" class="property-label"><g:message code="domaineCompetences.libelleCourt.label" default="Libelle Court" /></span>
					
						<span class="property-value" aria-labelledby="libelleCourt-label"><g:fieldValue bean="${domaineCompetencesInstance}" field="libelleCourt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domaineCompetencesInstance?.libelleLong}">
				<li class="fieldcontain">
					<span id="libelleLong-label" class="property-label"><g:message code="domaineCompetences.libelleLong.label" default="Libelle Long" /></span>
					
						<span class="property-value" aria-labelledby="libelleLong-label"><g:fieldValue bean="${domaineCompetencesInstance}" field="libelleLong"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${domaineCompetencesInstance?.acteursEvalues}">
				<li class="fieldcontain">
					<span id="acteursEvalues-label" class="property-label"><g:message code="domaineCompetences.acteursEvalues.label" default="Acteurs Evalues" /></span>
					
						<g:each in="${domaineCompetencesInstance.acteursEvalues}" var="a">
						<span class="property-value" aria-labelledby="acteursEvalues-label"><g:link controller="acteur" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${domaineCompetencesInstance?.competences}">
				<li class="fieldcontain">
					<span id="competences-label" class="property-label"><g:message code="domaineCompetences.competences.label" default="Competences" /></span>
					
						<g:each in="${domaineCompetencesInstance.competences}" var="c">
						<span class="property-value" aria-labelledby="competences-label"><g:link controller="competence" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${domaineCompetencesInstance?.id}" />
					<g:link class="edit" action="edit" id="${domaineCompetencesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
