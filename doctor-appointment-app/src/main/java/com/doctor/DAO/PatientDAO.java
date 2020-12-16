package com.doctor.DAO;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.doctor.api.Patient;

public interface PatientDAO {

	@Transactional
	public void insertRecord(Patient patient);
	
	@Transactional
	public void insertRecord2(Patient patient);

	
	public List<Patient> getRecords();

}
