package com.doctor.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doctor.DAO.PatientDAO;
import com.doctor.DAO.EmailDAO;
import com.doctor.api.Patient;
import com.doctor.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientDAO patientDao;
	
	@Autowired
	EmailDAO emailDAOobj;

	
	public void insertRecord(Patient patient) {
	
		patientDao.insertRecord2(patient);
	}


	public List<Patient> getRecords() {
		
		List<Patient> patientList =patientDao.getRecords();
		
		emailDAOobj.sendEmail(patientList);
		
		return patientList;
	}

}
