<%@page import="com.entity.Doctor"%>
<%@page import="com.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DoctorDao"%>
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
<title>patient</title>
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
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty failed}">
							<p class="fs-3 text-center text-danger">${failed}</p>
							<c:remove var="failed" scope="session" />
						</c:if>
						<c:if test="${not empty success}">
							<div class="fs-3 text-center text-success" role="alert">${success}</div>
							<c:remove var="success" scope="session" />
						</c:if>

						<table class="table">

							<thead>

								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Diseases</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor doctor = (Doctor) session.getAttribute("doctorObj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
								DoctorDao doctorDao = new DoctorDao(DBConnect.getConn());
								List<Appointment> list = dao.getAllAppointmentByDoctorLogin(doctor.getId());
								for (Appointment appointment : list) {
								%>
								<tr>
									<th><%=appointment.getFullName()%></th>
									<th><%=appointment.getGender()%></th>
									<th><%=appointment.getAge()%></th>
									<th><%=appointment.getAppoinDate()%></th>
									<th><%=appointment.getEmail()%></th>
									<th><%=appointment.getPhNo()%></th>
									<th><%=appointment.getDiseases()%></th>
									<th><%=appointment.getStatus()%></th>
									<th>
										<%
										if ("Pending".equals(appointment.getStatus())) {
										%> <a href="comment.jsp?id=<%=appointment.getId()%>"
										class="btn btn-success btn-sm">Comment</a> <%
										 } else {
										 %> 
										 <a href="#"
										class="btn btn-success btn-sm disabled">Commented</a>
										 <%
										 }
										 %>
									</th>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>