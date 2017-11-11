package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;

public class UserTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private User u = null;

	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("JobAppTracker");
		em = emf.createEntityManager();
		u = em.find(User.class, 1);
	}

	@After
	public void teardown() {
		u = null;
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		boolean bool = true;
		assertEquals(true, bool);
		assertFalse(bool != true);
	}

	@Test
	public void userExistsAndHasValuesTest() {
		assertEquals(1, u.getId());
		assertEquals("bob", u.getPassword());
		assertEquals("bob@bob.com", u.getEmail());
	}

}
