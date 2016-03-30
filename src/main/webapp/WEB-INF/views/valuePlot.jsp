<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>
  <head>

    <script type="text/javascript"
          src="https://www.google.com/jsapi?autoload={
            'modules':[{
              'name':'visualization',
              'version':'1',
              'packages':['corechart']
            }]
          }"></script>

    <script type="text/javascript">
      google.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Date', '${datasetName}'],

          <c:forEach items="${valueList}" var="item">
          [new Date(           <fmt:formatDate pattern="yyyy,MM,dd,HH,mm,ss" 
	            value="${item.date}" />), ${item.value} ],
	       </c:forEach>
		  
        ]);

        var options = {
          title: '${caption}',
          curveType: 'function',
          legend: { position: 'bottom' },
		  height:screen.height*0.75

        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
  <!--<a href="http://77.48.104.43/">2015</a>-->
    <div id="curve_chart"></div>

  </body>
</html>