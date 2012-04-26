package sapiens

class DomaineCompetences {

	String code
	String libelleCourt
	String libelleLong

	static hasMany = [
		competences: Competence,
		acteursEvalues : Acteur
	]

	static constraints = {
		code(blank:false)
		libelleCourt(blank:false)
		libelleLong(nullable:true)
	}
	
	@Override
	public String toString(){
		return libelleCourt
	}
	
}
