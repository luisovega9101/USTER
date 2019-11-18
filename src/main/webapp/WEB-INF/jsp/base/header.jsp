<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<nav class="navbar navbar-expand-lg navbar-light bg-light"> 
		<a class="navbar-brand" href="<c:url value="start.html"/>">USTER</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <spring:message	code="label.selection1" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="<c:url value="add_vehicle.html"/>"><spring:message code="label.selection1a" /></a>
	      			<a class="dropdown-item" href="<c:url value="list_vehicle.html"/>"><spring:message code="label.selection1b" /></a>
				</div>
			</li>
			
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <spring:message	code="label.selection2" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="<c:url value="add_driver.html"/>"><spring:message code="label.selection2a" /></a>
	      			<a class="dropdown-item" href="<c:url value="list_driver.html"/>"><spring:message code="label.selection2b" /></a>
				</div>
			</li>
			
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <spring:message	code="label.selection3" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="<c:url value="add_trip.html"/>"><spring:message code="label.selection3a" /></a>
	      			<a class="dropdown-item" href="<c:url value="list_trip.html?list_element=list_made"/>"><spring:message code="label.selection3d" /></a>
				</div>
			</li>
		</ul>
		
		<ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
			<!-- 
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"><spring:message code="label.menu1" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="?theme=darkly"><spring:message code="label.color1" /></a>
	      			<a class="dropdown-item" href="?theme=cosmo"><spring:message code="label.color2" /></a>
				</div>
			</li>
		 	-->	
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"><spring:message code="label.menu2" />
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="?lang=es"><spring:message code="label.spanish" /></a> 
					<a class="dropdown-item" href="?lang=en"><spring:message code="label.english" /></a>
				</div>
			</li>
		</ul>
	</div>
	</nav>
	