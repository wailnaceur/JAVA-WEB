package ma.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.dao.PositionLocal;
import ma.entities.ChartDto;
import ma.entities.Position;

@Stateless(name = "position")
public class PositionRemote implements ma.dao.PositionRemote,PositionLocal {
	
	@PersistenceContext(name = "GestionPositions")
	private EntityManager em;

	@Override
	public boolean create(Position t) {
		try {
			System.out.println("hhhh "+t);
			em.merge(t);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.getStackTrace();
			return false;
		}
		
		
	}

	@Override
	public void delteById(Position t) {
		em.remove(em.contains(t) ? t : em.merge(t));
		
	}

	@Override
	public Position update(Position p) {
		em.persist(em.contains(p) ? p: em.merge(p));
		return p;
	}

	@Override
	public Position findById(Position p) {
		// TODO Auto-generated method stub
		return (Position) em.find(Position.class, p.getId());
	}

	@Override
	public List<Position> findAll() {
		Query q = em.createQuery("Select p from Position p");
		System.out.println("position    "+q.getResultList());
		return q.getResultList();
		//return null;
	}

	@Override
	public List<ChartDto> chartBySmartPhone() { 
        List<ma.entities.ChartDto> charts = new ArrayList<>();
        return charts;
	}

}
