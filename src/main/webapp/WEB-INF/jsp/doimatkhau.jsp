
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

              	
<div class="container">
<!-- thông báo lỗi ngoại lệ form -->
<frm:form modelAttribute="taikhoan">
           <c:if test="${not empty errors }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Lỗi!</strong>
    <p><frm:errors path="*" ></frm:errors></p>
  </div>
  </c:if>
  </frm:form>
  <!-- thông báo khi sửa hoặc xóa thành công -->
  
  <c:if test="${not empty messageloi }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${messageloi }</strong>
  </div>
  </c:if>
  
  <c:if test="${not empty message }">
           <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${message }</strong>
  </div>
  </c:if>
  </div>
           
                  
           
          <div class="container">
          
          <div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
<div>
	  
	  
	   <frm:form action="actiondoimatkhau" modelAttribute="taikhoan">
           <input type="hidden" name="tenDangNhap" id="tenDangNhap" class="form-control" value="${gettaikhoan.tenDangNhap }"/>
	   <div class="form-group">
		<label for="oldPass" style="font-weight: bold;">Old password:</label>
		<div class="col-sm-10">
			<input type="password" name="oldPass" id="oldPass" class="form-control" placeholder="Enter your current password" maxlength="100" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="newPass" style="font-weight: bold;">New password:</label>
		<div class="col-sm-10">
			<input type="password" name="newPass" id="newPass" class="form-control" placeholder="Enter your new password" maxlength="100" required="required" >
		</div>
	</div>
	  
             <div class="form-group">
		<label style="font-weight: bold;">Confirm new password:</label>
		<div class="col-sm-10">
            <input type="password" name="cfPass" id="cfPass" class="form-control" placeholder="Enter your new password" maxlength="100" required="required" >
		</div>
	</div>
           
         <div class="container">
			<button type="submit" class="btn btn-success btn-xs">Save</button>
		</div>
           
             </frm:form>
             
             
             
       </div></div></div>
           
          