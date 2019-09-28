package com.cdweb.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.ApplicantVacancyDAO;
import com.cdweb.entity.ApplicantVacancy;

@Service
public class ApplicantVacancyServiceImp implements ApplicantVacancyService {
	@Autowired
	ApplicantVacancyDAO applicantVacancyDAO;

	public List<ApplicantVacancy> getListApplicantVacancy(String vacancyNumber) {

		return applicantVacancyDAO.getListApplicantVacancy(vacancyNumber);
	}

	public void addApplicantVacancy(String vacancyNumber, String applicantVacancyName, String emailApplicant,
			Date dateOnApplicantVacancy, String state, Date dateOfTheScheduleInterview, Time startTime,
			Time endTime, List<Integer> listIdUser) {
		applicantVacancyDAO.addApplicantVacancy(vacancyNumber, applicantVacancyName, emailApplicant,
				dateOnApplicantVacancy, state, dateOfTheScheduleInterview, startTime, endTime, listIdUser);

	}

	public ApplicantVacancy getApplicantVacancy(String applicantNumber) {
		return applicantVacancyDAO.getApplicantVacancy(applicantNumber);
	}

	public ApplicantVacancy editApplicantVacancy(String vacancyNumber, String applicantNumber,
			String applicantVacancyName, String emailApplicant, Date dateOnApplicantVacancy, String state, 
			Date dateOfTheScheduleInterview, Time startTime, Time endTime) {
		return applicantVacancyDAO.editApplicantVacancy(vacancyNumber, applicantNumber, applicantVacancyName,
				emailApplicant, dateOnApplicantVacancy, state, dateOfTheScheduleInterview, startTime, endTime);

	}

	public void deleteApplicantVacncyById(int idApplicantVacancy) {
		applicantVacancyDAO.deleteApplicantVacncyById(idApplicantVacancy);

	}

	public List<ApplicantVacancy> getListApplicantVacancy(int idApplicantVacancy) {
		return applicantVacancyDAO.getApplicantVacancy(idApplicantVacancy);
		
		
	}

	public boolean sendMail(String vacancyNumber, String applicantNumber, String applicantVacancyName,
			String emailApplicant, String state, Date dateOfTheScheduleInterview, Time startTime, Time endTime) {
		
		return applicantVacancyDAO.sendMail(vacancyNumber, applicantNumber, applicantVacancyName, emailApplicant, state, dateOfTheScheduleInterview, startTime, endTime);
	}

}
