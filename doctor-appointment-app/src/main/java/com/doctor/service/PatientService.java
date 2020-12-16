package com.doctor.service;

import java.util.List;

import com.doctor.api.Patient;

public interface PatientService {
	
	public void insertRecord(Patient patient);

	public List<Patient> getRecords();

}
