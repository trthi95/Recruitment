package com.cdweb.controller;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdweb.entity.ApplicantVacancy;
import com.cdweb.entity.InterviewerScheduleInterview;
import com.cdweb.entity.User;
import com.cdweb.entity.Vacancy;
import com.cdweb.service.ApplicantVacancyService;
import com.cdweb.service.InterviewerScheduleInterviewService;
import com.cdweb.service.UserService;
import com.cdweb.service.VacancyService;

@Controller
@RequestMapping()
public class ApplicantVacancyController {

	@Autowired
	ApplicantVacancyService applicantVacancyService;

	@Autowired
	VacancyService vacancyService;

	@Autowired
	UserService userService;

	@Autowired
	InterviewerScheduleInterviewService interviewerScheduleInterviewService;

	@RequestMapping("hr/applicantVacancy/{vacancyNumber}")
	public String pageDefault(@PathVariable String vacancyNumber, ModelMap modelMap) {
		Vacancy vacancy = vacancyService.getVacancy(vacancyNumber);
		List<ApplicantVacancy> listApplicantVacancy = applicantVacancyService.getListApplicantVacancy(vacancyNumber);
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = interviewerScheduleInterviewService
				.getListInterviewerScheduleInterview();
		Map<ApplicantVacancy, List<InterviewerScheduleInterview>> models = new HashMap<ApplicantVacancy, List<InterviewerScheduleInterview>>();
		for (ApplicantVacancy applicantVacancy : listApplicantVacancy) {
			int idSchedule = applicantVacancy.getScheduleInterviewDetails().getIdSchedule();
			listInterviewerScheduleInterview = interviewerScheduleInterviewService
					.getListInterviewerScheduleInterviewById(idSchedule);
			models.put(applicantVacancy, listInterviewerScheduleInterview);
			for (InterviewerScheduleInterview interviewerScheduleInterview : listInterviewerScheduleInterview) {
				System.out.println(interviewerScheduleInterview.getUser().getFullName());
			}

		}
		modelMap.addAttribute("vacancyNumber", vacancyNumber);
		modelMap.addAttribute("vacancies", models);

		return "applicantVacancy";
	}

	@RequestMapping("hr/applicantVacancy/{vacancyNumber}/addApplicantVacancy")
	public String pageDefaultAddApplicantVacancy(@PathVariable String vacancyNumber, ModelMap modelMap) {
		Vacancy vacancy = vacancyService.getVacancy(vacancyNumber);
		String description = vacancy.getDescription();
		modelMap.addAttribute("description", description);
		modelMap.addAttribute("vacancyNumber", vacancyNumber);
		List<User> listUser = userService.getListUserByRole();
		modelMap.addAttribute("listUser", listUser);

		List<ApplicantVacancy> listApplicantVacancy = applicantVacancyService.getListApplicantVacancy(vacancyNumber);
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = new ArrayList<InterviewerScheduleInterview>();
		for (ApplicantVacancy applicantVacancy : listApplicantVacancy) {
			int idSchedule = applicantVacancy.getScheduleInterviewDetails().getIdSchedule();
			listInterviewerScheduleInterview = interviewerScheduleInterviewService
					.getListInterviewerScheduleInterviewById(idSchedule);
			modelMap.addAttribute("listApplicantVacancy", listApplicantVacancy);
		}
		return "addApplicantVacancy";
	}

	@RequestMapping(path = "hr/applicantVacancy/{vacancyNumber}/addApplicantVacancy", method = RequestMethod.POST)
	public String addApplicantVacancy(@PathVariable String vacancyNumber, @RequestParam String applicantVacancyName,
			@RequestParam String emailApplicant, @RequestParam Date dateOnApplicantVacancy, @RequestParam String state,
			@RequestParam Date dateOfTheScheduleInterview, @RequestParam String startTime, @RequestParam String endTime,
			@RequestParam List<Integer> listIdUser, ModelMap modelMap) throws ParseException {
		System.out.println(LocalTime.parse(startTime));
		List<User> listUser = userService.getListUserByRole();
		modelMap.addAttribute("listUser", listUser);

		LocalTime localstartTime = LocalTime.parse(startTime);
		Time timeStart = Time.valueOf(localstartTime);

		LocalTime localEndTime = LocalTime.parse(endTime);
		Time timeEnd = Time.valueOf(localEndTime);

		Vacancy vacancy = vacancyService.getVacancy(vacancyNumber);
		String description = vacancy.getDescription();
		modelMap.addAttribute("description", description);
		modelMap.addAttribute("vacancyNumber", vacancyNumber);

		applicantVacancyService.addApplicantVacancy(vacancyNumber, applicantVacancyName, emailApplicant,
				dateOnApplicantVacancy, state, dateOfTheScheduleInterview, timeStart, timeEnd, listIdUser);
		return "addApplicantVacancy";
	}

	@RequestMapping("hr/applicantVacancy/{vacancyNumber}/{applicantNumber}")
	public String pageDefaultEditApplicantVacancy(@PathVariable String vacancyNumber,
			@PathVariable String applicantNumber, ModelMap modelMap) {
		Vacancy vacancy = vacancyService.getVacancy(vacancyNumber);
		ApplicantVacancy applicantVacancy = applicantVacancyService.getApplicantVacancy(applicantNumber);

		modelMap.addAttribute("vacancy", vacancy);
		modelMap.addAttribute("applicantVacancy", applicantVacancy);
		return "editApplicantVacancy";
	}

