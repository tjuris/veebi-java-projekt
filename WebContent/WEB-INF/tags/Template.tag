<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<jsp:doBody />
		</div>
	</div>

	<br>
	
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<div class="nav-collapse collapse">
					<ul class="nav">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="${pageContext.request.contextPath}/guard/delete">Delete Guard</a></li>
							<li><a href="${pageContext.request.contextPath}/borderStation/delete">Delete Border Station</a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<li><a href="${pageContext.request.contextPath}/guard/update">Update Guard</a></li>
							<li><a href="${pageContext.request.contextPath}/borderStation/update">Update Border Station</a></li>
							<li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
						</sec:authorize>
							<li><a href="${pageContext.request.contextPath}/guard/show">Show Guard</a></li>
							<li><a href="${pageContext.request.contextPath}/borderStation/show">Show Border Station</a></li>
							<li><a href="${pageContext.request.contextPath}/j_spring_security_check">Login</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<script src="/http://code.jquery.com/jquery-latest.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>



