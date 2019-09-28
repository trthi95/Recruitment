package com.cdweb.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "vacancy")
public class Vacancy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacancy;

	private String vacancyNumber;
	private Timestamp dateCreated;

	@JoinColumn(name = "idUser")
	@OneToOne
	private User user;

	private String state;

	@JoinColumn(name = "idPosition")
	@OneToOne
	private Position position;

	private String description;
	private int numberOpening;

	@JoinColumn(name = "idDepartment")
	@OneToOne
	private Department department;

	private Timestamp dateClose;
	
	private String requirement;
	private String offer;
	private int experience;
	private boolean gender;
	private String degree;
	private String typeOfStaff;;
	
	@JoinColumn(name="idVacancy")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ApplicantVacancy> listApplicantVacancy;

	public Vacancy() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVacancy() {
		return idVacancy;
	}

	public void setIdVacancy(int idVacancy) {
		this.idVacancy = idVacancy;
	}

	public String getVacancyNumber() {
		return vacancyNumber;
	}

	public void setVacancyNumber(String vacancyNumber) {
		this.vacancyNumber = vacancyNumber;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOpening() {
		return numberOpening;
	}

	public void setNumberOpening(int numberOpening) {
		this.numberOpening = numberOpening;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Timestamp getDateClose() {
		return dateClose;
	}

	public void setDateClose(Timestamp dateClose) {
		this.dateClose = dateClose;
	}

	public List<ApplicantVacancy> getListApplicantVacancy() {
		return listApplicantVacancy;
	}

	public void setListApplicantVacancy(List<ApplicantVacancy> listApplicantVacancy) {
		this.listApplicantVacancy = listApplicantVacancy;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTypeOfStaff() {
		return typeOfStaff;
	}

	public void setTypeOfStaff(String typeOfStaff) {
		this.typeOfStaff = typeOfStaff;
	}

}
