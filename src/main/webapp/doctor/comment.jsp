<%@page import="com.entity.Doctor"%>
<%@page import="com.mysql.cj.Session"%>
<%@page import="com.entity.User"%>
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
<title>comment</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/bc.jpg");
	height: 27vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<c:if test="${empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-4">Patient Comment</p>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
						Appointment appointment = dao.getAllAppointmentById(id);
						%>
						<form class="row" action="../updateStatus" method="post">
							<div class="col-md-6">
								<label>Patient Name</label> <input type="text" readonly
									value="<%=appointment.getFullName()%>" class="form-control">
							</div>
							<div class="col-md-6">
								<label>Age</label> <input type="number" readonly="readonly"
									value="<%=appointment.getAge()%>" class="form-control">
							</div>
							<div class="col-md-6">
								<label>Phone</label> <input type="text" readonly="readonly"
									value="<%=appointment.getPhNo()%>" class="form-control">
							</div>
							<div class="col-md-6">
								<label>Diseases</label> <input type="text" readonly="readonly"
									value="<%=appointment.getDiseases()%>" class="form-control">
							</div>
							<div class="col-md-12">
								<label>Comment</label>
								<textarea name="comment" class="form-control" rows="" cols=""></textarea>
							</div>
							<input type="hidden" name="id" value="<%=appointment.getId()%>">
							<input type="hidden" name="did"
								value="<%=appointment.getDoctorId()%>">

							<button class="mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>