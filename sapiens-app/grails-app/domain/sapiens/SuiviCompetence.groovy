package sapiens



class SuiviCompetence {

	Acteur acteur
	Competence competence
	String etat = SuiviCompetenceEtat.EN_COURS_ACQUISITION

	static belongsTo = [
		acteur:Acteur,
		competence: Competence
	]

	static constraints = {
		etat(inList : (SuiviCompetenceEtat.values())*.name())
	}
}

enum SuiviCompetenceEtat {
	ACQUIS,
	NON_ACQUIS,
	EN_COURS_ACQUISITION
}