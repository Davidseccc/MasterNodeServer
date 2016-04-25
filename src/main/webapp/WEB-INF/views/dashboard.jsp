<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="/WEB-INF/views/include/bootstrap.jsp"></script>
</head>
<body>

	<div class="container text-center">
		<h1>MasterNode Server - Dashboard</h1>
		<p>Last values oneach sensor</p>
				<div><a href=relay/><h4>Relays</h4> </a></div>
				<div><a href=api/><h4>API</h4> </a></div>
				<div><a href=help/><h4>help</h4> </a></div>
				<div><a href=dashboard><h4>new Dashboard</h4> </a></div>
				
				
		
		<div class="row">

			<c:forEach var="item" items="${valueList}">
				<div class="col-md-3">
					<a href="value/?name=${item.sensor.identifier }" class="thumbnail">
						<h4>${item.sensor.name}</h4> <img src="resources/img/${item.sensor.name}.png"
						alt="${item.sensor.name}" style="width: auto; height: 100px">
						<h3><kbd>${item.value}${item.sensor.name == 'dht11_humidity' ? "%" : "°C" }</kbd></h3>
					</a>
					
				</div>
			</c:forEach>

		</div>
		
	</div>

</body>
</html>