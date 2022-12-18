
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.hovera {
	text-decoration: none;
	color: black;
}

.hovera:hover {
	text-decoration: none;
	color: black;
	text-shadow: 1px 1px 1px #888888;
}

.st-tang {
	color: white;
	position: absolute;
	right: 215px;
	margin-top: 13px;
	font-size: 30px
}

@media ( max-width : 991px) {
	.st-tang {
		color: white;
		position: absolute;
		right: 215px;
		margin-top: 17px;
		font-size: 25px
	}
}
</style>
<div class="container">
	<c:if test="${not empty message }">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${message }</strong>
		</div>
	</c:if>
</div>
<div class="container" style="height: auto; margin-top: 20px;">
	<c:forEach var="i" items="${listTang}">
		<div style="width: 100%">
			<div style="width: 100%; height: 80px;">
				<img align="right"
					style="-webkit-filter: drop-shadow(1px 1px 2px #888888); filter: drop-shadow(1px 1px 2px #888888); margin-bottom: 10px;"
					src='hinh/title tang.png' width="450px" height="70px">
				<div class="st-tang">
					<b>Floors ${i }</b>
				</div>
			</div>
			<div style="clear: both; width: 100%;">
				<div class="breadcrumb"
					style="box-shadow: 1px 1px 5px #888888; width: 100%;">
					<c:forEach var="room" items="${listRoomCheckin}">
						<c:if test="${room.tang == i }">
							<div class="itemdptp">
								<a href="dv?madatphong=${room.maDatPhong }&sophong=${room.soPhong }">
									<img class="icondptp" src='hinh/homered.png'>
									<div class="thongtinttk2">
										<div>
											<b>Room: </b>${room.soPhong }
										</div>
										<div>
											<b>Type: </b>
											<c:if test="${room.tenLoaiPhong=='VIP'}">
												<img src="hinh/vip.png" width="55px" height="23px"
													style="margin-bottom: 5px; -webkit-filter: drop-shadow(1px 1px 1px #fff0b6); filter: drop-shadow(1px 1px 1px #fff0b6);"/>
											</c:if>
											<c:if test="${room.tenLoaiPhong=='Normal'}">Normal</c:if>
										</div>
										<div>
											<b>Discount: </b>${room.khuyenMai }%
										</div>
									</div>
								</a>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
