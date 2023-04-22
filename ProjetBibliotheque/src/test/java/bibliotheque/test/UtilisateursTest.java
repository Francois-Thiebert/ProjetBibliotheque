package bibliotheque.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import bibliotheque.config.SpringConfig;
import bibliotheque.entities.Adherent;
import bibliotheque.entities.Administrateur;
import bibliotheque.services.AdherentService;
import bibliotheque.services.AdministrateurService;

@SpringJUnitConfig(SpringConfig.class)
public class UtilisateursTest {

	@Autowired
	AdherentService adherentService;
	
	@Autowired
	AdministrateurService adminSrv;
	
	@Test
	@Commit
	void insertTest() {
		Adherent adherent = new Adherent("Gérard", "Bouchard", "gbouchard", "mdp");
		adherent.imprimerUtilisateur();
		adherentService.createOrUpdate(adherent);
		System.out.println(adherent.getNom());
		assertNotNull(adherent.getId());
		
		Administrateur administrateur = new Administrateur("Gérard", "Bouchard", "gbouchard", "mdp");
		adminSrv.createOrUpdate(administrateur);
		assertNotNull(administrateur.getId());
	}
}
