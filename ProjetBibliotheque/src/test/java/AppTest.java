
import bibliotheque.Dao.DaoAdherent;
import bibliotheque.entities.Adherent;
import bibliotheque.Dao.ContextJpa;


public class AppTest {

	public static void main(String[] args) {
		test1();
		ContextJpa.destroy();
	}
	
	private static void test1() {
		DaoAdherent daoAdherent = ContextJpa.getDaoAdherent();

		Adherent a1 = new Adherent("A","A");
		daoAdherent.save(a1);
		Adherent a2 = new Adherent("Test", "test");
		daoAdherent.save(a2);
		System.out.println(ContextJpa.getDaoAdherent().findAll());

	}
}
