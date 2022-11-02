<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" style="color: yellowgreen">
<h1>Paid Successfull</h1>
<h2>Thank for your payment</h2>
<h4>Payper: ${bookingDTO.name}</h4>
<h4>Room: ${phong.loaiPhong.tenLoaiPhong} ${phong.soPhong}</h4>
<h4>Total: ${phong.giaPhong}$</h4>
<a style="color: red" href="home">GO HOME</a>
</body>
</html>