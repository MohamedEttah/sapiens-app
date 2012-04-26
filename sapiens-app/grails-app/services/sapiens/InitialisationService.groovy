package sapiens

class InitialisationService {

	boolean transactional = true
	ActeurService acteurService
	GestionCompetencesService gestionCompetencesService
	
    def initialiseDonneesReferenciel() {
		def roleApprenant = new Role (
			code : RoleCode.APPRENANT.name(),
			libelleCourt:"Apprenant"
			)
		roleApprenant.save()

		def roleGestionnaire = new Role (
			code : RoleCode.GESTIONNAIRE.name(),
			libelleCourt:"Gestionnaire")
		roleGestionnaire.save()
    }
	
	def initialiseDonneesTest() {
		
			// domaines de compétence
			DomaineCompetences scf = gestionCompetencesService.newDomaineCompetences(
					"SOCLE_COMMUN_FRAN",
					"Socle commun de compétences en français"
			)
			
			DomaineCompetences scm = gestionCompetencesService.newDomaineCompetences(
					"SOCLE_COMMUN_MATH",
					"Socle commun de compétences en Mathématiques"
			)
		
			// compétences
			gestionCompetencesService.newCompetence(
					"SCF_001",
					"Savoir reconnaître le temps des verbes",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_002",
					"Savoir reconnaître les constructions grammaticales",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_003",
					"Savoir différencier les adverbes des ajectifs",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_004",
					"Savoir conjuguer les verbes du premier groupe au subjonctif présent",
					scf
			)
			gestionCompetencesService.newCompetence(
					"SCF_005",
					"Savoir conjuguer les verbes du deuxième groupe au subjonctif présent",
					scf
			)
		
			gestionCompetencesService.newCompetence(
					"SCM_001",
					"Savoir utiliser les quatres opérations de bases",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCM_002",
					"Savoir simplifier des fractions",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCM_003",
					"Savoir identifier les situations de proportionnalité",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCM_004",
					"Savoir reconnaître une identité remarquable",
					scm
			)
			gestionCompetencesService.newCompetence(
					"SCF_005",
					"Savoir développer et factoriser",
					 scm
			)
		
			// acteurs
			acteurService.newApprenant("Durand","Cécile")
			acteurService.newApprenant("Dupont","Jacques")
			acteurService.newApprenant("Grimal","Tom")
			acteurService.newApprenant("Cros","Caherine")
			acteurService.newApprenant("Douame","Bongo")
			acteurService.newApprenant("Alim","Aisha")
			acteurService.newApprenant("Nouvel","Pierre")
			acteurService.newApprenant("Mendi","Erica")
			acteurService.newApprenant("Bousquet","Patricia")
			acteurService.newApprenant("Caron","Bertrand")
		
		  }
}
