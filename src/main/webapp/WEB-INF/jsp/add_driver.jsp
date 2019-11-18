<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</br><h3><center><spring:message code="label.selection2a"/></center></h3></br>

<div class="container col-lg-5">
	<form:form action="add_driver.html" modelAttribute="drivers" method="POST">
	
		<input type="hidden" name="id" value="${drivers.id}" />
		
		<div class="form-group">
			<label for="name"><b><spring:message code="col2.driv" />*</b></label>
			<input type="text" class="form-control" id="name" name="name" maxlength="55"
				placeholder="<spring:message code="col2.driv.placeh"/>" value="${drivers.name}" required/>
			<form:errors path="name" cssClass="error" />
		</div>
		
		<div class="form-group">
			<label for="surname"><b><spring:message code="col3.driv" />*</b></label>
			<input type="text" class="form-control" id="surname" name="surname" maxlength="55"
				placeholder="<spring:message code="col3.driv.placeh"/>" value="${drivers.surname}" required/>
			<form:errors path="surname" cssClass="error" />
		</div>
		
		<div class="form-group">
			<label for="license"><b><spring:message code="col4.driv" />*</b></label>
			<input type="text" class="form-control" id="license" name="license" maxlength="1"
				placeholder="<spring:message code="col4.driv.placeh"/>" value="${drivers.license}" required
				onkeyup="javascript:this.value=this.value.toUpperCase();"/>
			<form:errors path="license" cssClass="error" />
		</div>
		
		<div class="form-group">
			<c:if test = "${exist}">
				<span class="error"><spring:message code="validator.exist"/></span>
	      	</c:if>
		</div>
				
		<div class="form-group text-right">
			<input type="button" name="cancel" value="<spring:message code="btn.cancel"/>"
				onclick="self.location.href = 'list_driver.html'" onkeypress="self.location.href = 'list_driver.html'"  
				class="btn btn-lg btn-light" role="button" />
			<input type="submit" name="save" value="<spring:message code="btn.save"/>" 
				class="btn btn-lg btn-success" role="button" />		
		</div>
	
	</form:form>
</div>

<script>
	bootstrapValidate('#name', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#surname', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#license', 'required: <spring:message code="validator.required"/>');
	bootstrapValidate('#name', 'max:55: <spring:message code="validator.max55"/>');
	bootstrapValidate('#surname', 'max:55: <spring:message code="validator.max55"/>');
	bootstrapValidate('#license', 'max:1: <spring:message code="validator.max1"/>');
</script>