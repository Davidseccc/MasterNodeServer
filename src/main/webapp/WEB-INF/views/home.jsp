<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/include/bootstrap.jsp"></jsp:include>

<title>Home</title>
</head>
<body>
	<h1>Hello</h1>

	<div class="container center-block">
		<div class="panel panel-default col-sm-10">
			<div class="panel-body">
				<h2>GRAPHs</h2>
				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain values in last 24 hours</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?name=cpu01>/value/?name=cpu01</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain values in last 24 hours</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?name=cpu02>/value/?name=cpu02</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain values in last 24 hours</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?name=cpu03>/value/?name=cpu03</a>
						</div>
					</div>
				</div>


				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain values in last 24 hours</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?name=ds_garaz>/value/?name=ds_garaz</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain values in last 24 hours</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?name=dht11_01_humidity>/value/?name=dht11_01_humidity</a>
						</div>
					</div>
				</div>


				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain values in last 24 hours</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./value/?name=dht11_01_temp>/value/?name=dht11_01_temp</a>
						</div>
					</div>
				</div>

				<div>
					<div class="row alert-info img-rounded"
						style="margin: 3px 0px 3px 0px; padding-top: 6px">
						<div class="col-sm-4 col-sm-push-8">
							<p>Obtain a list of available Relays</p>
						</div>
						<div class="col-sm-8 col-sm-pull-4">
							<kbd class="btn-success">GET</kbd>
							<a href=./relay />/relay/</a>
						</div>
					</div>
				</div>

			</div>
			<a href="api">API</a>
		</div>
	</div>

</body>
</html>
