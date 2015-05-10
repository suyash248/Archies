<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form name="loginForm" action="/j_spring_security_check" method="post"  id="loginform" class="form-horizontal" role="form" novalidate="novalidate">                                    
	<div class="form-group" >
		<div class="col-sm-12">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<s:textfield id="login-username" cssClass="form-control" name="username" placeholder="username or email" theme="simple" required="true"/> <!-- data-bv-emailaddress="true" -->
			</div>
		</div>
	</div>
	<div class="form-group" >
		<div class="col-sm-12">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></span>
				<s:password id="login-password" cssClass="form-control" name="password" placeholder="password" theme="simple" required="true"/>
			</div>
		</div>
	</div>
	<div class="form-group" >
		<div id="submitOpportunityInfoDiv" class="col-sm-12">
			<s:submit id="btn-login" cssClass="btn btn-warning" theme="simple" value="Login" cssStyle="width:25%"/>
			<s:a cssStyle="float:right;" href="#">Forgot password?</s:a>
		</div>
	</div>
</s:form>