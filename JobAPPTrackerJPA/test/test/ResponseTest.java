package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Response;

public class ResponseTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Response r = null;
	

	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("JobAppTracker");
		em = emf.createEntityManager();
		r = em.find(Response.class, 1);
	}

	@After
	public void teardown() {
		r = null;
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		boolean bool = true;
		assertEquals(true, bool);
	}
	
	@Test
	public void responseExistsAndHasValuesTest() {
		assertEquals(1, r.getId());
		assertEquals(1, r.getApplication().getId());
		assertEquals(false, r.getInterviewRequested());
		assertEquals("2017-11-11 17:24:16.0", String.valueOf(r.getDate()));
		assertEquals("Bob Bobbers", r.getName());
		assertEquals("a polite decline", r.getNotes());
	}

}
