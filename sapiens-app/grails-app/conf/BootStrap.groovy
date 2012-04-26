import sapiens.InitialisationService;
import sapiens.Role;

class BootStrap {

	InitialisationService initialisationService
	
    def init = { servletContext ->
		if (Role.count() == 0) {
			initialisationService.initialiseDonneesReferenciel()
		}
		
		environments {
			development {
				initialisationService.initialiseDonneesTest()
			}
		}
		
    }
    def destroy = {
    }
}
