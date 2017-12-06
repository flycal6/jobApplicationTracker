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
import entities.Response;
import entities.User;

@Repository
@Transactional
public class ResponseDAOImpl implements ResponseDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Response> index(int uid) {
		String q = "SELECT r FROM Response r WHERE r.application.user.id = :uid";
		List<Response> responses = em.createQuery(q, Response.class).setParameter("uid", uid).getResultList();
		return new HashSet<>(responses);
	}

	@Override
	public Response show(int uid, int rid) {
		String q = "SELECT r FROM Response r WHERE r.application.user.id = :uid AND r.id = :rid";
		Response r = em.createQuery(q, Response.class).setParameter("uid", uid).setParameter("rid", rid).getResultList()
				.get(0);
		if (r != null) {
			return r;
		}
		return null;
	}

	@Override
	public Response create(int uid, int aid, String responseJson) {
		ObjectMapper om = new ObjectMapper();
		try {
			Response r = om.readValue(responseJson, Response.class);
			r.setApplication(em.find(Application.class, aid));
			r.getApplication().setUser(em.find(User.class, uid));
			em.persist(r);
			em.flush();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Response update(int uid, int aid, int rid, String responseJson) {
		String q = "SELECT r FROM Response r WHERE r.id = :rid AND r.application.id = :aid AND r.application.user.id = :uid";
		Response r = em.createQuery(q, Response.class).setParameter("rid", rid).setParameter("aid", aid)
				.setParameter("uid", uid).getResultList().get(0);
		ObjectMapper om = new ObjectMapper();
		try {
			Response omr = om.readValue(responseJson, Response.class);
			r.setDate(omr.getDate());
			r.setEmail(omr.getEmail());
			r.setInterviewRequested(omr.getInterviewRequested());
			r.setName(omr.getName());
			r.setPhone(omr.getPhone());
			r.setNotes(omr.getNotes());

			if (r != null) {
				return r;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean destroy(int uid, int rid) {
		try {
			String q = "SELECT r FROM Response r WHERE r.id = :rid AND r.application.user.id = :uid";
			Response r = em.createQuery(q, Response.class).setParameter("rid", rid).setParameter("uid", uid)
					.getResultList().get(0);
			System.out.println(r);
			em.remove(r);
			if (em.find(Response.class, rid) != null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
