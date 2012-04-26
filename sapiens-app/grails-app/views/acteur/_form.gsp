<%@ page import="sapiens.Acteur" %>



<div class="fieldcontain ${hasErrors(bean: acteurInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="acteur.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${acteurInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acteurInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="acteur.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${acteurInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acteurInstance, field: 'domainesEnEvaluation', 'error')} ">
	<label for="domainesEnEvaluation">
		<g:message code="acteur.domainesEnEvaluation.label" default="Domaines En Evaluation" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: acteurInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="acteur.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="role" name="role.id" from="${sapiens.Role.list()}" optionKey="id" required="" value="${acteurInstance?.role?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acteurInstance, field: 'suivisCompetences', 'error')} ">
	<label for="suivisCompetences">
		<g:message code="acteur.suivisCompetences.label" default="Suivis Competences" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${acteurInstance?.suivisCompetences?}" var="s">
    <li><g:link controller="suiviCompetence" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="suiviCompetence" action="create" params="['acteur.id': acteurInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'suiviCompetence.label', default: 'SuiviCompetence')])}</g:link>
</li>
</ul>

</div>

