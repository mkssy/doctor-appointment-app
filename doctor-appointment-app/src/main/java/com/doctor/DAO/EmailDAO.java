package com.doctor.DAO;

import java.util.List;
import com.doctor.api.Patient;

public interface EmailDAO {
	
	 void sendEmail(List<Patient> patientList);

}
