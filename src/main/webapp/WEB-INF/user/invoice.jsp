<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>A simple, clean, and responsive HTML invoice template</title>

<link href="css/style-invoice.css" rel="stylesheet">
</head>

<body>


	<form method="post" action="@{/pay}">
		<div class="invoice-box">
			<table cellpadding="0" cellspacing="0">
				<tr class="top">
					<td colspan="2">
						<table>
							<tr>
								<td class="title"><img src="hinh/iconhome.ico" width="150"
									height="150"></td>

								<td>Invoice #: 0${bookingDTO.roomCode}<br> Created:
									${bookingDTO.checkInDate}<br>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr class="information">
					<td colspan="2">
						<table>
							<tr>
								<td>Homie Hotel, Inc.<br> Phone: 0905187775<br>
									Address: 590 CMT8, Ward 11,<br> District 3,
									City. Ho Chi Minh
								</td>

								<td>Dear: ${bookingDTO.name}.<br> Phone:
									${bookingDTO.phoneNumber}<br> Email:${bookingDTO.email}
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr class="heading">
					<td>Payment Method</td>

					<td>Money #</td>
				</tr>

				<tr class="details">
					<td>Room Price</td>

					<td>${phong.giaPhong}$</td>
				</tr>

				<tr class="heading">
					<td>Item</td>

					<td>Check</td>
				</tr>


				<tr class="item">
					<td>Room Number</td>

					<td>${phong.soPhong}</td>
				</tr>

				<tr class="item">
					<td>Room Type</td>

					<td>${phong.loaiPhong.tenLoaiPhong}</td>
				</tr>

				<tr class="item">
					<td>Check-in Date</td>

					<td>${bookingDTO.checkInDate}</td>
				</tr>

				<tr class="item last">
					<td>Check-out Date</td>

					<td>${bookingDTO.checkOutDate}</td>
				</tr>
				<tr class="item last">
					<td>QR</td>

					<td><img
						src="${pageContext.request.contextPath}/qrcode/${bookingDTO.name}"
						width="100" height="100"></td>
				</tr>
			</table>
		</div>

	</form>

	<div class="container" align="center">
		<form action="${paypalConfig.posturl }" method="post">
			<!-- PayPal Setting -->
			<input type="hidden" name="upload" value="1" /> 
			<input type="hidden" name="return" value="${paypalConfig.returnurl }" /> 
			<input type="hidden" name="cmd" value="_cart" /> 
			<input type="hidden"
				name="business" value="${paypalConfig.business}" /> 
				<input type="hidden" name="item_name_1" value="${ bookingDTO.name}" />
			<input type="hidden" name="item_number_1" value="${ bookingDTO.roomCode}" />
			<input type="hidden" name="item_name_1" value="${phong.loaiPhong.tenLoaiPhong} " /> 
			<input type="hidden" name="amount_1" value="${phong.giaPhong} " /> 
			<input type="hidden" name="quantity_1" value="1" /> 
			<input type="image" src="${pageContext.request.contextPath}/images/paypal-button.png"
				name="submit" width="200" height="100" alt="submit" />

		</form>
	</div>

</body>
</html>
