<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Appointment Form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<script type="text/javascript" charset="utf-8">
	
	function copyValue(){
		
		var path =document.getElementById('abc').value;
		document.getElementById("FilePdf").value = path;
		
	}
	</script>
	<div class="container">
		<div class="card">
			<div class="card-header" align="center">
				<h3>Doctor's Appointment Form</h3>
			</div>
			<div class="card-body">

				<form:form action="addPatientDetails" modelAttribute="patient"
					method="POST">
					<div class="form-row">
						<div class="form-group col-md-6">
							<form:label path="name">Name</form:label>
							<form:input type="text" class="form-control" id="name"
								placeholder="Enter Name" path="name" />
						</div>
						<div class="form-group col-md-6">
							<form:label path="age">Age</form:label>
							<form:input type="text" class="form-control" id="age"
								placeholder="Enter Age" path="age"></form:input>
						</div>
						<div class="form-group col-md-6">
							<form:label path="dob">Date Of Birth</form:label>
							<form:input class="form-control" id="dob" path="dob" type="text"></form:input>
						</div>
						<div class="form-group col-md-6">
							<form:label path="bloodGroup">Blood Group</form:label>
							<form:select class="form-control" path="bloodGroup"
								id="bloodGroup" data-live-search="true" searchType="subString">
								<form:option value="0" selected="true" disabled="true">Select Blood Group</form:option>
								<form:option value="O+"> O+ </form:option>
								<form:option value="A+"> A+</form:option>
								<form:option value="B+"> B+</form:option>
								<form:option value="AB+">AB+ </form:option>
								<form:option value="O-"> O- </form:option>
								<form:option value="A-"> A-</form:option>
								<form:option value="B-"> B-</form:option>
								<form:option value="AB-">AB- </form:option>
							</form:select>
						</div>
						<div class="form-group col-md-6">
							<form:label path="address">Address</form:label>
							<form:input type="text" class="form-control" id="address"
								placeholder="Enter Address" path="address"></form:input>
						</div>
						<div class="form-group col-md-6">
							<form:label path="mobileNo">Mobile No.</form:label>
							<form:input type="text" class="form-control" id="mobileNo"
								placeholder="Enter Mobile No." path="mobileNo"></form:input>
						</div>
					</div>
					<div class="form-group col-md-6">
						<form:label path="email">Email</form:label>
						<form:input type="email" class="form-control" id="email"
							placeholder="Enter Email Address" path="email"></form:input>
					</div>

					<div class="form-group col-md-6">
						<form:label path="dateOfAppointment">Date Of Appointment</form:label>
						<form:input class="form-control" id="dateOfAppointment"
							path="dateOfAppointment" type="text"></form:input>
					</div>
					<div class="form-group col-md-6">
						<label for="abc">Browse Pdf</label> <input type="file"
							class="form-control" name="file" id='abc' onchange="copyValue()"
							title="Browse file" />
					</div>
					<div class="form-group col-md-6">
						<%-- <form:label path="FilePdf">Give pdf file path</form:label> --%>
						<form:hidden class="form-control" id="FilePdf" path="FilePdf"></form:hidden>
					</div>
					<div class="form-group col-md-6">
						<form:button type="submit" id="submit" class="btn btn-primary">Submit</form:button>
					</div>
				</form:form>

			</div>
		</div>
	</div>
</body>
</html>