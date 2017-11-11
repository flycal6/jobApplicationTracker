package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Interview;

public class InterviewTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Interview i = null;
	

	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("JobAppTracker");
		em = emf.createEntityManager();
		i = em.find(Interview.class, 1);
	}

	@After
	public void teardown() {
		i = null;
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
	public void interviewExistsAndHasValuesTest() {
		assertEquals(1, i.getId());
		assertEquals("Dick Dickers", i.getName());
		assertEquals("ag1CoverLetter.pdf", i.getApplication().getCoverLetter());
		assertEquals("2017-12-01 13:00:00.0", String.valueOf(i.getDate()));
		assertEquals("boss@companyb.com", i.getApplication().getAppliedVia());
		assertEquals("notes two", i.getApplication().getNotes());
		assertEquals("made a follow up interview", i.getNotes());
		assertEquals("dick@companyb.com", i.getEmail());
		assertEquals(false, i.getOfferMade());
		assertEquals(null, i.getOfferSalary());
		assertEquals(2, i.getResponse().getId());
		Interview i1 = em.find(Interview.class, 2);
		assertEquals(2, i1.getResponse().getId());
		assertEquals(true, i1.getOfferMade());
		assertEquals("65k/year", i1.getOfferSalary());
	}
}
