package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Interview;

@Repository
@Transactional
public class InterviewDAOImpl implements InterviewDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Set<Interview> index(int uid) {
		String q = "SELECT i FROM Interview i WHERE i.application.user.id = :uid";
		List<Interview> interviews = em.createQuery(q, Interview.class)
										.setParameter("uid", uid)
										.getResultList();
		return new HashSet<>(interviews);
	}

	@Override
	public Interview create(int uid, int aid, int rid, String responseJson) {
		// TODO Auto-generated method stub
		return null;
	}

}
