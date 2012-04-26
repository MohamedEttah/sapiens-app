package sapiens

import static org.junit.Assert.*
import org.junit.*

class ActeurServiceIntegrationTests  {

	InitialisationService initialisationService
	ActeurService acteurService
	
    @Before
    void setUp() {
        if (Role.count() == 0) {
			initialisationService.initialiseDonneesReferenciel()
		}
    }

    @Test
    void testNewApprenant() {
        def act = acteurService.newApprenant( "Smith","Paul")
		def actFetch = Acteur.findByPrenom("Paul")
		
		assertNotNull(actFetch)
		assertEquals (actFetch,Acteur.get(act.id))
		assertEquals(RoleCode.APPRENANT.name(), actFetch.role.code)
    }
	
	@Test
	void testNewGestionnaire() {
		def act = acteurService.newGestionnaire("Smith","Pauline")
		def actFetch = Acteur.findByPrenom("Pauline")
		assertNotNull(actFetch)
		assertEquals(RoleCode.GESTIONNAIRE.name(), actFetch.role.code)
	}
}
