<%@ page import="sapiens.DomaineCompetences" %>



<div class="fieldcontain ${hasErrors(bean: domaineCompetencesInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="domaineCompetences.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${domaineCompetencesInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domaineCompetencesInstance, field: 'libelleCourt', 'error')} required">
	<label for="libelleCourt">
		<g:message code="domaineCompetences.libelleCourt.label" default="Libelle Court" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="libelleCourt" required="" value="${domaineCompetencesInstance?.libelleCourt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domaineCompetencesInstance, field: 'libelleLong', 'error')} ">
	<label for="libelleLong">
		<g:message code="domaineCompetences.libelleLong.label" default="Libelle Long" />
		
	</label>
	<g:textField name="libelleLong" value="${domaineCompetencesInstance?.libelleLong}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domaineCompetencesInstance, field: 'acteursEvalues', 'error')} ">
	<label for="acteursEvalues">
		<g:message code="domaineCompetences.acteursEvalues.label" default="Acteurs Evalues" />
		
	</label>
	<g:select name="acteursEvalues" from="${sapiens.Acteur.list()}" multiple="multiple" optionKey="id" size="5" value="${domaineCompetencesInstance?.acteursEvalues*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: domaineCompetencesInstance, field: 'competences', 'error')} ">
	<label for="competences">
		<g:message code="domaineCompetences.competences.label" default="Competences" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${domaineCompetencesInstance?.competences?}" var="c">
    <li><g:link controller="competence" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="competence" action="create" params="['domaineCompetences.id': domaineCompetencesInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'competence.label', default: 'Competence')])}</g:link>
</li>
</ul>

</div>

