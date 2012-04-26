<%@ page import="sapiens.SuiviCompetence" %>



<div class="fieldcontain ${hasErrors(bean: suiviCompetenceInstance, field: 'etat', 'error')} ">
	<label for="etat">
		<g:message code="suiviCompetence.etat.label" default="Etat" />
		
	</label>
	<g:select name="etat" from="${suiviCompetenceInstance.constraints.etat.inList}" value="${suiviCompetenceInstance?.etat}" valueMessagePrefix="suiviCompetence.etat" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: suiviCompetenceInstance, field: 'acteur', 'error')} required">
	<label for="acteur">
		<g:message code="suiviCompetence.acteur.label" default="Acteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="acteur" name="acteur.id" from="${sapiens.Acteur.list()}" optionKey="id" required="" value="${suiviCompetenceInstance?.acteur?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: suiviCompetenceInstance, field: 'competence', 'error')} required">
	<label for="competence">
		<g:message code="suiviCompetence.competence.label" default="Competence" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="competence" name="competence.id" from="${sapiens.Competence.list()}" optionKey="id" required="" value="${suiviCompetenceInstance?.competence?.id}" class="many-to-one"/>
</div>

