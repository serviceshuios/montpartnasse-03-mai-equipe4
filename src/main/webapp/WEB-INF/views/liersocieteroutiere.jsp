<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attribuer Routiere</title>
</head>
<body>
<div>
	<f:form modelAttribute="routiere" method="POST" action="attribuerRoutiere">
		<table>
		<tr>
		<td>
		
		Societe de transport : <br/>
			<select name="idSociete">
				<optgroup>
					<option value="0">....</option>
					<c:if test="${! empty societeTransports}">
						<c:forEach items="${societeTransports}" var="st">
							<option value="${st.idSociete}">
								<c:out value="${st.nomSociete}, ${st.numSiret}, ${st.dateCreation}">
								</c:out></option>
						</c:forEach>
					</c:if>
				</optgroup>
			</select>
			</td>
			</tr>
			<tr>
		<td>
		
		Cargaison Routiere: <br/>
			<select name="idCargaison">
				<optgroup>
					<option value="0">....</option>
					<c:if test="${! empty routieres}">
						<c:forEach items="${routieres}" var="r">
							<option value="${r.idCargaison}">
								<c:out value="${r.nomCargaison},${r.depart},${r.destination}, ${r.immatriculation}, ${r.peage}">
								</c:out></option>
						</c:forEach>
					</c:if>
				</optgroup>
			</select>
			</td>
			</tr>
			<tr>
						<td><input type="submit" value="enregistrer" /></td>
			</tr>
		</table>
		
	</f:form>
</div>
</body>
</html>