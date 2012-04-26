package sapiens

class Competence {

	String code
	String libelleCourt
	String libelleLong

	DomaineCompetences domaine

	static belongsTo = [
		domaine:DomaineCompetences
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
