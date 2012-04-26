package sapiens

class ActeurService {

	boolean transactional = true
	
	/**
	 * Crée un nouvel apprenant
	 * @param prenom le prenom
	 * @param nom le nom
	 * @return l'apprenant
	 */
    Acteur newApprenant(String nom, String prenom) {
		newActeur(prenom, nom, RoleCode.APPRENANT)
    }
	
	/**
	 * Crée un nouveau gestionnaire
	 * @param prenom
	 * @param nom
	 * @return le gestionnaire
	 */
	Acteur newGestionnaire(String nom, String prenom) {
		newActeur(prenom, nom, RoleCode.GESTIONNAIRE)
	}
	
	private newActeur(String prenom, String nom, RoleCode roleCode) {
		Role role = Role.findByCode(roleCode.name())
		def acteur = new Acteur(prenom:prenom, nom: nom, role: role)
		acteur.save()
		acteur	
	}
}
