<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${empty booking}" >
    <div class="container">
                <div class="alert alert-success">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>None Customer is checkin this room</strong>
                </div>
    </div>
</c:if>
<c:if test="${not empty booking}" >

<div class="container">
    <div class="row">
        <%--Lưu đường dẫn tham khảo : https://www.bootdey.com/snippets/view/invoice-order-receipt--%>
        <!-- BEGIN INVOICE -->
        <div class="col-xs-12">
            <div class="grid invoice" style="box-shadow: 8px -8px 4px rgb(0 0 0 / 10%) ; border: 1px solid black">
                <div class="grid-body">
                    <div class="invoice-title">
                        <div class="row">
                            <div class="col-xs-12">
                                <img src="images/hotels.png" alt="" height="35">
                                <span style="color: #f57b51; font-weight: 700;">
                                    BAMBUU HOTEL
                                </span>
                                <p style="font-size: 12px"><span class="fa fa-map-marker"></span> &ensp; 590 Cach Mang Thang 8, Ward 11, District 3, Ho Chi Minh City</p>
                                <p style="font-size: 12px"><span class="fa fa-phone"></span> &ensp; +84 123 456 789</p>
                            </div>
                        </div>
                        <br><br>
                        <div class="row justify-content-between">
                            <div class="col-xs-6">
                                <h2 style="font-weight: 500; ">INVOICE<br><br>
                                    <span class="small"> &ensp; Order #1082</span><br><br>
                                    <span class="small"><span style="font-style: italic"> &ensp; Status -</span> Checkout</span>
                                </h2>
                            </div>
                            <div class="col-xs-6">
                                <address>
                                    <strong>Customer:</strong><br>
                                    ${booking.hoTen} <br>
                                    ${booking.sodt}
                                </address>
                                <address>
                                    <strong>Booking Information:</strong><br>
                                    Checkin Actual &nbsp;&nbsp; : ${booking.checkinDuKien}<br>
                                    Checkout Actual : ${booking.checkoutDuKien}<br>
                                </address>
                            </div>
                        </div>
                    </div>
                    <hr>

                    <div class="row">
                        <div class="col-md-12">
                            <h3>ORDER SUMMARY</h3>
                            <table class="table table-striped">
                                <thead>
                                <tr class="line">
                                    <td><strong>#</strong></td>
                                    <td class="text-center"><strong>SERVICE</strong></td>
                                    <td class="text-center"><strong>QTY</strong></td>
                                    <td class="text-right"><strong>SUBTOTAL</strong></td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td class="text-center">Rented room ${booking.soPhong} (From ${booking.checkinDuKien} To ${booking.checkoutDuKien}).</td>
                                    <td class="text-center">${soNgay}</td>
                                    <td class="text-right">$${booking.tienThuePhong}</td>
                                </tr>
                                <tr>
                                    <td colspan="2"></td>
                                    <td class="text-right"><strong>Taxes</strong></td>
                                    <td class="text-right"><strong>10%</strong></td>
                                </tr>
                                <tr>
                                    <td colspan="2"></td>
                                    <td class="text-right"><strong>Deposit</strong></td>
                                    <td class="text-right"><strong>$ ${booking.tienCoc}</strong></td>
                                </tr>
                                <tr>
                                    <td colspan="2"></td>
                                    <td class="text-right"><strong>Total</strong></td>
                                    <td class="text-right"><strong>$ ${booking.tongTien }</strong></td>
                                </tr>
                                </tbody>
                            </table>
                            <frm:form action="checkout-room?soPhong=${booking.soPhong}" modelAttribute="collect">
                                <frm:input id="bookingId" class="form-control d-none" path="bookingId"
                                           value="${booking.maDatPhong}" required="required" maxlength="100" />
                                <frm:input id="soTien" class="form-control d-none" path="soTien"
                                       type="number" value="${booking.tongTien }" required="required" readonly="true"/>
                                <frm:input id="tenDangNhap" class="form-control d-none" path="tenDangNhap"
                                           type="number" value="${booking.createdBy }" required="required" readonly="true"/>
                                <frm:button type="submit" class="btn btn-success btn-lg float-right">Checkout</frm:button>
                            </frm:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END INVOICE -->

    </div>
</div>
</c:if>


<style>
    body{margin-top:20px;
        background:#eee;
    }

    .invoice {
        padding: 30px;
    }

    .invoice h2 {
        line-height: 0.8em;
        margin: 0 auto;
    }

    .invoice .small {
        font-weight: 300;
    }

    .invoice hr {
        margin-top: 10px;
        border-color: #ddd;
    }

    .invoice .table tr.line {
        border-bottom: 1px solid #ccc;
    }

    .invoice .table td {
        border: none;
    }

    .invoice .identity {
        margin-top: 10px;
        font-size: 1.1em;
        font-weight: 300;
    }

    .invoice .identity strong {
        font-weight: 600;
    }


    .grid {
        position: absolute;
        width: 100%;
        background: #fff;
        color: #666666;
        border-radius: 2px;
        margin-bottom: 25px;
        box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.1);
    }

</style>


