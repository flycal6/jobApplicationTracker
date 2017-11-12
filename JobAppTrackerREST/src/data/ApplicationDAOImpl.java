package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Application;

@Repository
@Transactional
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Application> index(int uid) {
		String q = "SELECT a FROM Application a";
		List<Application> apps = em.createQuery(q, Application.class).getResultList();
		return new HashSet<>(apps);
	}

	@Override
	public Application show(int uid, int aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application create(int uid, String appJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application update(int uid, int aid, String appJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean destroy(int uid, int aid) {
		// TODO Auto-generated method stub
		return null;
	}

}
