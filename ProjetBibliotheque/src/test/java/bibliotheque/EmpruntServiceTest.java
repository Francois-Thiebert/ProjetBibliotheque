package bibliotheque;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import bibliotheque.config.SpringConfig;
import bibliotheque.entities.Adherent;
import bibliotheque.entities.Emprunt;
import bibliotheque.entities.Livre;
import bibliotheque.services.EmpruntService;

@SpringJUnitConfig(SpringConfig.class)
@Transactional
@Rollback
class EmpruntServiceTest {
	
//	static AnnotationConfigApplicationContext ctx = null;
	
	EmpruntService empruntService;
	
	@Disabled
	@Test
	@Commit
	void initEmprunt() {
		empruntService.createOrUpdate(new Emprunt());
	}
	
	@Disabled
	@Test
	@Commit
	void supEmprunt(Emprunt emprunt) {
		empruntService.delete(emprunt);
	}
	
//	@Test
//	void injectionEmpruntServiceTest() {
//		assertNotNull(empruntService);
//	}

//	@Test
//	void insertEmpruntTest() {
//		Emprunt e = new Emprunt(LocalDate.of(2023, 05, 13),LocalDate.now(),new Adherent(),new Livre());
//		empruntService.createOrUpdate(e);
//		assertNotNull(empruntService.getById(e.getId()));
//	}

}
