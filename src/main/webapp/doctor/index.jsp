<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doctor-dashboard</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

	<c:if test="${empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<p class="text-center fs-3">Doctor Dashboard</p>
	<div class="row">
		<div class="col-md-4 offset-md-2">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fas fa-user-md fa-3x"></i><br>
					<p class="fs-4 text-center">
						<%
						DoctorDao dao = new DoctorDao(DBConnect.getConn());
						%>
						Doctor <br>
						<%=dao.countDoctor()%>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="far fa-calendar-check fa-3x"></i><br>
					<p class="fs-4 text-center">
						<%
						Appointment appointment = new Appointment();
						int id = appointment.getId();
						int doctor_id = appointment.getDoctorId();
						AppointmentDao dao2 = new AppointmentDao(DBConnect.getConn());
						%>
						Total Appointment <br>
						<%=dao2.countDoctorByAppointment(id, doctor_id)%>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>