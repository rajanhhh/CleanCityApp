<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">

<title>Clean City</title>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">


<style type="text/css">
#map {
	/* width: 50%;
    	float:right; */
	height: 450px;
	background: grey;
}

#panel {
	width: 100%;
	height: 400px;
}

body {
	margin-left: 3% !important;
}
</style>
</head>
<body id="markers-on-the-map">


	<div class="page-header">
		<h1>CleanCity Reporting Board</h1>
	</div>


	<form action="/reportBoard" method="post" enctype="multipart/form-data">
		        
		<div>

			<div class="form-group">
				<label>name</label> <input type="text" name="name" required/>

			</div>
			<div class="form-group">
				<label>Address</label> <input type="text" name="address" required/>
			</div>
			<div class="form-group">
				<label>pin</label> <input type="text" name="pin" required/>

			</div>

			<div class="form-group">
				<label>phone</label> <input type="text" name="phone_number" required/>
			</div>
			          <label>Photos: </label>     <input type="file" name="image"
				accept="image/png, image/jpeg" required/>           
		</div>
		    
		<div>
			<input type="submit" value="Submit" name="submit">
		</div>

	</form>




	<div id="errorMessage"></div>

</body>
</html>
