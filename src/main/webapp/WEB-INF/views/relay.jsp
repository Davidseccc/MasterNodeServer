<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Relays</title>
<link rel="stylesheet" href="/MasterNodeServer/resources/css/onoff.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	$(function() {//code inside this function will run when the document is ready
		//alert($('#rb_01_1').is(':checked'));
		<c:forEach var="item" items="${valueList}">
		$('#${item.identifier}').change(
				function() {//do something when the user clicks the box

					loadDoc('${item.identifier}', ($('#${item.identifier}')
							.is(':checked')));
				});
		</c:forEach>
	});

	function loadDoc(name, state) {
		var date1 = performance.now();

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4 && xhttp.status == 200) {
				document.getElementById("demo").innerHTML = xhttp.responseText;
				document.getElementById("alert").style.visibility = "visible";
			}
		};
		xhttp.open("GET", "demo_get?name=" + name + "&state=" + state, true);
		xhttp.send();

		var date2 = performance.now();
		var diff = date2 - date1;
		//var str = "doba: " + diff + "\n"
		//alert( str );

	}
</script>
</head>
<body>
	<div class="container">

		<div id="alert" class="alert alert-success"
			style="visibility: hidden;">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Success!</strong>
			<p id="demo"></p>
		</div>
		<c:forEach var="item" items="${valueList}">


			<p>${item.name}</p>
			<label class="switch switch-green"> <input type="checkbox"
				id="${item.identifier}" class="switch-input"
				${item.state ? "" : "" }> <span class="switch-label"
				data-on="On" data-off="Off"></span> <span class="switch-handle"></span>
			</label>
		</c:forEach>
	</div>
</body>
</html>