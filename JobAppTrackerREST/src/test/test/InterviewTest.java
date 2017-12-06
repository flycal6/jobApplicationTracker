package test.test	;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import entities.Interview;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestPropertySource(locations = "classpath:application.properties")
public class InterviewTest {

	@Autowired
	private Interview interview;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {

		return "http://localhost:8181" + uri;
	}
	@Before
	public void test(){
	
	
	}
}
