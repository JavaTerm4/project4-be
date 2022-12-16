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
<h4>Payper: ${booking.hoTen}</h4>
<h4>Room: ${booking.soPhong}</h4>
<h4>Deposit: ${booking.tienCoc}</h4>
<h4>Total: ${booking.tienThuePhong}$</h4>
<a style="color: red" href="home">GO HOME</a>
</body>
</html>