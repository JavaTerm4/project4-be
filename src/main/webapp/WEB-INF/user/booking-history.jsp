<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<section class="w3l-breadcrumb">
    <div class="breadcrum-bg py-sm-5 py-4">
        <div class="container py-lg-3">

            <h2>Booking History</h2>

            <p><a href="${pageContext.request.contextPath }/home">Home</a> &nbsp; / &nbsp;History</p>

        </div>
    </div>
</section>

<div class="best-rooms w3l-blog py-5">
    <div class="container py-lg-5 py-sm-4">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Room</th>
                <th scope="col">Checkin Expected</th>
                <th scope="col">Checkout Expected</th>
                <th scope="col">Status</th>
                <th scope="col">Total Rental ($)</th>
                <th scope="col">Deposit ($)</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${lqldv}">
                <tr>
                    <td>1</td>
                    <td>${u.getSoPhong()}</td>
                    <td>${u.getCheckinDuKien()}</td>
                    <td>${u.getCheckoutDuKien()}</td>
                    <td>
                        ${u.getTrangThai() == 1 ? "Booked" : u.getTrangThai() == 2 ? "Checkin" : "Checkout" }
                    </td>
                    <td>${u.getTienThuePhong()}</td>
                    <td>${u.getTienCoc()}</td>
                    <td><a href="usdtbkin"><button type="button" class="btn btn-dark">Details</button></a></td>
                    <td><button type="button" class="btn btn-dark">Edit</button></td>
                    <td><button type="button" class="btn btn-dark" >Cancel</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

