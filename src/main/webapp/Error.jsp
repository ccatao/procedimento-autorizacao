<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Procedimentos - algo aconteceu de errado!</title>
</head>
<body>
 <center>
  <h1>Erro!</h1>
  <h2><%=exception.getMessage() %><br/> </h2>
 </center> 
</body>
</html>