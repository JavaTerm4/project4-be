<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<section class="w3l-booking-top">
	<!-- /form-16-section -->
	<div class="booking-form-61">
		<div class="container">
			<div class="">
<%--				<div class="booking-forms-16-info align-self">--%>
<%--					<h5>Your Reservation</h5>--%>
<%--					<h3 class="title-big">Select the Room, check for available room--%>
<%--						and book it.</h3>--%>
<%--				</div>--%>
				<div class="form-right-inf">
					<div class="booking-form-content">
						<h6>Book Room ${roomNumber} Now</h6>
						<form:form action="/bookingroom" modelAttribute="bookingDTO"
							class="book-depature-6 signin-form" method="post">
							<div class="d-grid grid-columns4">
								<div class="hny-frm_grid">
									<h5>Name</h5>
									<form:input path="name" name="name" type="text"
										placeholder="Your Name" required="required" value="${account.fullName}"></form:input>
								</div>
								<div class="hny-frm_grid">
									<h5>Phone Number</h5>
									<form:input path="phoneNumber" name="phoneNumber" type="text"
										placeholder="Phone Number" required="required" value="${account.phoneNumber}"></form:input>
								</div>
								<div class="hny-frm_grid">
									<h5>Email</h5>
									<form:input path="email" name="email" type="email"
										placeholder="Email" required="required" value="${account.email}"></form:input>
								</div>
									<div class="hny-frm_grid">
										<h5>Room number</h5>
										<input value="${roomNumber}" name="roomNumber" type="number"
											   readonly="true" placeholder="Room Number" required="" />
									</div>
									<div class="hny-frm_grid">
										<h5>Room Price</h5>
										<input value="${roomPrice}$" name="roomPrice" type="text"
											   readonly="true"  required="" />
									</div>
									<div class="hny-frm_grid">
										<h5>Room Type</h5>
										<input value="${bookingDTO.roomType}" name="roomType" type="text"
											   readonly="true"  required="" />
									</div>
								<div class="hny-frm_grid">
									<h5>Check-in Date</h5>
									<form:input id="checkInDate" path="checkInDate"
										name="checkInDate" type="date" placeholder="Check-in Date"
										required="required"></form:input>
								</div>
								<div class="hny-frm_grid">
									<h5>Check-out Date</h5>
									<form:input id="checkOutDate" path="checkOutDate"
										name="checkOutDate" type="date" placeholder="Check-out Date"
										required="required"></form:input>
									<form:input path="roomCode" name="roomCode" type="hidden"
										placeholder="Room ID"></form:input>
								</div>
								<div class="hny-frm_grid">

								</div>


							</div>
							<input type="submit"
								class="btn btn-style btn-secondary book mt-3"
								style="background: #f57b51; color: #fff" value="Book Now" />
<%--							<p class="already">You are booking as a guest.</p>--%>
							<p class="already" style="color: red">${error}</p>
						</form:form>
					</div>
				</div>
	<div class="form-right-inf mt-5">
		<div class="booking-form-content">
			<h6>Check booked of Room ${roomNumber}</h6>
			<form:form action="/bookingroom"
					   class="book-depature-6 signin-form" method="get">
				<div class="d-grid grid-col-2">
					<div class="hny-frm_grid">
						<h5>Check-in Date</h5>
						<input id="checkinBooked" path="checkinBooked"
									name="checkinBooked" type="date" value="${checkinBooked}"
									required="required"></input>
					</div>
					<div class="hny-frm_grid">
						<h5>Check-out Date</h5>
						<input id="checkoutBooked" path="checkoutBooked"
									name="checkoutBooked" type="date" value="${checkoutBooked}"
									required="required"></input>
						<input path="roomNumber" name="roomNumber" type="hidden"
									value="${roomNumber}" required></input>
					</div>

				</div>
				<input type="submit" class="btn btn-style btn-info book mt-3"
					   style="background: #17a2b8; color: #fff" value="Check booked" />
				<br><br><br>
				<c:choose>
					<c:when test="${empty checkBooked}">
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${empty messageBooked}">
								<h6 style="font-size: larger">Room ${roomNumber} is booked in the schedule below: <span style="font-weight: lighter; font-size: smaller">*** Please book another time against the list below</span></h6>
								<c:forEach items="${listBooked}" var="dateBooked">
									<button type="button" class='ml-3 book btn btn-secondary btn-style mb-5' style="cursor: not-allowed !important;"> ${dateBooked.checkin} &#8594; ${dateBooked.checkout}</button>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<h6 style="font-size: larger"> ${messageBooked}</h6>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>





			</form:form>
		</div>
	</div>
			</div>
		</div>
	</div>
</section>
