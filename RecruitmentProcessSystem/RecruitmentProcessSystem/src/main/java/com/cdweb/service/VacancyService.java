package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.VacancyDAO;
import com.cdweb.entity.Vacancy;

public interface VacancyService {

	public List<Vacancy> getListVacancy();

	public void addVacancy(String positionName, int numberOpening, String departmentName, String requirement,
			String description, String offer, int experience, String gender, String degree);
	
	public Vacancy getVacancy(String vacancyNumber);
	
	public void deleteVacancyById(int idVacancy);

}
