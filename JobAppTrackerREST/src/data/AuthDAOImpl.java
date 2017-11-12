package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.User;

@Repository
@Transactional
public class AuthDAOImpl implements AuthDAO {


	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User u) {
		 String encrypedPW = encoder.encode(u.getPassword());
		 u.setPassword(encrypedPW);
		 em.persist(u);
		 em.flush();
		return u;
	}

	@Override
	public User login(User u) {
		String query = "SELECT u FROM User u WHERE u.email = :email";
		List<User> users = em.createQuery(query, User.class)
					.setParameter("email", u.getEmail())
					.getResultList();
		
		if(users.size() > 0) {
			boolean doMatch = encoder.matches(u.getPassword(), users.get(0).getPassword());
			if(doMatch) {
				return users.get(0);
			}
		}
		return null;
	}

}
