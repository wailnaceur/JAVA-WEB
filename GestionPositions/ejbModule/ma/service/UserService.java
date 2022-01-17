package ma.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ma.dao.UserLocal;
import ma.dao.UserRemote;
import ma.entities.User;

@Stateless(name = "User")
public class UserService implements UserRemote,UserLocal{
	
	@PersistenceContext(name = "GestionPositions")
	private EntityManager em;
	

	@Override
	public void create(User u) {
		em.persist(u);
	}

	@Override
	public void delteById(User u) {
		System.out.println("delete  "+u);
		em.remove(em.contains(u) ? u : em.merge(u));
		
	}

	@Override
	public User update(User u) {
		em.persist(em.contains(u) ? u: em.merge(u));
		return u;
	}

	@Override
	public User findById(int i) {
		return (User) em.find(User.class,i);
	}

	@Override
	public List<User> findAll() {
		Query query = em.createQuery("select u from users u");
		System.out.println(query.getResultList());
		System.out.println("hello");
		return query.getResultList();
		//return null;
	}

	public List<ma.entities.ChartDto> chartBySmartPhone(){
        String sql="SELECT COUNT(p.id),s.imei FROM Prosition p,SmartPhone s WHERE p.smartphone_id=s.id GROUP BY smartphone_id";
//		PreparedStatement ps=null;
//		ResultSet rs=null;
        Query query=em.createNativeQuery(sql);
                      List<ma.entities.ChartDto> charts = new ArrayList<>();
                      System.out.println(query.getResultList());
                      
//		try {
//			ps=Connexion.getInstance().getCn().prepareStatement(sql);
//			rs=ps.executeQuery();
//                        
//                        while(rs.next()) {
//				// professeurs.put(rs.getString("specialite.libelle"),rs.getInt("COUNT(professeur.id)"));
//                               charts.add(new ChartDto(rs.getString("specialite.libelle"), rs.getInt("COUNT(professeur.id)")));
//                        }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return charts;
    }


}
