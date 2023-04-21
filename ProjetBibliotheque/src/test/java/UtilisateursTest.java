import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import bibliotheque.config.SpringConfig;
import bibliotheque.entities.Adherent;
import bibliotheque.services.AdherentService;

@SpringJUnitConfig(SpringConfig.class)
public class UtilisateursTest {

	@Autowired
	AdherentService adherentService;
	
	
	
	@Test
	@Commit
	void insertTest() {
		Adherent adherent = new Adherent("testLogin", "testPassword");
		adherent.setNom("truc");

		System.out.println(adherent.getNom());

		adherentService.createOrUpdate(adherent);
		System.out.println(adherent.getNom());
		assertNotNull(adherent.getId());
	}
	

}
