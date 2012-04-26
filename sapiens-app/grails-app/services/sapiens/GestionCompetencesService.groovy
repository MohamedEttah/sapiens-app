package sapiens

import org.hibernate.Session

class GestionCompetencesService {

	/**
	 * Crée un nouveau domaine de compétences
	 * @param code le code
	 * @param libelleCourt le libelle court
	 * @return le nouveau domaine
	 */
	DomaineCompetences newDomaineCompetences(String code, String libelleCourt) {
		def domaine = new DomaineCompetences(code: code, libelleCourt:libelleCourt)
		domaine.save()
		domaine
	}
	
	/**
	 * Supprime un domaine
	 * @param code le code du domaine à supprimer
	 */
	def deleteDomaineCompetences(String code) {
		def domaine = DomaineCompetences.findByCode(code)
		if (domaine) {
			// exemple de suppression en utilisant une requete sql native
			// il est possible dans ce cas de déclarer une constraint cascade 
			// directement au niveau de la bdd
			SuiviCompetence.withSession { Session session ->
				session.createSQLQuery(
				"delete from suivi_competence sc where exists \
				(select 0 from  competence c where c.id = sc.competence_id \
				 and c.domaine_id = ?)"
				).setLong(0,domaine.id)
				.executeUpdate()
				
			}
			domaine.delete()
		}
	}
	
	/**
	 * Crée une nouvelle compétence
	 * @param code le code
	 * @param libelleCourt le libellé court
	 * @param domaine le domaine
	 * @return la compétence crée
	 */
	Competence newCompetence(String code, String libelleCourt, DomaineCompetences domaine) {
		def competence = new Competence(code: code, libelleCourt:libelleCourt)
		domaine.addToCompetences(competence)
		competence.save()
		domaine.acteursEvalues.each {
			new SuiviCompetence(acteur: it, competence: competence).save()	
		}
		competence
	}
	
	/**
	 * Inscrit un acteur à un domaine
	 * @param acteur l'acteur 
	 * @param domaine le domaine
	 * 
	 */
	def inscritActeurPourEvaluationAuDomaine(Acteur acteur, DomaineCompetences domaine) {
		domaine.addToActeursEvalues(acteur)
		domaine.save()
		domaine.competences.each {
			new SuiviCompetence(acteur: acteur, competence: it).save()
		}
	}
	
	/**
	* Desinscrit un acteur d' un domaine
	* @param acteur l'acteur
	* @param domaine le domaine
	*
	*/
   def desinscritActeurPourEvaluationAuDomaine(Acteur acteur, DomaineCompetences domaine) {
	   if (acteur?.domainesEnEvaluation?.contains(domaine)) {
		   domaine.removeFromActeursEvalues(acteur)
		   domaine.save()
		   domaine.competences.each {
			   SuiviCompetence.findByActeurAndCompetence(acteur, it).delete()
		   }
	   }
   }
	
	
}
