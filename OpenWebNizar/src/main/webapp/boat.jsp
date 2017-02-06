<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Liste des bateaux</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
</head>
<body>

 <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Bienvenue ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Deconnexion</a></h2><br><br><br>
		<h3><span>${message}</span></h3>
    </c:if>
 <div class="form-group ">
           
  
        </div>
	<form:form modelAttribute="boatform" method="POST">
	  <h3><span>${message}</span></h3> 
		<div class="row">
		       	
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img src="${contextPath}/resources/img/image1.jpg" alt="...">
					<div class="caption">
						<h3>Bateau Aventura</h3>
						<spring:bind path="boatname">

							<form:input path="boatname" type="hidden" value="bateauAventura"
								placeholder="Ajouter"></form:input>

						</spring:bind>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img src="${contextPath}/resources/img/image2.jpg" alt="...">
					<div class="caption">
						<h3>Bateau Liam</h3>
						<spring:bind path="boatname">

							<form:input path="boatname" type="hidden" value="bateauLiam"
								placeholder="Ajouter"></form:input>

						</spring:bind>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img src="${contextPath}/resources/img/image3.jpg" alt="...">
					<div class="caption">
						<h3>Bateau Tiziana</h3>
						<spring:bind path="boatname">

							<form:input path="boatname" type="hidden" value="bateauTiziana"
								placeholder="Ajouter"></form:input>

						</spring:bind>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img src="${contextPath}/resources/img/image1.jpg" alt="...">
					<div class="caption">
						<h3>Bateau Lago</h3>
						<spring:bind path="boatname">

							<form:input path="boatname" type="hidden" value="bateauLago"
								placeholder="Ajouter"></form:input>

						</spring:bind>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>


	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>

</html>
