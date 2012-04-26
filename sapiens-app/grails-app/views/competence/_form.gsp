<%@ page import="sapiens.Competence" %>



<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="competence.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${competenceInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'libelleCourt', 'error')} required">
	<label for="libelleCourt">
		<g:message code="competence.libelleCourt.label" default="Libelle Court" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="libelleCourt" required="" value="${competenceInstance?.libelleCourt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'libelleLong', 'error')} ">
	<label for="libelleLong">
		<g:message code="competence.libelleLong.label" default="Libelle Long" />
		
	</label>
	<g:textField name="libelleLong" value="${competenceInstance?.libelleLong}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: competenceInstance, field: 'domaine', 'error')} required">
	<label for="domaine">
		<g:message code="competence.domaine.label" default="Domaine" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="domaine" name="domaine.id" from="${sapiens.DomaineCompetences.list()}" optionKey="id" required="" value="${competenceInstance?.domaine?.id}" class="many-to-one"/>
</div>

