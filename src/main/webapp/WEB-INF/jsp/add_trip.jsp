<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/function_date.js"></script>

</br><h3><center><spring:message code="label.selection3a"/></center></h3></br>

<div class="container col-lg-5">
	
	<form:form action="select_date.html" method="GET">
		<div class="form-group">
			<label for="datefield"><spring:message code="selection.date" />*</label> 
			<input type="date" class="form-control" id="datefield" value="${value[0]}" onchange="this.form.submit()"
				min='1899-01-01' max='2000-13-13' name="datefield" onkeydown="return false"/>
		</div>
	</form:form>
	
    <form:form action="select_vehicle.html" method="GET">
    	<div class="form-group">
    		<label for="vehicle_select"><spring:message code="selection.veh" />*</label> 
		    <select class="form-control" onchange="this.form.submit()"
		    		id="vehicle_select" name="vehicle_select" ${value[3]}>		    	
		    	<c:forEach items="${vehicles}" var="v">
		    		<option value="${v[0]}"
		    		<c:if test = "${value[1] == v[0]}">
		    			<c:out value="selected"></c:out>
		    		</c:if>
		    		>${v[1]}</option>  
		    	</c:forEach>    		    	
		    </select>
			<c:if test = "${value[3]=='disabled'}">
				<span class="error"><spring:message code="validator.trip.vehi"/></span>
	      	</c:if>
	    </div>
	</form:form>
	
	<form:form action="select_driver.html" method="GET">
    	<div class="form-group">
    		<label for="driver_select"><spring:message code="selection.driv" />*</label> 
		    <select class="form-control" onchange="this.form.submit()"
		    		id="driver_select" name="driver_select" ${value[4]}>      			    
			    <c:forEach items="${drivers}" var="d">
		    		<option value="${d[0]}"
		    		<c:if test = "${value[2] == d[0]}">
		    			<c:out value="selected"></c:out>
		    		</c:if>
		    		>${d[1]}</option>  
		    	</c:forEach> 		    	
		    </select>
		    <c:if test = "${value[4]=='disabled'}">
				<span class="error"><spring:message code="validator.trip.driv"/></span>
	      	</c:if>
	    </div>
	</form:form>
		
	<form:form action="add_trip.html" method="POST">				
		<div class="form-group text-right">
			<input type="button" name="cancel" value="<spring:message code="btn.cancel"/>" 
				onclick="self.location.href = 'list_trip.html'" onkeypress="self.location.href = 'list_driver.html'"  
				class="btn btn-lg btn-light" role="button" />
			<input type="submit" name="save" value="<spring:message code="btn.save"/>" 
				class="btn btn-lg btn-success" role="button" ${value[5]}/>		
		</div>	
	</form:form>
</div>