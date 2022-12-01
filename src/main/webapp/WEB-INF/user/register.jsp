<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Register</title>
	<%--Font Awesome--%>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
	<!-- MDB -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.css" rel="stylesheet"/>
	<link rel="stylesheet" href="css/register.css">
</head>
<body>
<section class="vh-100 bg-image"
	style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
	<div class="mask d-flex align-items-center h-100 gradient-custom-3">
		<div class="container h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-9 col-lg-7 col-xl-6">
					<div class="card" style="border-radius: 15px;">
						<div class="card-body p-5 register-page">
							<h2 class="text-uppercase text-center mb-5">Register</h2>

							<form:form action="/action-register" modelAttribute="taikhoan" class="book-depature-6 signin-form" method="post">
								<c:if test="${not empty errors|| not empty errortk }">
									<p style="color: red">**Username is existed</p>
								</c:if>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Username</label>
										</div>
										<div class="col-9">
											<form:input path="tenDangNhap" type="text" placeholder="Username"
													id="form3Example1cg" class="form-control form-control-lg" required="Yes"></form:input>
										</div>
									</div>
								</div>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Password</label>
										</div>
										<div class="col-9">
											<form:input path="matKhau" type="password" placeholder="Password" cssStyle="height: 48px"
													id="form3Example2cg" class="form-control form-control" required="Yes"></form:input>
										</div>
									</div>
								</div>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Full Name</label>
										</div>
										<div class="col-9">
											<form:input path="hoTen" type="text" placeholder="Full Name"
													id="form3Example3cg" class="form-control form-control-lg" required="Yes"></form:input>
										</div>
									</div>
								</div>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Date Of Birth</label>
										</div>
										<div class="col-9">
											<form:input path="ngaySinh" type="date" max="9999-12-31" value="2021-01-01"
													id="form3Example4cg" class="form-control form-control-lg" required="Yes"></form:input>
										</div>
									</div>
								</div>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Phone Number</label>
										</div>
										<div class="col-9">
											<form:input path="soDT" type="text" oninput="checkMaxLenghtNumber(this,10)" minlength="9"
													placeholder="Phone Number" id="form3Example4cg" class="form-control form-control-lg" required="Yes"></form:input>
										</div>
									</div>
								</div>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Email</label>
										</div>
										<div class="col-9">
											<form:input path="Email" type="email" placeholder="Email"
													id="form3Example5cg" class="form-control form-control-lg" required="Yes"></form:input>
										</div>
									</div>
								</div>

								<div class="form-outline mb-4">
									<div class="row">
										<div class="col-3">
											<label class="form-label">Gender</label>
										</div>
										<div class="col-9">
											<form:select class="form-select form-select-lg" path="gioiTinh">
												<form:option value="Male">Male</form:option>
												<form:option value="Female">Female</form:option>
											</form:select>
										</div>
									</div>
								</div>

								<div class="d-none">
									<form:input class="form-control" path="chucVu.maChucVu" value="3"></form:input>
								</div>

								<div class="d-flex justify-content-center">
									<button type="submit" style="color: whitesmoke; "
										class="btn btn-success btn-block btn-lg gradient-custom-4">Register</button>
								</div>

								<p class="text-center text-muted mt-5 mb-0"><a href="/" class="fw-bold text-body"><u>Go back</u></a></p>

							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
</body>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.js"></script>
<!-- /.content-wrapper -->
<script type="text/javascript" src="/js/layout.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
</html>