package com.cdweb.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.cdweb.entity.ApplicantVacancy;

public interface ApplicantVacancyService {
	public List<ApplicantVacancy> getListApplicantVacancy(String vacancyNumber);
	public List<ApplicantVacancy> getListApplicantVacancy(int idApplicantVacancy);

	public void addApplicantVacancy(String vacancyNumber, String applicantVacancyName, String emailApplicant,
			Date dateOnApplicantVacancy, String state, Date dateOfTheScheduleInterview, Time startTime,
			Time endTime, List<Integer> listIdUser);

	public ApplicantVacancy getApplicantVacancy(String applicantNumber);

	public ApplicantVacancy editApplicantVacancy(String vacancyNumber, String applicantNumber, String applicantVacancyName,
			String emailApplicant, Date dateOnApplicantVacancy, String state,
			Date dateOfTheScheduleInterview, Time startTime, Time endTime);
	
	public void deleteApplicantVacncyById(int idApplicantVacancy);
	public boolean sendMail(String vacancyNumber, String applicantNumber, String applicantVacancyName,
			String emailApplicant, String state, Date dateOfTheScheduleInterview, Time startTime, Time endTime);
}
