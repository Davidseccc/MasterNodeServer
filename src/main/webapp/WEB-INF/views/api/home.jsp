<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/include/bootstrap.jsp"></jsp:include>
<title>API</title>
</head>
<body>
	<h1>Hello</h1>

	<div class="container center-block">
		<div class="panel panel-default col-sm-10">
			<div class="panel-body">
				<h2>API</h2>
				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain a list of configured Nodes</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./node/?format=json>/node/?format=json</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain a list of configured Sensors</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./sensor/?format=json>/sensor/?format=json</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain a list of sensor Values</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?format=json>/value/?format=json</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain a list of available Relays </p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./relay/?format=json>/relay/?format=json</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
