<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container" style="min-height: 690px;; margin-top: 15px">
	<c:if test="${not empty messageError }">
		<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${messageError }</strong>
		</div>
	</c:if>
	<div class="breadcrumb"
		style="box-shadow: 1px 1px 5px #888888; width: 40%; float: left; background-color: white">
		<h5 style="text-align: center; font-weight: bold">Info Booking ID #${booking.maDatPhong}</h5>
		<frm:form action="themddp" modelAttribute="booking">
			<div class="form-group">
				<label for="hoTen" style="font-weight: bold;">Full Name:</label>
				<frm:input id="hoTen" class="form-control" path="hoTen" style="background-color: white; border:none"
						   value="${hoTen}" required="required" maxlength="100" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="soDT" style="font-weight: bold;">Phone number:</label>
				<frm:input id="sodt" type="number" class="form-control" path="sodt" style="background-color: white; border:none"
					placeholder="Enter Phone number..." value="${sodt}" required="required" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="createdDate" style="font-weight: bold;">Room number:</label>
				<frm:input id="soPhong" class="form-control" path="soPhong" style="background-color: white; border:none"
					type="text" value="${soPhong }" required="required" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="trangThai" style="font-weight: bold;">Status booking:</label>
				<c:choose>
					<c:when test = "${booking.trangThai.toString().equals('1') }">
						<frm:input id="trangThai" class="form-control" path="trangThai" style="background-color: white; border:none"
								   type="text" value="Booking" required="required" disabled="true"/>
					</c:when>
					<c:when test = "${booking.trangThai.toString().equals('2') }">
						<frm:input id="trangThai" class="form-control" path="trangThai" style="background-color: white; border:none"
								   type="text" value="Checkin" required="required" disabled="true"/>
					</c:when>
					<c:when test = "${booking.trangThai.toString().equals('3') }">
						<frm:input id="trangThai" class="form-control" path="trangThai" style="background-color: white; border:none"
								   type="text" value="Checkout" required="required" disabled="true"/>
					</c:when>
				</c:choose>

			</div>
			<div class="form-group">
				<label for="checkinDuKien" style="font-weight: bold;">Checkin date:</label>
				<frm:input id="checkinDuKien" class="form-control" path="checkinDuKien" style="background-color: white; border:none"
						   type="date" value="${checkinDuKien }" required="required" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Checkout date:</label>
				<frm:input id="checkoutDuKien" class="form-control" path="checkoutDuKien" style="background-color: white; border:none"
						   type="date" value="${checkoutDuKien }" required="required" disabled="true" />
			</div>
			<div class="form-group">
				<label for="tienCoc" style="font-weight: bold;">Deposit:</label>
				<frm:input id="tienCoc" type="number" class="form-control" style="background-color: white; border:none"
						   path="tienCoc" placeholder="Enter Deposit..." required="required"
						   value="${tienCoc}" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Rented room money:</label>
				<frm:input id="tienThuePhong" class="form-control" path="tienThuePhong" style="background-color: white; border:none"
						   type="text" value="${tienThuePhong}" required="required" disabled="true"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Service money:</label>
				<frm:input id="tienDichVu" class="form-control" path="tienDichVu" style="background-color: white; border:none"
						   type="text" value="${tienDichVu }" required="required" disabled="true"/>
			</div>
		</frm:form>
	</div>
	<div class="breadcrumb"
		 style="box-shadow: 1px 1px 5px #888888; width: 55%; float: right;">
		<h5 style="text-align: center; font-weight: bold">Change Info Booking ID #${booking.maDatPhong}</h5>
		<frm:form action="${action}" modelAttribute="booking">
			<frm:input id="maDatPhong " class="form-control d-none" path="maDatPhong"
					   value="${maDatPhong}" required="required" maxlength="100" />
			<frm:input id="createdBy " class="form-control d-none" path="createdBy"
					   value="${createdBy}" required="required" maxlength="100"/>
			<frm:input id="createdDate" class="form-control" path="createdDate"
					   value="${createdDate}" required="required" type="Datetime"/>
			<div class="form-group">
				<label for="hoTen" style="font-weight: bold;">Full Name:</label>
				<frm:input id="hoTen" class="form-control" path="hoTen"
						   value="${hoTen}" required="required" maxlength="100" readonly="${conditionReadonly}"/>
			</div>
			<div class="form-group">
				<label for="soDT" style="font-weight: bold;">Phone number:</label>
				<frm:input id="sodt" type="number" class="form-control" path="sodt"
						   placeholder="Enter Phone number..." value="${sodt}" required="required" readonly="${conditionReadonly}"/>
			</div>
			<div class="form-group">
				<label for="soPhong" style="font-weight: bold; margin-right: 50px">Room number:</label>
				<frm:select path="soPhong" items="${listRooms}" style="width: 100px; text-align:center; height: 40px; border-radius: 5px; font-size: 18px"
							disabled="${conditionReadonly}"
				></frm:select>
			</div>
			<div class="form-group">
				<label for="trangThai" style="font-weight: bold;">Status booking:</label>

				<div class="row">
					<c:choose>
						<c:when test = "${booking.trangThai.toString().equals('1') }">
							<div class="col-4 ml-4 d-flex">
								<label class="btn btn-secondary" for="option1">Booked</label>
								<frm:radiobutton id="option1" class="form-control " path="trangThai" autocomplete="off" checked="true"
												 name="trangThai" value="1"/>
							</div>
							<div class="col-4 d-flex">
								<label class="btn btn-secondary"  for="option2">Checkin</label>
								<frm:radiobutton  id="option2" class="form-control " path="trangThai" autocomplete="off"
												  name="trangThai" value="2"/>
							</div>
						</c:when>
						<c:when test = "${booking.trangThai.toString().equals('2') }">
							<div class="col-4 ml-4 d-flex">
								<label class="btn btn-secondary" for="option1">Checkin</label>
								<frm:radiobutton id="option1" class="form-control " path="trangThai" autocomplete="off" checked="true"
												 name="trangThai" value="2"/>
							</div>
							<div class="col-4 d-flex">
								<label class="btn btn-secondary"  for="option2">Checkout</label>
								<frm:radiobutton  id="option2" class="form-control " path="trangThai" autocomplete="off"
												  name="trangThai" value="3"/>
							</div>
						</c:when>
						<c:when test = "${booking.trangThai.toString().equals('3') }">
							<frm:input id="trangThai" class="form-control" path="trangThai"
									   type="text" value="Checkout" required="required" readonly="true"/>
						</c:when>
					</c:choose>
				</div>


			</div>
			<div class="form-group">
				<label for="checkinDuKien" style="font-weight: bold;">Checkin date:</label>
				<frm:input id="checkinDuKien" class="form-control" path="checkinDuKien"
						   type="date" value="${checkinDuKien }" required="required" readonly="${conditionReadonly}"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Checkout date:</label>
				<frm:input id="checkoutDuKien" class="form-control" path="checkoutDuKien"
						   type="date" value="${checkoutDuKien }" required="required" readonly="${conditionReadonly}"/>
			</div>
			<div class="form-group">
				<label for="tienCoc" style="font-weight: bold;">Deposit:</label>
				<frm:input id="tienCoc" type="number" class="form-control"
						   path="tienCoc" placeholder="Enter Deposit..." required="required"
						   value="${tienCoc}" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Rented room money:</label>
				<frm:input id="tienThuePhong" class="form-control" path="tienThuePhong"
						   type="number" value="${tienThuePhong}" required="required" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Service money:</label>
				<frm:input id="tienDichVu" class="form-control" path="tienDichVu"
						   type="number" value="${tienDichVu }" required="required" readonly="true"/>
			</div>
			<div class="form-group">
				<label for="checkoutDuKien" style="font-weight: bold;">Total money:</label>
				<frm:input id="tongTien" class="form-control" path="tongTien"
						   type="number" value="${tongTien }" required="required" readonly="true"/>
			</div>
			<frm:button type="submit" class="btn btn-info btn-lg float-right">Confirm</frm:button>
		</frm:form>
	</div>
</div>
