<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>
  <head>
 <title>head</title>
  </head>
  <body>
  <c:forEach var="item" items="${valueList}">
 <div>
 <p>${item.id}</p>
 <p>${item.name}</p>
 </div>
</c:forEach>
  </body>
</html>