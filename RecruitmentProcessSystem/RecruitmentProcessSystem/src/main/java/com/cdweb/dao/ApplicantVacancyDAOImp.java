package com.cdweb.dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;

import com.cdweb.entity.ApplicantVacancy;
import com.cdweb.entity.InterviewerScheduleInterview;
import com.cdweb.entity.ScheduleInterviewDetails;
import com.cdweb.entity.User;
import com.cdweb.entity.UserRole;
import com.cdweb.entity.Vacancy;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicantVacancyDAOImp implements ApplicantVacancyDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ApplicantVacancy> getListApplicantVacancy(String vacancyNumber) {
		Session session = sessionFactory.getCurrentSession();
		Vacancy vacancy = (Vacancy) session.createQuery("from vacancy where vacancyNumber = '" + vacancyNumber + "'")
				.getSingleResult();
		int idVacancy = vacancy.getIdVacancy();

		List<ApplicantVacancy> listApplicantVacancy = session
				.createQuery("from ApplicantVacancy where idVacancy = '" + idVacancy + "' order by idApplicantVacancy")
				.getResultList();

		return listApplicantVacancy;
	}

	@Transactional
	public void addApplicantVacancy(String vacancyNumber, String applicantVacancyName, String emailApplicant,
			Date dateOnApplicantVacancy, String state, Date dateOfTheScheduleInterview, Time startTime,
			Time endTime, List<Integer> listIdUser) {
		Session session = sessionFactory.getCurrentSession();
		Vacancy vacancy = (Vacancy) session.createQuery("from vacancy where vacancyNumber = '" + vacancyNumber + "'")
				.getSingleResult();
		if (vacancy.getNumberOpening() > 0 && vacancy.getState().equals("Open")) {
			if (dateOfTheScheduleInterview.compareTo(Date.valueOf(LocalDate.now())) > 0) {
				if (endTime.compareTo(startTime) > 0) {
					ScheduleInterviewDetails scheduleInterviewDetails = new ScheduleInterviewDetails();
					scheduleInterviewDetails.setDateOfTheScheduleInterview(dateOfTheScheduleInterview);
					scheduleInterviewDetails.setStartTime(startTime);
					scheduleInterviewDetails.setEndTime(endTime);
					session.save(scheduleInterviewDetails);

					System.out.println("bbbbbb");
					ApplicantVacancy applicantVacancy = new ApplicantVacancy();
//					int sum = (Integer) session.createQuery("select sum(idApplicantVacancy) from ApplicantVacancy").getSingleResult();
//					System.out.println(sum + "aaaaaaaa");
					int maxId = (Integer) session.createQuery("select max(idApplicantVacancy) from ApplicantVacancy")
							.getSingleResult();
					
					applicantVacancy.setApplicantNumber("A" + (maxId + 1));
					applicantVacancy.setApplicantVacancyName(applicantVacancyName);
					applicantVacancy.setEmailApplicant(emailApplicant);
					applicantVacancy.setVacancy(vacancy);
					applicantVacancy.setDateOnApplicantVacancy(dateOnApplicantVacancy);
					applicantVacancy.setState(state);
					applicantVacancy.setScheduleInterviewDetails(scheduleInterviewDetails);
					session.save(applicantVacancy);
//
//					ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
//					MailSender mailSender = (MailSender) context.getBean("mailSender2");
//					SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//					simpleMailMessage.setFrom("trthi95@gmail.com");
//					simpleMailMessage.setTo(emailApplicant);
//					simpleMailMessage.setSubject(vacancy.getDescription());
//					simpleMailMessage.setText("moi ban " + applicantVacancyName + " toi phong van vao " + startTime
//							+ " " + dateOfTheScheduleInterview);
//					mailSender.send(simpleMailMessage);
//					System.out.println("sending successful");
//					context.close();

					for (int idUser : listIdUser) {
						User user = (User) session.createQuery("from user where idUser = '" + idUser + "'")
								.getSingleResult();
						InterviewerScheduleInterview interviewer = new InterviewerScheduleInterview();
						interviewer.setScheduleInterviewDetails(scheduleInterviewDetails);
						interviewer.setUser(user);
						session.save(interviewer);
					}
				}
			}
		}
	}

	@Transactional
	public ApplicantVacancy getApplicantVacancy(String applicantNumber) {
		Session session = sessionFactory.getCurrentSession();
		ApplicantVacancy applicantVacancy = (ApplicantVacancy) session
				.createQuery("from ApplicantVacancy where applicantNumber = '" + applicantNumber + "'")
				.getSingleResult();

		return applicantVacancy;
	}

	@Transactional
	public ApplicantVacancy editApplicantVacancy(String vacancyNumber, String applicantNumber,
			String applicantVacancyName, String emailApplicant, Date dateOnApplicantVacancy, String state,
			Date dateOfTheScheduleInterview, Time startTime, Time endTime) {
		Session session = sessionFactory.getCurrentSession();
		ApplicantVacancy applicantVacancy = (ApplicantVacancy) session
				.createQuery("from ApplicantVacancy where applicantNumber = '" + applicantNumber + "'")
				.getSingleResult();
		Vacancy vacancy = (Vacancy) session.createQuery("from vacancy where vacancyNumber = '" + vacancyNumber + "'")
				.getSingleResult();
		ScheduleInterviewDetails scheduleInterviewDetails = applicantVacancy.getScheduleInterviewDetails();
		if (dateOfTheScheduleInterview.compareTo(Date.valueOf(LocalDate.now())) > 0) {
			if (endTime.compareTo(startTime) > 0) {
				scheduleInterviewDetails.setDateOfTheScheduleInterview(dateOfTheScheduleInterview);
				scheduleInterviewDetails.setStartTime(startTime);
				scheduleInterviewDetails.setEndTime(endTime);
				session.update(scheduleInterviewDetails);

				applicantVacancy.setApplicantVacancyName(applicantVacancyName);
				applicantVacancy.setEmailApplicant(emailApplicant);
				applicantVacancy.setDateOnApplicantVacancy(dateOnApplicantVacancy);
				applicantVacancy.setState(state);
				if (state.equals("Hired")) {
					vacancy.setNumberOpening(vacancy.getNumberOpening() - 1);
					session.update(vacancy);
				}
				session.update(applicantVacancy);

			}
		}
		return applicantVacancy;
	}

	@Transactional
	public ApplicantVacancy getApplicantVacancyByIdSchedule(int IdSchedule) {
		Session session = sessionFactory.getCurrentSession();

		return (ApplicantVacancy) session.createQuery(
				"from InterviewerScheduleinterview join ScheduleInterviewDetails on ScheduleInterviewDetails.idSchedule = InterviewerScheduleInterview.idSchedule join ApplicantVacancy on ApplicantVacancy.idSchedule = ScheduleInterviewDetails.idSchedule where InterviewerScheduleInterview.idSchedule = '"
						+ IdSchedule + "'")
				.getSingleResult();
	}

	@Transactional
	public void deleteApplicantVacncyById(int idApplicantVacancy) {
		Session session = sessionFactory.getCurrentSession();
		ApplicantVacancy applicantVacancy = (ApplicantVacancy) session
				.createQuery("from ApplicantVacancy where idApplicantVacancy = '" + idApplicantVacancy + "'")
				.getSingleResult();
		session.delete(applicantVacancy);
	}

	@Transactional
	public List<ApplicantVacancy> getApplicantVacancy(int idApplicantVacancy) {
		Session session = sessionFactory.getCurrentSession();
		ApplicantVacancy applicantVacancy = (ApplicantVacancy) session
				.createQuery("from ApplicantVacancy where idApplicantVacancy = '" + idApplicantVacancy + "'")
				.getSingleResult();
		String vacancyNumber = applicantVacancy.getVacancy().getVacancyNumber();
		Vacancy vacancy = (Vacancy) session.createQuery("from vacancy where vacancyNumber = '" + vacancyNumber + "'")
				.getSingleResult();
		int idVacancy = vacancy.getIdVacancy();

		List<ApplicantVacancy> listApplicantVacancy = session
				.createQuery("from ApplicantVacancy where idVacancy = '" + idVacancy + "' order by idApplicantVacancy")
				.getResultList();
		
		return listApplicantVacancy;
	}

	@Transactional
	public boolean sendMail(String vacancyNumber, String applicantNumber, String applicantVacancyName, String emailApplicant, String state,
			Date dateOfTheScheduleInterview, Time startTime, Time endTime) {
		Session session = sessionFactory.getCurrentSession();
		Vacancy vacancy = (Vacancy) session.createQuery("from vacancy where vacancyNumber = '" + vacancyNumber + "'")
				.getSingleResult();
		if (state.equals("Inprocess")) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			MailSender mailSender = (MailSender) context.getBean("mailSender2");
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("trthi95@gmail.com");
			simpleMailMessage.setTo(emailApplicant);
			simpleMailMessage.setSubject(vacancy.getDescription());
			simpleMailMessage.setText("moi ban " + applicantVacancyName + " toi phong van vao " + startTime
					+ " " + dateOfTheScheduleInterview);
			mailSender.send(simpleMailMessage);
			System.out.println("sending successful");
			context.close();
			return true;
		}else if (state.equals("Hired")) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
			MailSender mailSender = (MailSender) context.getBean("mailSender2");
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("trthi95@gmail.com");
			simpleMailMessage.setTo(emailApplicant);
			simpleMailMessage.setSubject(vacancy.getDescription());
			simpleMailMessage.setText("Chuc mung ban " + applicantVacancyName + " da dau phong van vao cong ty cua chung toi");
			mailSender.send(simpleMailMessage);
			System.out.println("sending successful");
			context.close();
			return true;
		}
		return false;
	}

}
