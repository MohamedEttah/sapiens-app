package sapiens

class Acteur {
	
	String nom
	String prenom
	
	Role role
	
	static hasMany = [
		domainesEnEvaluation: DomaineCompetences, 
		suivisCompetences: SuiviCompetence
	]
	
	static belongsTo = [DomaineCompetences]

    static constraints = {
		nom blank:false
		prenom blank: false
    }
	
	@Override
	public String toString(){
		return nom
	}
}
