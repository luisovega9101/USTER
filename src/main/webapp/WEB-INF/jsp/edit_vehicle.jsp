	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</br><h3><center><spring:message code="label.selection1c"/></center></h3></br>

<div class="container col-lg-5">
	<form:form action="edit_vehicle.html" modelAttribute="vehicles" method="POST">
	
		<input type="hidden" name="id" value="${vehicles.id}" />
	
		<div class="form-group">
			<label for="brand"><spring:message code="col2.veh" /></label>
			<input type="text" class="form-control" id="brand" name="brand" maxlength="55"
				placeholder="<spring:message code="col2.veh.placeh"/>" value="${vehicles.brand}" required/>
			<form:errors path="brand" cssClass="error" />
		</div>
		
		<div class="form-group">
			<label for="model"><spring:message code="col3.veh" /></label>
			<input type="text" class="form-control" id="model" name="model" maxlength="55"
				placeholder="<spring:message code="col3.veh.placeh"/>" value="${vehicles.model}" required/>
			<form:errors path="model" cssClass="error" />
		</div>
		
		<div class="form-group">
			<label for="plate"><spring:message code="col4.veh.placeh" /></label>
			<input type="text" class="form-control" id="plate" name="plate" maxlength="10"
				placeholder="<spring:message code="col4.veh.placeh"/>" value="${vehicles.plate}" required
				style="text-transform:uppercase;" onkeyup="javascript:this.value=this.value.toUpperCase();"/>
			<form:errors path="plate" cssClass="error" />
		</div>
		
		<div class="form-group">
			<label for="licenseRequired"><spring:message code="col5.veh" /></label>
			<input type="text" class="form-control" id="licenseRequired" name="licenseRequired" maxlength="1"
				placeholder="<spring:message code="col5.veh.placeh"/>" value="${vehicles.licenseRequired}" required
				style="text-transform:uppercase;" onkeyup="javascript:this.value=this.value.toUpperCase();"/>
			<form:errors path="licenseRequired" cssClass="error" />
		</div>
		
		<div class="form-group">
			<c:if test = "${exist}">
				<span class="error"><spring:message code="validator.exist"/></span>
	      	</c:if>
		</div>
		
		<div class="form-group text-right">
			<input type="button" name="cancel" value="<spring:message code="btn.cancel"/>" 
				onclick="self.location.href = 'list_vehicle.html'" onkeypress="self.location.href = 'list_vehicle.html'"  
				class="btn btn-lg btn-light" role="button" />
			<input type="submit" name="save" value="<spring:message code="btn.save"/>" 
				class="btn btn-lg btn-success" role="button" />		
		</div>
	
	</form:form>
</div>

<script>
	bootstrapValidate('#brand', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#model', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#plate', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#licenseRequired', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#brand', 'max:55: <spring:message code="validator.max55"/>');
	bootstrapValidate('#model', 'max:55: <spring:message code="validator.max55"/>');
	bootstrapValidate('#plate', 'max:10: <spring:message code="validator.max10"/>');
	bootstrapValidate('#licenseRequired', 'max:1: <spring:message code="validator.max1"/>');
</script>