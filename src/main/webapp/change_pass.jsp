<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user-password-change</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/bc.jpg");
	height: 27vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Password Change</p>
						<c:if test="${not empty success }">
							<p class="text-center text-success fs-3">${success }</p>
							<c:remove var="success" scope="session" />
						</c:if>
						<c:if test="${not empty error }">
							<p class="text-center text-danger fs-3">${error }</p>
							<c:remove var="error" scope="session" />
						</c:if>
						<form action="changePass" method="post">
							<input name="user_id" type="hidden" value="${userObj.id }" class="form-control">
							<div class="mb-3">
								<label class="form-label">Current Password</label> <input
									required name="" type="text" value="${userObj.password }"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">New Password</label> <input required
									name="" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Confirm Password</label> <input
									required name="password" type="text" class="form-control">
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Change</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>