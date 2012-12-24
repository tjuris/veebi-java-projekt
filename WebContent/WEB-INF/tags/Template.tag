<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

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
							<li><a href="${pageContext.request.contextPath}/guard/add">Lisa Piirivalvureid</a></li>
							<li><a href="${pageContext.request.contextPath}/vahtkond/add">Lisa Vahtkondi</a></li>
							<li><a href="${pageContext.request.contextPath}/auaste/add">Lisa Auastmeid</a></li>
							<li><a href="${pageContext.request.contextPath}/vahtkonnaLiige/add">Lisa Vahtkondade Liikmeid</a></li>
							<li><a href="${pageContext.request.contextPath}/piirivalvurAuaste/add">Lisa Piirivalvurite Auastmeid</a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<li><a href="${pageContext.request.contextPath}/guard/show">Näita Piirivalvureid</a></li>
							<li><a href="${pageContext.request.contextPath}/vahtkond/show">Näita Vahtkondi</a></li>
							<li><a href="${pageContext.request.contextPath}/auaste/show">Näita Auastmeid</a></li>
							<li><a href="${pageContext.request.contextPath}/vahtkonnaLiige/show">Näita Vahtkondade Liikmeid</a></li>
							<li><a href="${pageContext.request.contextPath}/piirivalvurAuaste/show">Näita Piirivalvurite Auastmeid</a></li>
							<li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a></li>
						</sec:authorize>
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



