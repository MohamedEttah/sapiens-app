
<%@ page import="sapiens.Competence" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'competence.label', default: 'Competence')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-competence" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-competence" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'competence.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="libelleCourt" title="${message(code: 'competence.libelleCourt.label', default: 'Libelle Court')}" />
					
						<g:sortableColumn property="libelleLong" title="${message(code: 'competence.libelleLong.label', default: 'Libelle Long')}" />
					
						<th><g:message code="competence.domaine.label" default="Domaine" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${competenceInstanceList}" status="i" var="competenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${competenceInstance.id}">${fieldValue(bean: competenceInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: competenceInstance, field: "libelleCourt")}</td>
					
						<td>${fieldValue(bean: competenceInstance, field: "libelleLong")}</td>
					
						<td>${fieldValue(bean: competenceInstance, field: "domaine")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${competenceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
