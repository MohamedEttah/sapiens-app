package sapiens

import static org.junit.Assert.*
import org.junit.*

class GestionCompetencesTests {

	GestionCompetencesService gestionCompetencesService
	InitialisationService initialisationService
	ActeurService acteurService

	DomaineCompetences domaine

	@Before
	void setUp() {
		if (Role.count() == 0) {
			initialisationService.initialiseDonneesReferenciel()
		}
		domaine = gestionCompetencesService.newDomaineCompetences("socle", "Socle commun")
		if (domaine.hasErrors()) {
			domaine.errors.allErrors.each { println it }
		}
	}


	@Test
	void testNewDomaineCompences() {
		def domFetch = DomaineCompetences.findByCode("socle")
		assertNotNull(domFetch)
		assertEquals("socle", domFetch.code)
	}

	@Test
	void testNewCompetenceAndDeleteDomaine() {
		def competence1 = gestionCompetencesService.newCompetence("1", "Comp 1", domaine)
		assertEquals(domaine, competence1.domaine)
		if (competence1.hasErrors()) {
			competence1.errors.allErrors.each { println it }
		}

		def competence2 = gestionCompetencesService.newCompetence("2", "Comp 2", domaine)
		def compFetch1 = Competence.findByCode("1")
		assertNotNull(compFetch1)

		def compFetch2 = Competence.findByCode("2")
		assertNotNull(compFetch2)

		def domFetch = DomaineCompetences.findByCode("socle")
		assertNotNull(domFetch)
		assertEquals(2, domFetch.competences.size())

		gestionCompetencesService.deleteDomaineCompetences("socle")
		assertEquals(0, DomaineCompetences.count())
		assertEquals(0, Competence.count())
	}

	@Test
	void testInscriptionDesincription() {
		def act1 = acteurService.newActeur("Pauline", "Durand", RoleCode.APPRENANT)
		def act2 = acteurService.newActeur("Paul","Dupond", RoleCode.APPRENANT)
		def dom2 = gestionCompetencesService.newDomaineCompetences("avance", "Socle avance")
		gestionCompetencesService.inscritActeurPourEvaluationAuDomaine(act1, domaine)
		gestionCompetencesService.inscritActeurPourEvaluationAuDomaine(act2, domaine)
		gestionCompetencesService.inscritActeurPourEvaluationAuDomaine(act1, dom2)
		
		def domFetch = DomaineCompetences.findById(domaine.id)
		def domFetch2 = DomaineCompetences.findById(dom2.id)
		
		def actFetch1 = Acteur.findById(act1.id)
		def actFetch2 = Acteur.findById(act2.id)
		
		assertEquals(2, domFetch.acteursEvalues.size())
		assertEquals(2, actFetch1.domainesEnEvaluation.size())
		assertEquals(1, domFetch2.acteursEvalues.size())
		assertEquals(1, actFetch2.domainesEnEvaluation.size())
		
		gestionCompetencesService.desinscritActeurPourEvaluationAuDomaine(actFetch2, domFetch)
		
		def actFetch22 = Acteur.findById(act2.id)
		def domFetch1 = DomaineCompetences.findById(domaine.id)
		assertEquals(1, domFetch1.acteursEvalues.size())
		assertEquals(0, actFetch22.domainesEnEvaluation.size())
		
		gestionCompetencesService.deleteDomaineCompetences("socle")
		gestionCompetencesService.deleteDomaineCompetences("avance")
		def domFech3 = DomaineCompetences.findByCode("socle")
		assertNull(domFech3)
		assertEquals(0, DomaineCompetences.count())
		
		def actFetch14 = Acteur.findByPrenom(act1.prenom)
		actFetch14.refresh()
		assertEquals(0,actFetch14.domainesEnEvaluation.size())
		
	}
	
	@Test
	void testSuiviCompetence() {
		def act1 = acteurService.newActeur("Pauline", "Durand", RoleCode.APPRENANT)
		def competence1 = gestionCompetencesService.newCompetence("1", "Comp 1", domaine)
		gestionCompetencesService.inscritActeurPourEvaluationAuDomaine(act1, domaine)
		
		
		def suiviComp1 = SuiviCompetence.findByActeurAndCompetence(act1, competence1)
		assertNotNull suiviComp1
		
		def competence2 = gestionCompetencesService.newCompetence("2", "Comp 2", domaine)
		def suiviComp2 = SuiviCompetence.findByActeurAndCompetence(act1, competence2)
		assertNotNull suiviComp1
		
		def act2 = acteurService.newActeur("Paul","Dupond", RoleCode.APPRENANT)
		gestionCompetencesService.inscritActeurPourEvaluationAuDomaine(act2, domaine)
		def suivisCompetencesAct2 = SuiviCompetence.findAllByActeur(act2)
		assertEquals(2, suivisCompetencesAct2.size())
		
		gestionCompetencesService.desinscritActeurPourEvaluationAuDomaine(act2, domaine)
		suivisCompetencesAct2 = SuiviCompetence.findAllByActeur(act2)
		assertEquals(0, suivisCompetencesAct2.size())
		
		
		gestionCompetencesService.deleteDomaineCompetences(domaine.code)
		assertEquals(0, Competence.count())
		assertEquals(0, SuiviCompetence.count())
		
		
	}
	
	
}
