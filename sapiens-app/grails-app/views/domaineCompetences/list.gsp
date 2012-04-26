
<%@ page import="sapiens.DomaineCompetences" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domaineCompetences.label', default: 'DomaineCompetences')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-domaineCompetences" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-domaineCompetences" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'domaineCompetences.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="libelleCourt" title="${message(code: 'domaineCompetences.libelleCourt.label', default: 'Libelle Court')}" />
					
						<g:sortableColumn property="libelleLong" title="${message(code: 'domaineCompetences.libelleLong.label', default: 'Libelle Long')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${domaineCompetencesInstanceList}" status="i" var="domaineCompetencesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${domaineCompetencesInstance.id}">${fieldValue(bean: domaineCompetencesInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: domaineCompetencesInstance, field: "libelleCourt")}</td>
					
						<td>${fieldValue(bean: domaineCompetencesInstance, field: "libelleLong")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${domaineCompetencesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
