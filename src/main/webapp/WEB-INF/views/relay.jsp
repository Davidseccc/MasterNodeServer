<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<!--
  Material Design Lite
  Copyright 2015 Google Inc. All rights reserved.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License
-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>MasterNodeServer Sensors</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="resources/img/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="/MasterNodeServer/resources/css/material.css">
    
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

		//var date2 = performance.now();
		//var diff = date2 - date1;
		//var str = "doba: " + diff + "\n"
		//alert( str );

	}
</script>
   
  </head>
  <body>

	<jsp:include page="/WEB-INF/views/include/menu/menu_right.jsp"></jsp:include>
	

      <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>       
        	<jsp:include page="/WEB-INF/views/include/menu/menu_left.jsp"></jsp:include>
        
      </div>      
      <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">
          <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
	
			<div class="mdl-grid">
				<div class="">
				<div id="alert" class="alert alert-success" style="visibility: hidden;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success!</strong>
					<p id="demo"></p>
				</div>
				<c:forEach var="item" items="${valueList}">
					
					<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="${item.identifier}">
					  <input type="checkbox" id="${item.identifier}" class="mdl-switch__input" ${item.state ? "checked" : "" }>
  						<span class="mdl-switch__label">${item.name}</span>
					</label>
				
					
				</c:forEach>
  				</div>
			</div>

          </div>
        </div>
        
      </main>
<!--       <a href="https://github.com/google/material-design-lite/blob/master/templates/dashboard/" target="_blank" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">View Source</a> -->
    <script src="https://code.getmdl.io/1.1.3/material.min.js"></script>
  </body>
</html>