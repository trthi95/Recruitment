package com.cdweb.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "applicant_vacancy")
public class ApplicantVacancy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idApplicantVacancy;

	private String applicantNumber;
	private String applicantVacancyName;
	private String emailApplicant;

	@JoinColumn(name = "idVacancy")
	@OneToOne()
	private Vacancy vacancy;

	private Date dateOnApplicantVacancy;
	private String state;
	private String cv;

	@JoinColumn(name = "idSchedule")
	@OneToOne
	private ScheduleInterviewDetails scheduleInterviewDetails;

	@JoinColumn(name = "idApplicantVacancy")
	@OneToMany
	private List<ApplicantDetails> listApplicantDetails;

	@OneToMany
	@JoinColumn(name = "idApplicantVacancy")
	private List<Review> listReview;

	public ApplicantVacancy() {
		// TODO Auto-generated constructor stub
	}

	public int getIdApplicantVacancy() {
		return idApplicantVacancy;
	}

	public void setIdApplicantVacancy(int idApplicantVacancy) {
		this.idApplicantVacancy = idApplicantVacancy;
	}

	public String getApplicantNumber() {
		return applicantNumber;
	}

	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
	}

	public String getApplicantVacancyName() {
		return applicantVacancyName;
	}

	public void setApplicantVacancyName(String applicantVacancyName) {
		this.applicantVacancyName = applicantVacancyName;
	}

	public String getEmailApplicant() {
		return emailApplicant;
	}

	public void setEmailApplicant(String emailApplicant) {
		this.emailApplicant = emailApplicant;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public Date getDateOnApplicantVacancy() {
		return dateOnApplicantVacancy;
	}

	public void setDateOnApplicantVacancy(Date dateOnApplicantVacancy) {
		this.dateOnApplicantVacancy = dateOnApplicantVacancy;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public ScheduleInterviewDetails getScheduleInterviewDetails() {
		return scheduleInterviewDetails;
	}

	public void setScheduleInterviewDetails(ScheduleInterviewDetails scheduleInterviewDetails) {
		this.scheduleInterviewDetails = scheduleInterviewDetails;
	}

	public List<ApplicantDetails> getListApplicantDetails() {
		return listApplicantDetails;
	}

	public void setListApplicantDetails(List<ApplicantDetails> listApplicantDetails) {
		this.listApplicantDetails = listApplicantDetails;
	}

	public List<Review> getListReview() {
		return listReview;
	}

	public void setListReview(List<Review> listReview) {
		this.listReview = listReview;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicantNumber == null) ? 0 : applicantNumber.hashCode());
		result = prime * result + ((applicantVacancyName == null) ? 0 : applicantVacancyName.hashCode());
		result = prime * result + ((cv == null) ? 0 : cv.hashCode());
		result = prime * result + ((dateOnApplicantVacancy == null) ? 0 : dateOnApplicantVacancy.hashCode());
		result = prime * result + ((emailApplicant == null) ? 0 : emailApplicant.hashCode());
		result = prime * result + idApplicantVacancy;
		result = prime * result + ((listApplicantDetails == null) ? 0 : listApplicantDetails.hashCode());
		result = prime * result + ((listReview == null) ? 0 : listReview.hashCode());
		result = prime * result + ((scheduleInterviewDetails == null) ? 0 : scheduleInterviewDetails.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((vacancy == null) ? 0 : vacancy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicantVacancy other = (ApplicantVacancy) obj;
		if (applicantNumber == null) {
			if (other.applicantNumber != null)
				return false;
		} else if (!applicantNumber.equals(other.applicantNumber))
			return false;
		if (applicantVacancyName == null) {
			if (other.applicantVacancyName != null)
				return false;
		} else if (!applicantVacancyName.equals(other.applicantVacancyName))
			return false;
		if (cv == null) {
			if (other.cv != null)
				return false;
		} else if (!cv.equals(other.cv))
			return false;
		if (dateOnApplicantVacancy == null) {
			if (other.dateOnApplicantVacancy != null)
				return false;
		} else if (!dateOnApplicantVacancy.equals(other.dateOnApplicantVacancy))
			return false;
		if (emailApplicant == null) {
			if (other.emailApplicant != null)
				return false;
		} else if (!emailApplicant.equals(other.emailApplicant))
			return false;
		if (idApplicantVacancy != other.idApplicantVacancy)
			return false;
		if (listApplicantDetails == null) {
			if (other.listApplicantDetails != null)
				return false;
		} else if (!listApplicantDetails.equals(other.listApplicantDetails))
			return false;
		if (listReview == null) {
			if (other.listReview != null)
				return false;
		} else if (!listReview.equals(other.listReview))
			return false;
		if (scheduleInterviewDetails == null) {
			if (other.scheduleInterviewDetails != null)
				return false;
		} else if (!scheduleInterviewDetails.equals(other.scheduleInterviewDetails))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (vacancy == null) {
			if (other.vacancy != null)
				return false;
		} else if (!vacancy.equals(other.vacancy))
			return false;
		return true;
	}
	
	
}
