package sapiens

class Role {

	String code
	String libelleCourt
	String libelleLong

	static constraints = {
		code(blank:false, inList :(RoleCode.values())*.name() as List )
		libelleCourt(blank:false)
		libelleLong(nullable:true)
	}
	
	@Override
	public String toString(){
		return libelleCourt
	}

}

enum RoleCode {
	APPRENANT,
	GESTIONNAIRE
}