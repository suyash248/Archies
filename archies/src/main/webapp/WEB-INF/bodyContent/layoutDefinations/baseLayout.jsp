<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<s:include value="/WEB-INF/bodyContent/default/cssIncludes.jsp"/>	
	
</head>

<body bgcolor="#f8f8f8">
	<s:include value="/WEB-INF/bodyContent/default/jsIncludes.jsp" />
	
	<%-- <script>
		$(function(){
			// Handle active <li> in nav bar.
			$(".nav a").on("click", function(){
			   $(".nav").find(".active").removeClass("active");
			   $(this).parent().addClass("active"); 
			});
		});
	</script> --%>
	
	<!-- Image -->
	<div id="defImg" class="col-sm-12">
		<div class="col-sm-3">
			<img src="<s:url value='/resources/images/logo/archies_logo_txt_dark.jpg'/>">
		</div>
		<div class="col-sm-8">
			<div class="btn-group" style="float:right; margin-top:2%">
			  <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			    <sec:authentication property="principal.username"/> <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a href="#"><i class="fa fa-user"></i> My Profile</a></li>
			    <li><a href="#"><i class="fa fa-cog"></i> Account Settings</a></li>
			    <li><a href="#"><i class="fa fa-lock"></i> Privacy Settings</a></li>
			    <li class="divider"></li>
			    <li><a href="<s:url value='/home/logout'/>"><i class="fa fa-power-off"></i> Logout</a></li>
			  </ul>
			</div>
			<%-- <a style="float:right; margin-top:2%" href="<s:url value='/home/logout'/>"><i class="fa fa-power-off fa-2x"></i></a> --%>
		</div>
	</div>
	
	<!-- Nav-Bar -->
	<nav class="col-sm-12 navbar">
	  <div class="container-fluid">
	    <div>
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Home</a></li>
	        <li class="dropdown">
	          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1
	          <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Page 1-1</a></li>
	            <li><a href="#">Page 1-2</a></li>
	            <li><a href="#">Page 1-3</a></li> 
	          </ul>
	        </li>
	        <li><a href="#">Page 2</a></li> 
	        <li><a href="#">Page 3</a></li> 
	      </ul>
	    </div>
	  </div>
	</nav>
	<%-- <a class="btn btn-default navbar-text navbar-right col-sm-1" style="margin-right:5px" href="<s:url value='/home/logout'/>">Logout <span class="badge"> <i class="fa fa-power-off"></i></span></a> --%>
	
	<!-- Left-Menu Content -->
	<!-- <div id="leftmenu" class="col-sm-3" style="padding:10px"> -->
		<tiles:insertAttribute name="leftMenuContent" />
	<!-- </div> -->
	
	<!-- Main-Body Content -->
	<div id="right" class="col-sm-9">
		<div id="msgDiv" class="alert alert-success" style="display:none"></div>
		<div id="errDiv" class="alert alert-danger" style="display:none"></div>
		
		<s:if test="hasActionErrors()">
			<s:iterator value="actionErrors">
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<p><s:property escape="false" /></p>
				</div>
			</s:iterator><br/>
		</s:if>
		<!-- Informative messages -->
		<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">
				<div class="alert alert-success">
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<p><s:property escape="false" /></p>
				</div>
			</s:iterator>
		</s:if>
		
		<div id="rightbody"><tiles:insertAttribute name="bodyContent" /></div>
	</div>
</body>
</html>
