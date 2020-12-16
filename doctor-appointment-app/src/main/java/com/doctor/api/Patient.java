package com.doctor.api;

public class Patient {
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;
	private Integer age;
	private String dob ;
	private String bloodGroup;
	private String address;
	private String mobileNo;
	private String email;
	private String dateOfAppointment;
	private String FilePdf;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFilePdf() {
		return FilePdf;
	}
	public void setFilePdf(String filePdf) {
		FilePdf = filePdf;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", bloodGroup=" + bloodGroup
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email + ", dateOfAppointment="
				+ dateOfAppointment + ", FilePdf=" + FilePdf + "]";
	}
	

}
