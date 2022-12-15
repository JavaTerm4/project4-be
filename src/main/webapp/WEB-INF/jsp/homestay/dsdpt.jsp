<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<!-- thông báo khi sửa hoặc xóa thành công -->
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${message }</strong>
		</div>
	</c:if>
	<c:if test="${not empty messageError }">
		<div class="alert alert-danger">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${messageError }</strong>
		</div>
	</c:if>
</div>
<div class="container">
	<div
		style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888;">
		<table class="table table-striped css-serial" style="margin-bottom: 0">
			<thead>
				<tr>
					<th></th>
					<th style="min-width: 100px;">Booking ID</th>
					<th style="min-width: 100px;">Full name</th>
					<th style="min-width: 130px;">Phone number</th>
					<th style="min-width: 120px;">Deposit</th>
					<th style="min-width: 150px;">Checkin date</th>
					<th style="min-width: 150px;">Checkout date</th>
					<th style="min-width: 120px;">Created by</th>
					<th style="min-width: 100px;">Manipulation</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty danhsach }">
					<c:forEach var="booking" items="${danhsach}">
						<tr>
							<td></td>
							<td>${booking.maDatPhong }</td>
							<td>${booking.hoTen}</td>
							<td>${booking.sodt}</td>
							<td><fmt:formatNumber value="${u.tienCoc }" type="number"
												  pattern="###,###" /> $</td>
							<td><fmt:formatDate pattern="dd - MMM - yyyy" value="${booking.checkinDuKien }" /></td>
							<td><fmt:formatDate pattern="dd - MMM - yyyy" value="${booking.checkoutDuKien }" /></td>
							<td>${booking.createdBy}</td>
							<td><button type="button" class="btn btn-success btn-sm"
										onclick="trahomestay(${booking.maDatPhong })">Check-in</button></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<script>
function addhomestay(maPhong, soPhong) {
	window.location="/addhomestay?maPhong=" + maPhong + "&soPhong="+ soPhong;
}
function trahomestay(maDatPhong) {
	window.location="/edbkad?maDatPhong=" + maDatPhong;
}
</script>
