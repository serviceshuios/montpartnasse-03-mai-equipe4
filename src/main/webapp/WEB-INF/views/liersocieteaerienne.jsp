<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Attribuer Aerienne</title>
</head>
<body>
<div>
	<f:form modelAttribute="aerienne" method="POST" action="attribuerAerienne">
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
		
		Cargaison Aerienne : <br/>
			<select name="idCargaison">
				<optgroup>
					<option value="0">....</option>
					<c:if test="${! empty aeriennes}">
						<c:forEach items="${aeriennes}" var="a">
							<option value="${a.idCargaison}">
								<c:out value="${a.nomCargaison},${a.depart},${a.destination}, ${a.numVol}, ${a.taxe}">
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