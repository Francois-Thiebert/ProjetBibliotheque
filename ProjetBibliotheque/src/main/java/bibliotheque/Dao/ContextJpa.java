package bibliotheque.Dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import questJpa.dao.DaoStagiaire;
import questJpa.dao.DaoStagiaireJpaImpl;

public class ContextJpa {

	private static ContextJpa singleton;
	private EntityManagerFactory emf;
	private static DaoAdherent daoAdherent = new DaoAdherentJpaImpl();
	
	private ContextJpa() {
		emf = Persistence.createEntityManagerFactory("bibliotheque");
	}
	
	public static ContextJpa getInstance() {
		if (singleton == null) {
			singleton = new ContextJpa();
		}
		return singleton;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public static void destroy() {
		if(singleton!=null) {
			singleton.getEntityManagerFactory().close();
			singleton = null;
		}
	}

	public static DaoAdherent getDaoAdherent() {
		return daoAdherent;
	}
}
