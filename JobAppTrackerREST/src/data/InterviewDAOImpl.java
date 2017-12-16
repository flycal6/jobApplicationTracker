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
import entities.Interview;
import entities.User;

@Repository
@Transactional
public class InterviewDAOImpl implements InterviewDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Interview> index(int uid) {
		String indexQuery = "SELECT i FROM Interview i WHERE i.application.user.id = :uid";
		List<Interview> interviews = em.createQuery(indexQuery, Interview.class).setParameter("uid", uid)
				.getResultList();
		return new HashSet<>(interviews);
	}

	@Override
	public Interview create(int uid, int aid, int iId, String interviewJson) {
		ObjectMapper om = new ObjectMapper();
		try {
			Interview interview = om.readValue(interviewJson, Interview.class);
			interview.setApplication(em.find(Application.class, aid));
			interview.getApplication().setUser(em.find(User.class, uid));
			interview.getResponse().setApplication(em.find(Application.class, aid));
			em.persist(interview);
			em.flush();
			return interview;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Interview show(int uid, int iId) {
		String showInterviewQuery = "SELECT i FROM Interview i WHERE i.application.user.id = :uid AND i.id = :iId";
		Interview interview = em.createQuery(showInterviewQuery, Interview.class).setParameter("uid", uid)
				.setParameter("iId", iId).getResultList().get(0);
		if (interview != null) {
			return interview;
		}
		return null;
	}

	@Override
	public Interview update(int uid, int aid, int iId, String interviewJson) {
		String updateInterviewQuery = "SELECT i FROM Interview i WHERE i.id = :iId AND i.application.id = :aid AND i.application.user.id = :uid";
		Interview interview = em.createQuery(updateInterviewQuery, Interview.class).setParameter("iId", iId)
				.setParameter("aid", aid).setParameter("uid", uid).getResultList().get(0);
		ObjectMapper om = new ObjectMapper();
		try {
			Interview omInterview = om.readValue(interviewJson, Interview.class);

			interview.setName(omInterview.getName());
			interview.setEmail(omInterview.getEmail());
			interview.setPhone(omInterview.getPhone());
			interview.setNotes(omInterview.getNotes());
			interview.setFeedback(omInterview.getFeedback());
			interview.setOfferMade(omInterview.getOfferMade());
			interview.setOfferSalary(omInterview.getOfferSalary());
			interview.setOfferLocation(omInterview.getOfferLocation());
			interview.setOfferDetails(omInterview.getOfferDetails());

			if (interview != null) {
				return interview;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean destroy(int uid, int iId) {
		try {
			String destroyInterviewQuery = "SELECT i FROM Response i WHERE i.id = :iId AND i.application.user.id = :uid";
			Interview interview = em.createQuery(destroyInterviewQuery, Interview.class).setParameter("iId", iId)
					.setParameter("uid", uid).getResultList().get(0);
			System.out.println(interview);
			em.remove(interview);
			if (em.find(Interview.class, iId) != null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
