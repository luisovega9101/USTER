<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/bootbox.all.min.js"></script>
<script src="js/function.js"></script>

	<div class="form-group" id="right">
		<a class="btn btn-primary" href="<c:url value="add_vehicle.html"/>"><spring:message code="label.selection1a"/></a>
	</div>
		
	<div class="table table-hover">
		<table id="list" class="table-active table-borderless" >
		  <caption class="caption"><spring:message code="list.veh"/></caption>
		  <thead>
		    <tr>
		      <th scope="col"><spring:message code="col1"/></th>
		      <th scope="col"><spring:message code="col2.veh"/></th>
		      <th scope="col"><spring:message code="col3.veh"/></th>
		      <th scope="col"><spring:message code="col4.veh"/></th>
		      <th scope="col"><spring:message code="col5.veh"/></th>	      
		      <th scope="col"><spring:message code="col0"/></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<%
				int cont = 0;
			%>
		  	<c:forEach items="${Avehicles}" var="vehicle">
			    <tr>
			    	<%
						cont++;
					%>
			      <th scope="row"><c:out value="<%=cont%>"></c:out></th>
			      <td>${vehicle.brand}</td>
			      <td>${vehicle.model}</td>
			      <td>${vehicle.plate}</td>
			      <td>${vehicle.licenseRequired}</td>
			      <td>
			      	<a href="edit_vehicle.html?id=${vehicle.id}" class="btn btn-warning"><spring:message code="btn.edit"/></a>
			      	<a id="confirmation${vehicle.id}" name="confirmation" href="delete_vehicle.html?id=${vehicle.id}" 
			      		class="btn btn-danger"><spring:message code="btn.delete"/></a>
			      </td>
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
		      <th scope="col"><spring:message code="col2.veh"/></th>
		      <th scope="col"><spring:message code="col3.veh"/></th>
		      <th scope="col"><spring:message code="col4.veh"/></th>
		      <th scope="col"><spring:message code="col5.veh"/></th>	      
		      <th scope="col"><spring:message code="col0"/></th>
		    </tr>
		  </tfoot>
		</table>		
	</div>
	
<script>
$(document).ready(function() {
	$("*[name='confirmation']").click(function(){
	    var id_confirmation = $(this).attr('id');
	    var id = id_confirmation.replace("confirmation","");
	    
	    bootbox.confirm({
	        message: '<spring:message code="confirmation.veh"/>',
	        buttons: {
	            confirm: {
	                label: '<spring:message code="btn.delete"/>',
	                className: 'btn-danger'
	            },
	            cancel: {
	                label: '<spring:message code="btn.cancel"/>',
	                className: 'btn-light'
	            }
	        },
	        callback: function (result) {
	        	if(result){
	  	          window.location = 'delete_vehicle.html?id=' + id;
	        	}
	        }	   
	    });
	})  
});

</script>