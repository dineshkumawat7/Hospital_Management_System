<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit-doctor-profile</title>
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
						<p class="text-center fs-4">Doctor Profile Update</p>
						<c:if test="${not empty error}">
							<p class="fs-3 text-center text-danger">${error}</p>
							<c:remove var="failed" scope="session" />
						</c:if>
						<c:if test="${not empty success}">
							<div class="fs-3 text-center text-success" role="alert">${success}</div>
							<c:remove var="success" scope="session" />
						</c:if>
						<%
							
						%>
						<form action="../doctorUpdate" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input
									class="form-control" name="full_name" type="text">
							</div>
							<div class="mb-3">
								<label class="form-label">DOB</label> <input
									class="form-control" name="dob" type="date">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									class="form-control" name="qualification" type="text">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <input
									class="form-control" name="specialist" type="text">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input
									class="form-control" name="email" type="email">
							</div>
							<div class="mb-3">
								<label class="form-label">Phone</label> <input
									class="form-control" name="mob_no" type="number">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									class="form-control" name="password" type="text">
							</div>

							<input type="hidden" name="id" value="">
							<button class="btn btn-success col-md-12" type="submit">Update</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>