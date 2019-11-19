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
		<a class="btn btn-primary" href="<c:url value="add_driver.html"/>"><spring:message code="label.selection2a"/></a>
	</div>
		
	<div class="table table-hover">
		<table id="list" class="table-active table-borderless" >
		  <caption class="caption"><spring:message code="list.driv"/></caption>
		  <thead>
		    <tr>
		      <th scope="col"><spring:message code="col1"/></th>
		      <th scope="col"><spring:message code="col2.driv"/></th>
		      <th scope="col"><spring:message code="col3.driv"/></th>
		      <th scope="col"><spring:message code="col4.driv"/></th>      
		      <th scope="col"><spring:message code="col0"/></th>
		    </tr>
		  </thead>
		  <tbody>
		  	<%
				int cont = 0;
			%>
		  	<c:forEach items="${Adrivers}" var="driver">
			    <tr>
			    	<%
						cont++;
					%>
			      <th scope="row"><c:out value="<%=cont%>"></c:out></th>
			      <td>${driver.name}</td>
			      <td>${driver.surname}</td>
			      <td>${driver.license}</td>
			      <td>
			      	<a href="edit_driver.html?id=${driver.id}" class="btn btn-warning"><spring:message code="btn.edit"/></a>
			    	<a id="confirmation${driver.id}" name="confirmation" href="#" 
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
		      <th scope="col"><spring:message code="col2.driv"/></th>
		      <th scope="col"><spring:message code="col3.driv"/></th>
		      <th scope="col"><spring:message code="col4.driv"/></th>      
		      <th scope="col"><spring:message code="col0"/></th>
		    </tr>
		  </tfoot>
		</table>		
	</div>
	
<script>
$(document).ready(function() {
	$("*[name='confirmation']").on('click', function () {
		var id_confirmation = $(this).attr('id');
	    var id = id_confirmation.replace("confirmation","");
        if (confirm('<spring:message code="confirmation.driv"/>')){
        	window.location.href = 'delete_driver.html?id=' + id;
        };
    })
	
});
/*
$(document).ready(function() {
	$("*[name='confirmation']").click(function(){
	    var id_confirmation = $(this).attr('id');
	    var id = id_confirmation.replace("confirmation","");
	    
	    bootbox.confirm({
	        message: '<spring:message code="confirmation.driv"/>',
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
	  	          window.location = 'delete_driver.html?id=' + id;
	        	}
	        }	   
	    });
	})  
});
*/
</script>