<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
	<title>Login-Archies</title>
	<head>
		<s:include value="/WEB-INF/bodyContent/default/cssIncludes.jsp"></s:include>
		<style>
			body {
			    background: url('<s:url value="/resources/images/mehandiBg.jpg"/>');
			    background-size: cover;
			}
			
			.alert, .panel {
				opacity: 0.8;
			}
		</style>
	</head>
    <body>
    	<s:include value="/WEB-INF/bodyContent/default/jsIncludes.jsp"></s:include>
    	<script>
    		$(function(){
    			$('#loginform').bootstrapValidator();
    			$('#signupForm').bootstrapValidator();
    			
    		});
    	</script>
    	<div class="container">    
	        <div id="loginbox" style="margin-top:10%;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	        	<s:if test="%{#parameters.error != null}">
		            <div id="loginalert" class="alert alert-danger">Incorrect username or password.</div>    
		        </s:if>
		        <s:elseif test="%{#parameters.logout != null}">
		            <div id="loginalert" class="alert alert-info">Logged out successfully.</div>    
		        </s:elseif>
				<div class="panel panel-default" >
					<div class="panel-heading">
						<div class="panel-title">Sign In</div>
					</div>     
					<div style="padding-top:30px" class="panel-body" >
	                        <s:form name="loginForm" action="j_spring_security_check" method="post"  id="loginform" class="form-horizontal" role="form" novalidate="novalidate">                                    
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
							<div class="form-group">
								<div class="col-md-12 control">
									<div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
										Don't have an account? <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">Sign Up Here</a>
									</div>
								</div>
							</div>    
						</div>                     
					</div>
	        	</div>
	        	
	        	<div id="signupbox" style="display:none; margin-top:10%" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	        		<div id="signupalert" style="display:none" class="alert alert-danger"></div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                        </div>  
                        <div class="panel-body" >
                            <s:form id="signupForm" class="form-horizontal" role="form" novalidate="novalidate">
                                <div class="form-group">
                                    <div class="col-md-12">
                                    	<div class="input-group">
											<span class="input-group-addon">@</i></span>
                                        	<s:textfield cssClass="form-control" name="email" placeholder="Email" data-bv-emailaddress="true" required="true" theme="simple"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
	                                    <div class="input-group">
											<span class="input-group-addon"><i class="fa fa-font"></i></i></span>
	                                        <s:textfield cssClass="form-control" name="firstname" placeholder="First Name" required="true" theme="simple" />
	                                    </div>
									</div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                    	<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-font"></i></i></span>
                                        	<s:textfield cssClass="form-control" name="lastname" placeholder="Last Name" required="true" theme="simple"/>
                                    	</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12">
                                    	<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></i></span>
                                        	<s:password id="pass" cssClass="form-control" name="user.userPass" placeholder="Password" required="true" theme="simple"/>
										</div>
									</div>
                                </div>
                               <div class="form-group">
                                    <div class="col-md-12">
                                    	<div class="input-group">
											<span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></i></span>
                                        	<s:password id="confirmPass" cssClass="form-control" name="passwd" data-match="#pass" 
                                        	placeholder="Confirm Password" required="true" theme="simple"
                                        	data-bv-identical="true"
							                data-bv-identical-field="user.userPass"
							                data-bv-identical-message="The passwords do not match"/>
										</div>
									</div>
                                </div>
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-sm-12">
                                        <s:submit id="btn-signup" value="Sign Up" cssClass="btn btn-warning" cssStyle="width:40%" theme="simple"/>
                                    </div>
                                </div>
                            </s:form>
                            <div class="form-group">
									<div class="col-sm-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Already have account? <s:a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In Here</s:a>
                                        </div>
									</div>
								</div>    
                         </div>
					</div>
        		</div> 

			</div>
	</body>
</html>


     <%--  <s:if test="%{#parameters.error != null}">
            <div style="color: red">Invalid User</div>
        </s:if> --%>