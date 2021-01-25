<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
	 if (navigator.geolocation) {
         //위치 정보를 얻기
         navigator.geolocation.getCurrentPosition (function(pos) {
             console.log(pos.coords.latitude);
             console.log(pos.coords.longitude);
             location="main?lat="+pos.coords.latitude+"&lon="pos.coords.longitude
         });
     } else {
         alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
     };

	
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