	@RequestMapping(path = "hr/applicantVacancy/{vacancyNumber}/{applicantNumber}", method = RequestMethod.POST)
	public String editApplicantVacancy(@PathVariable String vacancyNumber, @PathVariable String applicantNumber,
			@RequestParam String applicantVacancyName, @RequestParam String emailApplicant,
			@RequestParam Date dateOnApplicantVacancy, @RequestParam String state,
			@RequestParam Date dateOfTheScheduleInterview, @RequestParam String startTime, @RequestParam String endTime,
			ModelMap modelMap) {
		LocalTime localstartTime = LocalTime.parse(startTime);
		Time timeStart = Time.valueOf(localstartTime);

		LocalTime localEndTime = LocalTime.parse(endTime);
		Time timeEnd = Time.valueOf(localEndTime);
		Vacancy vacancy = vacancyService.getVacancy(vacancyNumber);

		ApplicantVacancy applicantVacancy = applicantVacancyService.editApplicantVacancy(vacancyNumber, applicantNumber,
				applicantVacancyName, emailApplicant, dateOnApplicantVacancy, state, dateOfTheScheduleInterview,
				timeStart, timeEnd);

		modelMap.addAttribute("vacancy", vacancy);
		modelMap.addAttribute("applicantVacancy", applicantVacancy);
		return "editApplicantVacancy";
	}

	@RequestMapping("applicantVacancy/{vacancyNumber}")
	public String pageDefaultInterviewer(@PathVariable String vacancyNumber, ModelMap modelMap) {
		List<ApplicantVacancy> listApplicantVacancy = applicantVacancyService.getListApplicantVacancy(vacancyNumber);
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = interviewerScheduleInterviewService
				.getListInterviewerScheduleInterview();
		Map<ApplicantVacancy, List<InterviewerScheduleInterview>> models = new HashMap<ApplicantVacancy, List<InterviewerScheduleInterview>>();
		for (ApplicantVacancy applicantVacancy : listApplicantVacancy) {
			int idSchedule = applicantVacancy.getScheduleInterviewDetails().getIdSchedule();
			listInterviewerScheduleInterview = interviewerScheduleInterviewService
					.getListInterviewerScheduleInterviewById(idSchedule);
			models.put(applicantVacancy, listInterviewerScheduleInterview);
			for (InterviewerScheduleInterview interviewerScheduleInterview : listInterviewerScheduleInterview) {
				System.out.println(interviewerScheduleInterview.getUser().getFullName());
			}
		}
		// modelMap.addAttribute("listApplicantVacancy", listApplicantVacancy);
		modelMap.addAttribute("vacancyNumber", vacancyNumber);
		// modelMap.addAttribute("listInterviewerScheduleInterview",
		// listInterviewerScheduleInterview);
		modelMap.addAttribute("vacancies", models);

		return "applicantVacancy";
	}

	@RequestMapping(path = "hr/applicantVacancy/{vacancyNumber}", method = RequestMethod.POST)
	public String delete(@PathVariable String vacancyNumber, @RequestParam int idApplicantVacancy, ModelMap modelMap) {
		System.out.println("aaaaaaaaaaa");
		applicantVacancyService.deleteApplicantVacncyById(idApplicantVacancy);
		List<ApplicantVacancy> listApplicantVacancy = applicantVacancyService.getListApplicantVacancy(vacancyNumber);
		List<InterviewerScheduleInterview> listInterviewerScheduleInterview = interviewerScheduleInterviewService
				.getListInterviewerScheduleInterview();
		Map<ApplicantVacancy, List<InterviewerScheduleInterview>> models = new HashMap<ApplicantVacancy, List<InterviewerScheduleInterview>>();
		for (ApplicantVacancy applicantVacancy : listApplicantVacancy) {
			int idSchedule = applicantVacancy.getScheduleInterviewDetails().getIdSchedule();
			listInterviewerScheduleInterview = interviewerScheduleInterviewService
					.getListInterviewerScheduleInterviewById(idSchedule);
			models.put(applicantVacancy, listInterviewerScheduleInterview);
			for (InterviewerScheduleInterview interviewerScheduleInterview : listInterviewerScheduleInterview) {
				System.out.println(interviewerScheduleInterview.getUser().getFullName());
			}

		}
		modelMap.addAttribute("vacancyNumber", vacancyNumber);
		modelMap.addAttribute("vacancies", models);

		return "applicantVacancy";
	}
	
	@ResponseBody
	@RequestMapping(path = "hr/applicantVacancy/{vacancyNumber}/{applicantNumber}/sendMail", method = RequestMethod.GET)
	public String sendMail(@PathVariable String vacancyNumber, @PathVariable String applicantNumber,
			@RequestParam String applicantVacancyName, @RequestParam String emailApplicant, @RequestParam String state,
			@RequestParam Date dateOfTheScheduleInterview, @RequestParam String startTime, @RequestParam String endTime,
			ModelMap modelMap) {
		LocalTime localstartTime = LocalTime.parse(startTime);
		Time timeStart = Time.valueOf(localstartTime);

		LocalTime localEndTime = LocalTime.parse(endTime);
		Time timeEnd = Time.valueOf(localEndTime);
		
		System.out.println(applicantVacancyName);
		
		boolean b = applicantVacancyService.sendMail(vacancyNumber, applicantNumber, applicantVacancyName, emailApplicant, state, dateOfTheScheduleInterview, timeStart, timeEnd);
		
		return b+"";

	}

}
