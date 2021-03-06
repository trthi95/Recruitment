package com.cdweb.dao;

import java.util.List;

import com.cdweb.entity.Vacancy;

public interface VacancyDAO {
	public List<Vacancy> getListVacancy();

	public void addVacancy(String positionName, int numberOpening, String departmentName, String requirement,
			String description, String offer, int experience, String gender, String degree);
	
	public Vacancy getVacancy(String vacancyNumber);
	
	public void deleteVacancyById(int idVacancy);
}
