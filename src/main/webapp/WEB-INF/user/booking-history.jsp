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
            <c:forEach var="u" items="${listBook}">
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
                    <td><a href="usdtbkin"><button type="button" class="btn btn-info">Details</button></a></td>
                    <td><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModalsua${u.maDatPhong}">Edit</button></td>
                    <td><button type="button" class="btn btn-secondary" >Cancel</button></td>
                </tr>

<%--                <div class="modal fade" id="myModalsua${u.maDatPhong }"--%>
<%--                     role="dialog">--%>
<%--                    <div class="modal-dialog">--%>
<%--                        <!-- Modal content-->--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h4 class="modal-title">--%>
<%--                                    Edit Book ID <strong>${u.maDatPhong }</strong>--%>
<%--                                </h4>--%>
<%--                                <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--                            </div>--%>
<%--                            <frm:form action="editlp" modelAttribute="loaiphong">--%>
<%--                                <frm:hidden path="maDatPhong" value="${u.maDatPhong }" />--%>
<%--                                <div class="modal-body">--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label for="tenLoaiPhong" style="font-weight: bold;">Room--%>
<%--                                            type name:</label>--%>
<%--                                        <div class="col-sm-10">--%>
<%--                                            <frm:input id="tenLoaiPhong" class="form-control"--%>
<%--                                                       path="tenLoaiPhong" placeholder="Enter room type name"--%>
<%--                                                       value="${u.tenLoaiPhong }" maxlength="100" />--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <label for="moTa" style="font-weight: bold;">Description:</label>--%>
<%--                                        <div class="col-sm-10">--%>
<%--                                            <frm:input id="moTa" class="form-control" path="moTa"--%>
<%--                                                       placeholder="Enter description" value="${u.moTa }" maxlength="250" />--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

<%--                                </div>--%>

<%--                                <div class="modal-footer">--%>
<%--                                    <frm:button class="btn btn-warning">--%>
<%--                                        <i class="fa fa-edit"></i>Update</frm:button>--%>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

