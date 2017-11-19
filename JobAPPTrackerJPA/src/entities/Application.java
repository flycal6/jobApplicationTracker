package entities;
/*
 * Add the following fields
 * job title
 * currently hiring
 * link to description
 * contact name
 * contact email
 * referral contact
 * change appliedVia to 'source'
 * interest level
 * follow up
 */
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String companyName;
	private String jobLocation;
	private String appliedVia;
	private String resume;
	private String coverLetter;
	private String notes;

	@JsonManagedReference(value="appToResponses")
	@OneToMany(mappedBy = "application", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private Set<Response> responses;

	@JsonManagedReference(value="appToInterviews")
	@OneToMany(mappedBy = "response", cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private Set<Interview> interviews;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	/***************** Gets and Sets *************************************/

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getAppliedVia() {
		return appliedVia;
	}

	public void setAppliedVia(String appliedVia) {
		this.appliedVia = appliedVia;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public Set<Response> getResponses() {
		return responses;
	}

	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Application [id=").append(id).append(", date=").append(date).append(", companyName=")
				.append(companyName).append(", jobLocation=").append(jobLocation).append(", appliedVia=")
				.append(appliedVia).append(", resume=").append(resume).append(", coverLetter=").append(coverLetter)
				.append(", notes=").append(notes).append("]");
		return builder.toString();
	}

}
