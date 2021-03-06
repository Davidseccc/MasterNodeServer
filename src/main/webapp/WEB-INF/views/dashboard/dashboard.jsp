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
    <title>MasterNodeServer Dashboard</title>

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
    <link rel="stylesheet" href="resources/css/material.css">
  </head>
  <body>

	<jsp:include page="/WEB-INF/views/include/menu/menu_right.jsp"></jsp:include>
	

      <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header">
          <img src="https://lh3.googleusercontent.com/-uBupwNzO6Fw/AAAAAAAAAAI/AAAAAAAAAAA/6JVYn--FAXg/s120-c/photo.jpg" class="demo-avatar">
          <div class="demo-avatar-dropdown">
            <span>Davidseccc@gmail.com</span>
            <div class="mdl-layout-spacer"></div>
            <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
              <i class="material-icons" role="presentation">arrow_drop_down</i>
              <span class="visuallyhidden">Accounts</span>
            </button>
            <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
              <li class="mdl-menu__item">Davidseccc@gmail.com</li>
              <li class="mdl-menu__item">David.Sec@uhk.cz</li>
              <li class="mdl-menu__item"><i class="material-icons">add</i>Add another account...</li>
            </ul>
          </div>
        </header>
        
        	<jsp:include page="/WEB-INF/views/include/menu/menu_left.jsp"></jsp:include>
        
      </div>
      <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">
          <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
	
			<div class="mdl-grid">
			<c:forEach var="item" items="${valueList}">
				<div class="mdl-cell mdl-cell--3-col mdl-cell--6-col-tablet" style="margin: auto; text-align: center;">
				
				<a href="value/?name=${item.sensor.identifier }" class="thumbnail">
						<h6 class="" >${item.sensor.name}</h6> <img src="resources/img/${item.sensor.name}.png"
						alt="${item.sensor.name}" style="width: auto; height: 60px">
						<p class="mdl-card__supporting-text mdl-color-text--grey-600"><kbd>${item.value}${item.sensor.name == 'dht11_humidity' ? "%" : "�C" }</kbd></p>
					</a>
					
				</div>
			</c:forEach>
  			
			</div>

          </div>
          <div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
            	<svg fill="currentColor" viewBox="0 0 500 250" class="demo-graph">
             	 <use xlink:href="#chart1" />
            	</svg>
            	<svg fill="currentColor" viewBox="0 0 500 250" class="demo-graph">
            	  <use xlink:href="#chart2" />
           		</svg>
                      </div>
          <div class="demo-cards mdl-cell mdl-cell--4-col mdl-cell--8-col-tablet mdl-grid mdl-grid--no-spacing">
            <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
              <div class="mdl-card__title mdl-card--expand mdl-color--teal-300">
                <h2 class="mdl-card__title-text">Updates</h2>
              </div>
              <div class="mdl-card__supporting-text mdl-color-text--grey-600">
                Non dolore elit adipisicing ea reprehenderit consectetur culpa.
              </div>
              <div class="mdl-card__actions mdl-card--border">
                <a href="#" class="mdl-button mdl-js-button mdl-js-ripple-effect">Read More</a>
              </div>
            </div>
            <div class="demo-separator mdl-cell--1-col"></div>
            <div class="demo-options mdl-card mdl-color--deep-purple-500 mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--3-col-tablet mdl-cell--12-col-desktop">
              <div class="mdl-card__supporting-text mdl-color-text--blue-grey-50">
                <h3>View options</h3>
                <ul>
                  <li>
                    <label for="chkbox1" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox1" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Click per object</span>
                    </label>
                  </li>
                  <li>
                    <label for="chkbox2" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox2" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Views per object</span>
                    </label>
                  </li>
                  <li>
                    <label for="chkbox3" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox3" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Objects selected</span>
                    </label>
                  </li>
                  <li>
                    <label for="chkbox4" class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
                      <input type="checkbox" id="chkbox4" class="mdl-checkbox__input">
                      <span class="mdl-checkbox__label">Objects viewed</span>
                    </label>
                  </li>
                  <li>
<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="switch-2">
  <input type="checkbox" id="switch-2" class="mdl-switch__input">
  <span class="mdl-switch__label"></span>
</label>
                  </li>
                </ul>
              </div>
              <div class="mdl-card__actions mdl-card--border">
                <a href="#" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-color-text--blue-grey-50">Change location</a>
                <div class="mdl-layout-spacer"></div>
                <i class="material-icons">location_on</i>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
      <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" style="position: fixed; left: -1000px; height: -1000px;">
      </svg>
