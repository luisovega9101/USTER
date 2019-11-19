<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/function.js"></script>
		
	<div class="form-group" id="right">
		<a class="btn btn-primary" href="<c:url value="add_trip.html"/>"><spring:message code="label.selection3a"/></a>
	</div>
	
	<form:form action="list_trip.html" method="GET">
    	<div class="form-group row" style="width:90%; margin-left: 4%; margin-right: 4%;">
    		<label for="list_element" class="col-sm-2 col-form-label"><spring:message code="label.selection3d" />:</label>
		    <div class="col-sm-3">
		    	<select class="form-control" onchange="this.form.submit()" id="list_element" name="list_element">
			    	<option value="list_made" 
			    		<c:if test="${select_element=='list_made'}"> selected </c:if> >
			    		<spring:message code="label.selection3b"/></option>  
			    	<option value="list_make" 
			    		<c:if test="${select_element=='list_make'}"> selected </c:if> >
			    		<spring:message code="label.selection3c"/></option>     		    	
			    </select>
		    </div>
	    </div>
	</form:form>
		
	<div class="table table-hover">	
		<table id="list" class="table-active table-borderless">
		  <c:choose>
		    <c:when test="${select_element=='list_made'}">
		        <caption class="caption"><spring:message code="list.trip"/></caption>
		    </c:when>    
		    <c:when test="${select_element=='list_make'}">
		        <caption class="caption"><spring:message code="list.trip.be"/></caption>
		    </c:when> 
		  </c:choose>
		  <thead>
		    <tr>
		      <th scope="col"><spring:message code="col1"/></th>
		      <th scope="col"><spring:message code="col2.trip"/></th>
		      <th scope="col"><spring:message code="col3.trip"/></th>
		      <th scope="col"><spring:message code="col4.trip"/></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<%
				int cont = 0;
			%>
		  	<c:forEach items="${trips_list}" var="trip">
			    <tr>
			    	<%
						cont++;
					%>
			      <th scope="row"><c:out value="<%=cont%>"></c:out></th>
			      <td>
			      	<fmt:parseDate value="${trip[0]}" pattern="yyyy-MM-dd" var="myDate"/>
					<fmt:formatDate value="${myDate}" var="startFormat" pattern="dd-MM-yyyy"/>
					<c:out value = "${startFormat}"/>
			      </td>
			      <td>${trip[1]}</td>
			      <td>${trip[2]}</td>			      
			    </tr>
		    </c:forEach>
		    
		    <%
				if (cont == 0) {
			%>
			<tr>
				<td id="no_result" colspan="6"><spring:message code="no.result"/></td>
				<%
					}
				%>
			</tr>				    
		  </tbody>
		  <tfoot>
		    <tr>
		      <th scope="col"><spring:message code="col1"/></th>
		      <th scope="col"><spring:message code="col2.trip"/></th>
		      <th scope="col"><spring:message code="col3.trip"/></th>
		      <th scope="col"><spring:message code="col4.trip"/></th>
		    </tr>
		  </tfoot>
		</table>
	</div>