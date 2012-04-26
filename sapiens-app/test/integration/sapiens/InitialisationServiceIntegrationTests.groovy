package sapiens

import static org.junit.Assert.*
import org.junit.*

class InitialisationServiceIntegrationTests {
	
	InitialisationService initialisationService

    @Before
    void setUp() {
        if (Role.count() == 0) {
			initialisationService.initialiseDonneesReferenciel()
		}
    }


    @Test
    void testInitialiseDonneesReferenciel() {
        Role apprenant = Role.findByCode(RoleCode.APPRENANT.name())
		assertNotNull(apprenant)
		assertEquals(RoleCode.APPRENANT.name(), apprenant.code)
		
		Role gestionnaire = Role.findByCode(RoleCode.GESTIONNAIRE.name())
		assertNotNull(gestionnaire)
		
		assertEquals(2, Role.count())
    }
	
	@Test
	void testInitialiseDonneesTests() {
		initialisationService.initialiseDonneesTest() 
		assertTrue DomaineCompetences.count() == 2
		assertTrue Competence.count() == 10
		assertTrue Acteur.count() == 10
	
	  }
}
