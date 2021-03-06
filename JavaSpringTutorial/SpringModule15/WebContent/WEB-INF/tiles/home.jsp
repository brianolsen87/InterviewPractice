<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<table class="offers">
	<tr>
		<td>Name</td>
		<td>Email</td>
		<td>Username</td>
		<td>Offer</td>
		<td>Contact</td>
	</tr>
	<c:forEach var="offer" items="${offers}">
		<tr>
			<td><c:out value="${offer.user.name}"></c:out></td>
			<td><c:out value='${offer.user.email}'></c:out></td>
			<td><c:out value='${offer.username}'></c:out></td>
			<td><c:out value="${offer.text}"></c:out></td>
			<td><a href="<c:url value='/message?uid=${offer.username}'/>">contact</a></td>
		</tr>

	</c:forEach>
</table>
<br/>



<script type = "text/javascript">
	<!-- 
	-->
	
	function updateMessageLink(data){
		$("#numberMessages").text(data.number);
		//alert(data.number);
	}
	
	function onLoad(){
		updatePage();
		window.setInterval(updatePage, 5000);
	}
	
	function updatePage(){
		$.getJSON("<c:url value='/getmessages'/>", updateMessageLink);
	}
	
	$(document).ready(onLoad);
	
	
</script>
