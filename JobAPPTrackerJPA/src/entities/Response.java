package entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String name;
	private String email;
	private String phone;
	private Boolean interviewRequested;
	private String notes;

	@ManyToOne
	@JoinColumn(name = "applicationId")
	private Application application;
	
	@OneToMany(mappedBy="response")
	private Set<Interview> interviews;

	/***************** Gets and Sets *************************************/

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getInterviewRequested() {
		return interviewRequested;
	}

	public void setInterviewRequested(Boolean interviewRequested) {
		this.interviewRequested = interviewRequested;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [id=").append(id).append(", date=").append(date).append(", name=").append(name)
				.append(", email=").append(email).append(", phone=").append(phone).append(", interviewRequested=")
				.append(interviewRequested).append(", notes=").append(notes).append(", application=")
				.append(application).append("]");
		return builder.toString();
	}

}
