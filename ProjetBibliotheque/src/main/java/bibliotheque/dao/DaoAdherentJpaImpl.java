package bibliotheque.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import bibliotheque.entities.Adherent;
import questJpa.dao.ContextJpa;

public class DaoAdherentJpaImpl implements DaoAdherent{

	@Override
	public Adherent save(Adherent obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		obj = em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Adherent obj) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Adherent.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Adherent findByKey(Long key) {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		Adherent adherent = em.find(Adherent.class, key);
		em.close();
		return adherent;
	}

	@Override
	public List<Adherent> findAll() {
		EntityManager em = ContextJpa.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Adherent> query = em.createQuery("from Adherent a", Adherent.class);
		List<Adherent> adherents = query.getResultList();
		em.close();
		return adherents;
	}

}
