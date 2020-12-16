package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doctor.api.Patient;
import com.doctor.service.PatientService;

@Controller
public class PateintController {

	@Autowired
	PatientService patientService;

	@GetMapping("/getAppointmentFormPage")
	public String getPatientPage(Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "patient";
	}

//This is PRG-Post Redirect Get Design Pattern
	@PostMapping(value="/addPatientDetails")
	public String insertRecord(@ModelAttribute Patient patient) {

		System.out.println(patient);
		
		patientService.insertRecord(patient);
		return "redirect:/getSuccessPage";
	

	}
	
	
	
	@ResponseBody
	@RequestMapping("/getPatientDetails")
	public List<Patient> getRecords() {

		List <Patient> patientList = patientService.getRecords();
		for(Patient p:patientList) {
			System.out.println(p);
		}
		return patientList;

	}
	
	@GetMapping("/getSuccessPage")
	public String getSuccessPage() {
		
		return "success";
	}
	

}
