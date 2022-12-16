<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <!-- từ thời gian này đến thời gian kia -->
    <%-- <div class="container">
<div class="container">
    <div class="row" style="float: right">
           <form action="timlsdtp" >
           <div class="form-group row">
            <div class="col-xs-2">From:
            <input class="form-control" type="text" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}" name="tungay" placeholder="From Date" value="${tungay }"/></div> <b>&nbsp;&nbsp;</b>
            <div class="col-xs-2">To:
            <input class="form-control" type="text" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}" name="denngay" placeholder="To Date" value="${denngay }"/>
            </div>
            
           <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Search</span></button>
             </span>
            </div>
            </form>
            </div>
           </div>
           </div> --%>
    <!-- từ thời gian này đến thời gian kia -->
    <div class="container">
        <form action="timlsdtp">
            <div class="row" style="float: right">
                <div class="form-group">
                    <div class="input-group">
                        <input class="form-control" type="text" name="data"
                               placeholder="Search" maxlength="50"
                               value="${data }" required/> <span class="input-group-btn">
							<button class="btn btn-success" type="submit">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span><span
                                    style="margin-left: 2px;"><i class="fa fa-search"></i>
									Search</span>
							</button>
						</span>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div
            style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888;">
        <table class="table table-striped css-serial"
               style="font-size: 15px; white-space: nowrap;">
            <thead style="vertical-align: middle;">
            <tr>
                <th style="width: 50px;"></th>
                <th>Book ID#</th>
                <th>Renter</th>
                <th>Status</th>
                <th>Room</th>
                <th>Checkin Date</th>
                <th>Checkout Date</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tbody>
            <c:forEach var="u" items="${l }">
                <tr>
                    <td></td>
                    <td>${u.maDatPhong}</td>
                    <td style="max-width: 200px; white-space: nowrap; overflow: hidden;text-overflow: ellipsis;">${u.hoTen }</td>
                    <c:choose>
                        <c:when test = "${u.trangThai.toString().equals('1') }">
                            <td style="color: green">Booked</td>
                        </c:when>
                        <c:when test = "${u.trangThai.toString().equals('2') }">
                            <td style="color: #ffc107">Checkin</td>
                        </c:when>
                        <c:when test = "${u.trangThai.toString().equals('3') }">
                            <td style="color: #f57b51">Checkout</td>
                        </c:when>
                    </c:choose>
<%--                    <td>${u.getTrangThai() == 1 ? "Booked" : u.getTrangThai() == 2 ? "Checkin" : "Checkout" }</td>--%>
                    <td>${u.soPhong }</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${u.checkinDuKien }"/></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${u.checkoutDuKien }"/></td>
                    <td><a href="usdtbkin"><button type="button" class="btn btn-info" >Details</button></a></td>
                    <c:choose>
                        <c:when test = "${u.trangThai.toString().equals('1') }">
                            <td><button type="button" class="btn btn-info" data-toggle="modal" style="cursor: pointer" onclick="trahomestay(${u.maDatPhong })"
                                        data-target="#myModalsua${u.maDatPhong}">Edit</button></td>
                            <td><button type="button" class="btn btn-info" style="cursor: pointer" >Cancel</button></td>
                        </c:when>
                        <c:when test = "${u.trangThai.toString().equals('2') }">
                            <td><button type="button" class="btn btn-info" data-toggle="modal" style="cursor: pointer" onclick="trahomestay(${u.maDatPhong })"
                                        data-target="#myModalsua${u.maDatPhong}">Edit</button></td>
                            <td><button type="button" class="btn btn-info" style="cursor: pointer" >Cancel</button></td>
                        </c:when>
                        <c:when test = "${u.trangThai.toString().equals('3') }">
                            <td><button type="button" class="btn btn-info" data-toggle="modal" style="cursor: not-allowed" disabled onclick="trahomestay(${u.maDatPhong })"
                                        data-target="#myModalsua${u.maDatPhong}">Edit</button></td>
                            <td><button type="button" class="btn btn-info" style="cursor: not-allowed" disabled >Cancel</button></td>
                        </c:when>
                    </c:choose>
<%--                    <td><a href="usdtbkin"><button type="button" class="btn btn-info" style="cursor: pointer">Details</button></a></td>--%>


                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${danhsach!=0}">
        <br>
        <ul class="pagination" id="pagination"
            style="float: right; box-shadow: 1px 1px 5px #888888;">
            <li class="page-item first"><a
                    href="lsdtppage?data=${data }&page=${trangdau }" class="page-link">First
                page</a></li>
            <li class="page-item prev"><a
                    href="lsdtppage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
                    class="page-link"><</a></li>
            <c:forEach items="${listSoLuongTrang }" var="u">
                <li class="page-item"><a
                        <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
                        href="lsdtppage?data=${data }&page=${u }" class="page-link">${u }</a></li>
            </c:forEach>
            <li class="page-item next"><a
                    href="lsdtppage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
                    class="page-link">></a></li>
            <li class="page-item last"><a
                    href="lsdtppage?data=${data }&page=${trangcuoi }" class="page-link">Last
                page</a></li>
        </ul>
        <br>
        <br>
    </c:if>
    <c:if test="${ not empty danhsachtim}">
        <br>
        <ul class="pagination" id="pagination"
            style="float: right; box-shadow: 1px 1px 5px #888888;">
            <li class="page-item first"><a
                    href="lsdtppagetim?data=${data }&page=${trangdau }"
                    class="page-link">First page</a></li>
            <li class="page-item prev"><a
                    href="lsdtppagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"
                    class="page-link"><</a></li>
            <c:forEach items="${listSoLuongTrang }" var="u">
                <li class="page-item"><a
                        <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>
                        href="lsdtppagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>
            </c:forEach>
            <li class="page-item next"><a
                    href="lsdtppagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>
				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"
                    class="page-link">></a></li>
            <li class="page-item last"><a
                    href="lsdtppagetim?data=${data }&page=${trangcuoi }"
                    class="page-link">Last page</a></li>
        </ul>
        <br>
        <br>
    </c:if>
</div>
<script>
    function addhomestay(maPhong, soPhong) {
        window.location="/addhomestay?maPhong=" + maPhong + "&soPhong="+ soPhong;
    }
    function trahomestay(maDatPhong) {
        window.location="/edbkad-1?maDatPhong=" + maDatPhong;
    }
</script>