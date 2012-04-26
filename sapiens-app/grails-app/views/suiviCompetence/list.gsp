
<%@ page import="sapiens.SuiviCompetence" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'suiviCompetence.label', default: 'SuiviCompetence')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-suiviCompetence" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-suiviCompetence" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="etat" title="${message(code: 'suiviCompetence.etat.label', default: 'Etat')}" />
					
						<th><g:message code="suiviCompetence.acteur.label" default="Acteur" /></th>
					
						<th><g:message code="suiviCompetence.competence.label" default="Competence" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${suiviCompetenceInstanceList}" status="i" var="suiviCompetenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${suiviCompetenceInstance.id}">${fieldValue(bean: suiviCompetenceInstance, field: "etat")}</g:link></td>
					
						<td>${fieldValue(bean: suiviCompetenceInstance, field: "acteur")}</td>
					
						<td>${fieldValue(bean: suiviCompetenceInstance, field: "competence")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${suiviCompetenceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
