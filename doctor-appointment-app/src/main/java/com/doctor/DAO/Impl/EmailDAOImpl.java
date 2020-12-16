package com.doctor.DAO.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Repository;
import com.doctor.DAO.EmailDAO;
import com.doctor.api.Patient;

@Repository
public class EmailDAOImpl implements EmailDAO {
	
	@Autowired
	JavaMailSenderImpl javaMailSenderImpl;
	
	static int token=1;

	@Override
	public void sendEmail(List<Patient> patientList) {
		
			 Date  currentDate = new Date();
			 for (int i = 0; i < patientList.size(); i++) {
				 Date apDate = new Date();
				 try {
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 apDate = formatter.parse(patientList.get(i).getDateOfAppointment());
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
				
				  if((currentDate.getDate() == apDate.getDate()) && (currentDate.getMonth() == apDate.getMonth()) && (currentDate.getYear() == apDate.getYear())){
					  token =token++;
					  SimpleMailMessage mailMessage = new SimpleMailMessage();
					  mailMessage.setTo(patientList.get(i).getEmail());
					  mailMessage.setSubject("Regarding Doctor Appointment");
					  mailMessage.setText("Hi "+patientList.get(i).getName()+", you have an appointment with Dr. Mrs. Leela Awachat today.And your Token no. is "+token+". Please go through our website and check notice board to check the timing for your token number.Our website is 'http://localhost:8080/doctor-appointment-app/'.");
					  javaMailSenderImpl.send(mailMessage);
					  System.out.println("Check your email");
					  
				  }
			 }
		
	}

}
