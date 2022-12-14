<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <c:if test="${not empty message }">
        <div class="alert alert-success">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong>${message }</strong>
        </div>
    </c:if>

    <div
            style="overflow: auto; height: auto; width: 100%; box-shadow: 1px 1px 5px #888888;">
        <table class="table table-striped css-serial"
               style="font-size: 15px; white-space: nowrap;">
            <thead style="vertical-align: middle;">
            <tr>
                <th style="width: 50px;"></th>
                <th>Content</th>
                <th>Collect type</th>
                <th>Collect date</th>
                <th>Money</th>
                <th>Description</th>
                <th>Created by</th>
            </tr>
            <tbody>
            <c:forEach var="u" items="${listCollect}">
                <tr>
                    <td></td>
                    <td>${u.noiDungChi }</td>
                    <td>${u.loaiThuChi }</td>
                    <td>${u.ngayChi }</td>
                    <td><fmt:formatNumber value="${u.soTien }" type="number"
                                          pattern="###,###$"/> $
                    </td>
                    <td>${u.description }</td>
                    <td style="text-align: center">${u.tenDangNhap }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%--    <c:if test="${listCollect!=0}">--%>
<%--        <br>--%>
<%--        <ul class="pagination" id="pagination"--%>
<%--            style="float: right; box-shadow: 1px 1px 5px #888888;">--%>
<%--            <li class="page-item first"><a--%>
<%--                    href="lsdtppage?data=${data }&page=${trangdau }" class="page-link">First--%>
<%--                page</a></li>--%>
<%--            <li class="page-item prev"><a--%>
<%--                    href="lsdtppage?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>--%>
<%--				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"--%>
<%--                    class="page-link"><</a></li>--%>
<%--            <c:forEach items="${listSoLuongTrang }" var="u">--%>
<%--                <li class="page-item"><a--%>
<%--                        <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>--%>
<%--                        href="lsdtppage?data=${data }&page=${u }" class="page-link">${u }</a></li>--%>
<%--            </c:forEach>--%>
<%--            <li class="page-item next"><a--%>
<%--                    href="lsdtppage?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>--%>
<%--				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"--%>
<%--                    class="page-link">></a></li>--%>
<%--            <li class="page-item last"><a--%>
<%--                    href="lsdtppage?data=${data }&page=${trangcuoi }" class="page-link">Last--%>
<%--                page</a></li>--%>
<%--        </ul>--%>
<%--        <br>--%>
<%--        <br>--%>
<%--    </c:if>--%>
<%--    <c:if test="${ not empty listCollect}">--%>
<%--        <br>--%>
<%--        <ul class="pagination" id="pagination"--%>
<%--            style="float: right; box-shadow: 1px 1px 5px #888888;">--%>
<%--            <li class="page-item first"><a--%>
<%--                    href="lsdtppagetim?data=${data }&page=${trangdau }"--%>
<%--                    class="page-link">First page</a></li>--%>
<%--            <li class="page-item prev"><a--%>
<%--                    href="lsdtppagetim?data=${data }&page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if>--%>
<%--				<c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>"--%>
<%--                    class="page-link"><</a></li>--%>
<%--            <c:forEach items="${listSoLuongTrang }" var="u">--%>
<%--                <li class="page-item"><a--%>
<%--                        <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if>--%>
<%--                        href="lsdtppagetim?data=${data }&page=${u }" class="page-link">${u }</a></li>--%>
<%--            </c:forEach>--%>
<%--            <li class="page-item next"><a--%>
<%--                    href="lsdtppagetim?data=${data }&page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if>--%>
<%--				<c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>"--%>
<%--                    class="page-link">></a></li>--%>
<%--            <li class="page-item last"><a--%>
<%--                    href="lsdtppagetim?data=${data }&page=${trangcuoi }"--%>
<%--                    class="page-link">Last page</a></li>--%>
<%--        </ul>--%>
<%--        <br>--%>
<%--        <br>--%>
<%--    </c:if>--%>
</div>
