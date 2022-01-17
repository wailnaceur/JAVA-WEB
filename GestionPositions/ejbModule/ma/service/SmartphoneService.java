package ma.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.dao.SmartPhoneLocal;
import ma.dao.SmartPhoneRemote;
import ma.entities.SmartPhone;

@Stateless(name = "Smartphone")
public class SmartphoneService implements SmartPhoneRemote,SmartPhoneLocal{

	@PersistenceContext(name = "GestionPositions")
	private EntityManager em;

	@Override
	public void create(SmartPhone s) {
		System.out.println(s);
		em.merge(s);
	}

	@Override
	public void delteById(SmartPhone s) {
		em.remove(em.contains(s) ? s : em.merge(s));
		
	}

	@Override
	public SmartPhone update(SmartPhone s) {
		em.merge(em.contains(s) ? s : em.merge(s));
		return s;
	}

	@Override
	public SmartPhone findById(int s) {
		
		return em.find(SmartPhone.class, s);
	}

	@Override
	public List<SmartPhone> findAll() {
		Query q = em.createQuery("from SmartPhone");
		return q.getResultList();
	}
	
}
