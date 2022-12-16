<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>Bambuu Hotel</title>

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

								<td>Invoice <br> Created:
									${booking.createdDate}<br>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr class="information">
					<td colspan="2">
						<table>
							<tr>
								<td>Bambuu Hotel, Inc.<br> Phone: 0931721638<br>
									Address: 590 CMT8, Ward 11,<br> District 3,
									City. Ho Chi Minh
								</td>

								<td>Dear: ${booking.hoTen}.<br> Phone:
									${booking.sodt}
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
					<td>Deposit</td>

					<td>${booking.tienCoc}$</td>
				</tr>

				<tr class="heading">
					<td>Item</td>

					<td>Check</td>
				</tr>


				<tr class="item">
					<td>Room Number</td>

					<td>${booking.soPhong}</td>
				</tr>


				<tr class="item">
					<td>Check-in Date</td>

					<td>${booking.checkinDuKien}</td>
				</tr>

				<tr class="item">
					<td>Check-out Date</td>

					<td>${booking.checkoutDuKien}</td>
				</tr>

				<tr class="item last">
					<td>Total Rented Money</td>

					<td>${booking.tienThuePhong}$</td>
				</tr>
<%--				<tr class="item last">--%>
<%--					<td>QR</td>--%>

<%--					<td><img--%>
<%--						src="${pageContext.request.contextPath}/qrcode/${bookingDTO.name}"--%>
<%--						width="100" height="100"></td>--%>
<%--				</tr>--%>
			</table>
		</div>

	</form>

	<div class="container" align="center">
		<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
			<!-- PayPal Setting -->
			<input type="hidden" name="upload" value="1" />
			<input type="hidden" name="return" value="http://localhost:9596/success" />
			<input type="hidden" name="cmd" value="_cart" />
			<input type="hidden"
				name="business" value="sb-penza22048291@business.example.com" />
			<input type="hidden" name="item_name_1" value="${ booking.hoTen}" />
			<input type="hidden" name="item_number_1" value="${ booking.soPhong}" />
<%--			<input type="hidden" name="item_name_1" value="${phong.loaiPhong.tenLoaiPhong} " />--%>
			<input type="hidden" name="amount_1" value="${booking.tienCoc} " />
			<input type="hidden" name="quantity_1" value="1" />
			<input type="image" src="${pageContext.request.contextPath}/images/paypal-button.png"
				name="submit" width="200" height="100" alt="submit" />

		</form>
	</div>

</body>
</html>
