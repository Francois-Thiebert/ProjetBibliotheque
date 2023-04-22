package bibliotheque.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import bibliotheque.config.SpringConfig;
import bibliotheque.entities.Administrateur;
import bibliotheque.services.AdministrateurService;

@SpringJUnitConfig(SpringConfig.class)
public class AdministrateurTest {
	
	@Autowired
	AdministrateurService adminSrv;
	
	
	@Test
	@Commit
	void creerAdmin() {
		Administrateur admin = new Administrateur("Bouchard", "Gérard", "gbouchard", "mdp");
		adminSrv.createOrUpdate(admin);
		
	}
	
	@Test
	@Commit
	void suppr() {
		Administrateur admin = new Administrateur("Jean", "Jean", "jj", "mdp", "jj@trucmuche.com");
		adminSrv.createOrUpdate(admin);
		
	}


}