<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 500 250" style="position: fixed; left: -1000px; height: -1000px;">
        <defs>
          <g id="chart1">
            <g id="Gridlines">
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="25" x2="468.3" y2="25" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="50" x2="468.3" y2="50" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="75" x2="468.3" y2="75" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="100" x2="468.3" y2="100" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="125" x2="468.3" y2="125" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="150" x2="468.3" y2="150" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="175" x2="468.3" y2="175" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="200" x2="468.3" y2="200" />
              
            </g>
            <g id="Numbers">
              <text transform="matrix(1 0 0 1 485 25)" fill="#888888" font-family="'Roboto'" font-size="9">50</text>
              <text transform="matrix(1 0 0 1 485 50)" fill="#888888" font-family="'Roboto'" font-size="9">40</text>
              <text transform="matrix(1 0 0 1 485 75)" fill="#888888" font-family="'Roboto'" font-size="9">30</text>
              <text transform="matrix(1 0 0 1 485 100)" fill="#888888" font-family="'Roboto'" font-size="9">20</text>
              <text transform="matrix(1 0 0 1 485 125)" fill="#888888" font-family="'Roboto'" font-size="9">10</text>
              <text transform="matrix(1 0 0 1 485 150)" fill="#888888" font-family="'Roboto'" font-size="9">0</text>
              <text transform="matrix(1 0 0 1 485 175)" fill="#888888" font-family="'Roboto'" font-size="9">-10</text>
              <text transform="matrix(1 0 0 1 485 200)" fill="#888888" font-family="'Roboto'" font-size="9">-20</text>
              
              <text transform="matrix(1 0 0 1 0 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">1</text>
              <text transform="matrix(1 0 0 1 78 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">2</text>
              <text transform="matrix(1 0 0 1 156 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">3</text>
              <text transform="matrix(1 0 0 1 234 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">4</text>
              <text transform="matrix(1 0 0 1 312 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">5</text>
              <text transform="matrix(1 0 0 1 390 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">6</text>
              <text transform="matrix(1 0 0 1 468 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">7</text>
            </g>
            <g id="Layer_5">
              <polygon opacity="0.36" stroke-miterlimit="10" points="
              0,222.7 
            <c:forEach var="value" items="${dsList}" varStatus="i"> ${i.index * 78},${150-(value * 2.5)}</c:forEach>
              468,222.7	
              "/>
            </g>

            <g id="Layer_4">
              <polygon opacity="1" stroke-miterlimit="10" points="
  				0,222.7 
            <c:forEach var="value" items="${dhtList}" varStatus="i"> ${i.index * 78},${150-(value * 2.5)}</c:forEach>
              468,222.7	
              "/>
            </g>
         </g>
         <g id="chart2">
            <g id="Gridlines">
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="25" x2="468.3" y2="25" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="50" x2="468.3" y2="50" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="75" x2="468.3" y2="75" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="100" x2="468.3" y2="100" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="125" x2="468.3" y2="125" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="150" x2="468.3" y2="150" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="175" x2="468.3" y2="175" />
              <line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="200" x2="468.3" y2="200" />
              
            </g>
            <g id="Numbers">
              <text transform="matrix(1 0 0 1 485 25)" fill="#888888" font-family="'Roboto'" font-size="9">50</text>
              <text transform="matrix(1 0 0 1 485 50)" fill="#888888" font-family="'Roboto'" font-size="9">40</text>
              <text transform="matrix(1 0 0 1 485 75)" fill="#888888" font-family="'Roboto'" font-size="9">30</text>
              <text transform="matrix(1 0 0 1 485 100)" fill="#888888" font-family="'Roboto'" font-size="9">20</text>
              <text transform="matrix(1 0 0 1 485 125)" fill="#888888" font-family="'Roboto'" font-size="9">10</text>
              <text transform="matrix(1 0 0 1 485 150)" fill="#888888" font-family="'Roboto'" font-size="9">0</text>
              <text transform="matrix(1 0 0 1 485 175)" fill="#888888" font-family="'Roboto'" font-size="9">-10</text>
              <text transform="matrix(1 0 0 1 485 200)" fill="#888888" font-family="'Roboto'" font-size="9">-20</text>
              
              <text transform="matrix(1 0 0 1 0 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">1</text>
              <text transform="matrix(1 0 0 1 78 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">2</text>
              <text transform="matrix(1 0 0 1 156 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">3</text>
              <text transform="matrix(1 0 0 1 234 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">4</text>
              <text transform="matrix(1 0 0 1 312 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">5</text>
              <text transform="matrix(1 0 0 1 390 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">6</text>
              <text transform="matrix(1 0 0 1 468 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">7</text>
            </g>
            <g id="Layer_5">
              <polygon opacity="0.26" stroke-miterlimit="10" points="
              0,222.7 
            <c:forEach var="value" items="${cpu02}" varStatus="i"> ${i.index * 78},${150-(value * 2.5)}</c:forEach>
              468,222.7	
              "/>
            </g>

            <g id="Layer_4">
              <polygon opacity="0.45" stroke-miterlimit="10" points="
  				0,222.7 
            <c:forEach var="value" items="${cpu03}" varStatus="i"> ${i.index * 78},${150-(value * 2.5)}</c:forEach>
              468,222.7	
              "/>
            </g>
            <g id="Layer_3">
              <polygon opacity="0.8" stroke-miterlimit="10" points="
  				0,222.7 
            <c:forEach var="value" items="${cpu01}" varStatus="i"> ${i.index * 78},${150-(value * 2.0)}</c:forEach>
              468,222.7	
              "/>
            </g>
         </g>
        </defs>
      </svg>
<!--       <a href="https://github.com/google/material-design-lite/blob/master/templates/dashboard/" target="_blank" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored mdl-color-text--white">View Source</a> -->
    <script src="https://code.getmdl.io/1.1.3/material.min.js"></script>
  </body>
</html>