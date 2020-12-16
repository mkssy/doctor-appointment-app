<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Welcome Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<h2 align="center">Welcome to our Website</h2>



<div id="DoctorMsgDiv">
	<marquee id="DoctorMsg" style="font-size: 15px; color: red;"
		width="100%" direction="left" onmouseover="this.stop();"
		onmouseout="this.start();"></marquee>

</div>

<script type="text/javascript">
	window.onload = function() {

		$.getJSON("getPatientDetails", function(data) {
			var currentDate = new Date();
			var apDate;
			var appointmentDayMsg = 'Hello You have  an Appointment today  ';
			$('#DoctorMsgDiv').hide();

			for (i = 0; i < data.length; i++) {
				apDate = new Date(data[i].dateOfAppointment);
				if ((currentDate.getDate() == apDate.getDate())
						&& (currentDate.getMonth() == apDate.getMonth())
						&& (currentDate.getYear() == apDate.getYear())) {
					$('#DoctorMsgDiv').show();
					appointmentDayMsg += data[i].name + " ,  ";
				}
			}
			appointmentDayMsg = appointmentDayMsg.substring(0,
					appointmentDayMsg.length - 3)
			$('#DoctorMsg').text(appointmentDayMsg);
		});

	};
</script>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="http://localhost:8080/doctor-appointment-app/getAppointmentFormPage">Click
					Here to Book Your Appointment!</a>
			</div>
		</div>
	</nav>
	<div class="form-group">

		<textarea name="" rows="15" cols="50" readonly>
Notice Board:
Doctor is available from 10 AM to 12 PM for Monday to Saturday.
Sunday will be off.
These are the timings for your Token Number.
Token Number(1) = 10:00 AM to 10:15 AM
Token Number(2) = 10:15 AM to 10:30 AM
Token Number(3) = 10:30 AM to 10:45 AM
Token Number(4) = 10:45 AM to 11:00 AM
Token Number(5) = 11:00 AM to 11:15 AM
Token Number(6) = 11:15 AM to 11:30 AM
Token Number(7) = 11:30 AM to 11:45 AM
Token Number(8) = 11:45 AM to 10:00 PM
Please come 5 minutes prior to your timing slot.
</textarea>
	</div>
</body>
</html>
