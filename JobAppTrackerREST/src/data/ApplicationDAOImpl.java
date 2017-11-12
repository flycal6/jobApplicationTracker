package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Application;
import entities.User;

@Repository
@Transactional
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Application> index(int uid) {
		String q = "SELECT a FROM Application a WHERE a.user.id = :uid";
		List<Application> apps = em.createQuery(q, Application.class)
									.setParameter("uid", uid)
									.getResultList();
		return new HashSet<>(apps);
	}

	@Override
	public Application show(int uid, int aid) {
		String q = "SELECT a FROM Application a WHERE id=:aid AND a.user.id = :uid";
		List<Application> apps = em.createQuery(q, Application.class)
									.setParameter("uid", uid)
									.setParameter("aid", aid)
									.getResultList();
		if(apps.size() > 0) {
			return apps.get(0);
		}
		return null;
	}

	@Override
	public Application create(int uid, String appJson) {
		ObjectMapper om = new ObjectMapper();
		try {
			Application a = om.readValue(appJson, Application.class);
			a.setUser(em.find(User.class, uid));
			em.persist(a);
			em.flush();
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Application update(int uid, int aid, String appJson) {
		String q = "SELECT a FROM Application a WHERE id = :aid AND a.user.id = :uid";
		Application a = em.createQuery(q, Application.class)
							.setParameter("aid", aid)
							.setParameter("uid", uid)
							.getResultList()
							.get(0);
							
		ObjectMapper om = new ObjectMapper();
		try {
			Application omA = om.readValue(appJson, Application.class);
			a.setAppliedVia(omA.getAppliedVia());
			a.setCompanyName(omA.getCompanyName());
			a.setCoverLetter(omA.getCoverLetter());
			a.setDate(omA.getDate());
			a.setJobLocation(omA.getJobLocation());
			a.setNotes(omA.getNotes());
			a.setResume(omA.getResume());
			a.setInterviews(omA.getInterviews());
			a.setResponses(omA.getResponses());
			
			if(a != null) {
				return a;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean destroy(int uid, int aid) {
		// TODO Auto-generated method stub
		return null;
	}

}
