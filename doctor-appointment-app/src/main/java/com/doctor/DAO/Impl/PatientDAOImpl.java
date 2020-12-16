package com.doctor.DAO.Impl;


import static com.doctor.utility.SystemConstants.PATIENT_OBJECT;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctor.DAO.PatientDAO;
import com.doctor.api.Patient;

@Repository
public class PatientDAOImpl extends GenericDAO implements PatientDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//This method can be used if our primary key is auto-increamented.
	public void insertRecord(Patient patient) {
		
		String sql = "insert into patients (name,age,dob,bloodGroup,address,mobileNo,email,dateOfAppointment,FilePdf) values(?,?,?,?,?,?,?,?,?)";
		int row = jdbcTemplate.update(sql,patient.getName(),patient.getAge(),
				patient.getDob(),patient.getBloodGroup(),patient.getAddress(),
				patient.getMobileNo(),patient.getEmail(),patient.getDateOfAppointment(),
				patient.getFilePdf());
		if(row==0) {
			System.out.println("no row gets inserted");
		}else {
			System.out.println(row + " row gets inserted");
		}
	}

    //This method is used when our primary key is not auto-increamented.
	public void insertRecord2(Patient patient) {
		
		Integer intMaxValue = super.getMaxValue(PATIENT_OBJECT);
		intMaxValue+=1;
		
		try {
		        java.sql.Date dob = java.sql.Date.valueOf(patient.getDob());
		        java.sql.Date dateOfApp = java.sql.Date.valueOf(patient.getDateOfAppointment());
		        File pdfFile = new File(patient.getFilePdf());
		        byte[] pdfData = new byte[(int) pdfFile.length()];
		        DataInputStream dis = new DataInputStream(new FileInputStream(pdfFile));
		        dis.readFully(pdfData);  // read from file into byte[] array
		        dis.close();

		        String sql = "insert into patients (id,name,age,dob,bloodGroup,address,mobileNo,email,dateOfAppointment,FilePdf) values(?,?,?,?,?,?,?,?,?,?)";
				int row = jdbcTemplate.update(sql,intMaxValue,patient.getName(),patient.getAge(),
						dob,patient.getBloodGroup(),patient.getAddress(),
						patient.getMobileNo(),patient.getEmail(),dateOfApp,
						pdfData);
				if(row==0) {
					System.out.println("no row gets inserted");
				}else {
					System.out.println(row + " row gets inserted");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

    //This method is used to retrieve all the records in patients table
	public List<Patient> getRecords() {
		
		String sql = "select * from patients";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Patient> patientList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Patient.class));

		return patientList;
	}

}
