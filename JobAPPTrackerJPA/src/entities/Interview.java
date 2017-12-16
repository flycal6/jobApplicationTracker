package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String name;
	private String email;
	private String phone;
	private String notes;
	private String feedback;
	private Boolean offerMade;
	private String offerSalary;
	private String offerLocation;
	private String offerDetails;

	/***************** Gets and Sets *************************************/

	@JsonBackReference(value = "appToInterviews")
	@ManyToOne
	@JoinColumn(name = "applicationId")
	private Application application;

	@JsonBackReference(value = "responseToInterviews")
	@ManyToOne
	@JoinColumn(name = "responseId")
	private Response response;

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Boolean getOfferMade() {
		return offerMade;
	}

	public void setOfferMade(Boolean offerMade) {
		this.offerMade = offerMade;
	}

	public String getOfferSalary() {
		return offerSalary;
	}

	public void setOfferSalary(String offerSalary) {
		this.offerSalary = offerSalary;
	}

	public String getOfferLocation() {
		return offerLocation;
	}

	public void setOfferLocation(String offerLocation) {
		this.offerLocation = offerLocation;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Interview [id=").append(id).append(", date=").append(date).append(", name=").append(name)
				.append(", email=").append(email).append(", phone=").append(phone).append(", notes=").append(notes)
				.append(", feedback=").append(feedback).append(", offerMade=").append(offerMade)
				.append(", offerSalary=").append(offerSalary).append(", offerLocation=").append(offerLocation)
				.append(", offerDetails=").append(offerDetails).append(", application=").append(application)
				.append(", response=").append(response).append("]");
		return builder.toString();
	}

}
