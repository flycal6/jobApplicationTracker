package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Application;

public class ApplicationTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Application a = null;
	

	@Before
	public void setup() throws Exception {
		emf = Persistence.createEntityManagerFactory("JobAppTracker");
		em = emf.createEntityManager();
		a = em.find(Application.class, 1);
	}

	@After
	public void teardown() {
		a = null;
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		boolean bool = true;
		assertEquals(true, bool);
	}
	
	@Test
	public void applicationExistsAndHasValuesTest() {
		assertEquals(1, a.getId());
		assertEquals("Company A", a.getCompanyName());
		assertEquals("Java1CoverLetter.pdf", a.getCoverLetter());
		assertEquals("2017-11-11 15:55:45.0", String.valueOf(a.getDate()));
		assertEquals("LinkedIn, http://www.job.com", a.getAppliedVia());
		assertEquals("notes one", a.getNotes());
		assertEquals(1, a.getResponses().size());
		assertEquals(0, a.getInterviews().size());
		Application a1 = em.find(Application.class, 2);
		assertEquals(2, a1.getInterviews().size());
	}
}
