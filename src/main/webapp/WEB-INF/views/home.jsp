<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="bar">
                <nav class="container">
                    <a href="http://localhost:8080/MavenSpringDataMvc">Accueil</a>
                    <a href="http://localhost:8080/MavenSpringDataMvc/indexAerienne">Cargaison aerienne</a>
                    <a href="http://localhost:8080/MavenSpringDataMvc/indexRoutiere">Cargaison routiere</a>
                    <a href="http://localhost:8080/MavenSpringDataMvc/indexSocieteTransport">Societe transport</a>
                </nav>
            </div>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
