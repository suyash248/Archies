<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
	<title>Login-Archies</title>
	<head>
		<s:include value="/WEB-INF/bodyContent/default/cssIncludes.jsp"></s:include>
		<style>
			body {
				margin-left:10%;
				margin-right:10%;
			}
			#weddingHands {
			    background: url('<s:url value="/resources/images/coupleSI.jpg"/>');
			    background-size: cover;
			    background-repeat:no-repeat;
			    height:500px
			}
		</style>
	</head>
    <body>
    	<s:include value="/WEB-INF/bodyContent/default/jsIncludes.jsp"></s:include>
    	<script>
    		$(function(){
    			$('#loginform').bootstrapValidator();
    			$('#registerForm').bootstrapValidator();
    			$('#guestTabs a').click(function (e) {
				  e.preventDefault()
				  $(this).tab('show')
				})
    		});
    	</script>
    	
    	<div id="defImg" class="col-sm-12">
			<div class="col-sm-3"><img src="<s:url value='/resources/images/logo/archies_logo_txt_dark.jpg'/>"></div>
		</div>
   		<div id="weddingHands" class="col-sm-12">
			<div class="col-sm-offset-7 col-sm-5" style="margin-top:-2%">
		        <div>
		        	<s:if test="%{#parameters.error != null}">
			            <div id="loginalert" class="alert alert-danger">
			            	Incorrect username or password.
			            	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			            </div>    
			        </s:if>
			        <s:elseif test="%{#parameters.logout != null}">
			            <div id="loginalert" class="alert alert-info">
			            	Logged out successfully.
			            	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>	
			            </div>    
			        </s:elseif>
					<div class="panel panel-default">    
						<div class="panel-body" >
	    					<div role="tabpanel">
							  <!-- Nav tabs -->
							  <ul id="guestTabs" class="nav nav-tabs" role="tablist">
							    <li role="presentation" class="active"><a href="#quickSearch" aria-controls="home" role="tab" data-toggle="tab">Quick Search</a></li>
							    <li role="presentation"><a href="#login" aria-controls="login" role="tab" data-toggle="tab">Login</a></li>
							    <li role="presentation"><a href="#register" aria-controls="register" role="tab" data-toggle="tab">Register</a></li>
							  </ul>
							  <!-- Tab panes -->
							  <div class="tab-content">
							  
							  	<!-- Search Tab -->
							    <div role="tabpanel" class="tab-pane active" id="quickSearch" style="padding-top:2%">
									<s:include value="/WEB-INF/bodyContent/general/quickSearchForm.jsp"/>
								</div>
							    
							    <!-- Login Tab -->
							    <div role="tabpanel" class="tab-pane" id="login" style="padding-top:2%">
							    	<s:include value="/WEB-INF/bodyContent/general/loginForm.jsp"/>
							    </div>
							    
							    <!-- Register Tab -->
							    <div role="tabpanel" class="tab-pane" id="register" style="padding-top:2%">
									<s:include value="/WEB-INF/bodyContent/general/registerForm.jsp"/>
								</div>
								
							  </div>
							</div>
	    				</div>
	    			</div>
	    		</div>
    		</div>
    	</div>
    	
    	<!-- Success Stories -->
    	<div class="col-sm-8" style="padding-top:1%">
    		<span class="label label-success" style="font-size:16px">Success Stories...</span>
    		<hr style="width: 100%; background-color:#5cb85c; height:1px; margin-bottom:2%; margin-top:1%"/>
    		<div class="bubble-list" id="bubble<s:property value='%{noteId}'/>">
				<div class="bubble clearfix">
					<div class="bubble-content col-sm-12">
				    	<div class="col-sm-3">
					    	<img src="<s:url value='/resources/images/coupleNoBg.jpg'/>" width="120px" height="120px">
					    </div>
					    <div class="col-sm-9">
					  		<p class="noteBody">
					  			<h5>
						  			<b>Nishith & Ishita</b>&nbsp;
					  			</h5>
					  			The only separate color change is to the arrow tip itself. Since that arrow is created using a border we update to the new color using border-bottom-color. The arrows are located at the bottom of each bubble so I’m copying the bottom color from the gradient and using this hex value for the arrow color.
					  		</p>
				  		</div>
					</div>
				</div>
			</div>
		
			<div class="bubble-list" id="bubble<s:property value='%{noteId}'/>">
				<div class="bubble clearfix">
					<div class="bubble-content col-sm-12">
				    	<div class="col-sm-3">
					    	<img src="<s:url value='/resources/images/couple12.jpg'/>" width="120px" height="120px">
					    </div>
					    <div class="col-sm-9">
					  		<p class="noteBody">
					  			<h5>
						  			<b>Tanishq & Manjhari</b>&nbsp;
					  			</h5>
								That's pretty much wraps it all up! Very minimal HTML code and the CSS is easily extensible for additional color schemes. As I mentioned these bubbles are responsive so you could even copy this design for your own mobile-based web application or responsive website layout.					  		</p>
				  		</div>
					</div>
				</div>
			</div>
		
			<div class="bubble-list" id="bubble<s:property value='%{noteId}'/>">
				<div class="bubble clearfix">
					<div class="bubble-content col-sm-12">
				    	<div class="col-sm-3">
					    	<img src="<s:url value='/resources/images/bannerCouple.png'/>" width="120px" height="120px">
					    </div>
					    <div class="col-sm-9">
					  		<p class="noteBody">
					  			<h5>
						  			<b>Pravesh & Nishi</b>&nbsp;
					  			</h5>
								Jake is a freelance writer and user experience designer. He can be found all over the web discussing HTML5, CSS3, and mobile responsive design trends. You can find more work on his portfolio website or follow his updates on Twitter @jakerocheleau.
					  		</p>
				  		</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Featured Profiles -->
		<div class="col-sm-4" style="padding-top:1%">
    		<span class="label label-warning" style="font-size:16px">Featured Profiles...</span>
    		<hr style="width: 100%; background-color:#f0ad4e; height:1px; margin-bottom:2%; margin-top:2%"/>
    		<div class="bubble-list" id="bubble<s:property value='%{noteId}'/>">
				<div class="bubble clearfix">
					<div class="bubble-content col-sm-12">
				    	<div class="col-sm-6">
					    	<img src="<s:url value='/resources/images/girlProfilePic1.jpg'/>" width="120px" height="120px">
					    </div>
					    <div class="col-sm-6">
					  		<p class="noteBody">
					  			<h5>
						  			<b>Ahana Sharma</b>&nbsp;
					  			</h5>
					  			<p>Female, 25 Yrs.</p>
					  			<p><b>Religion: </b>Hindu</p>
					  			<p>Delhi, India</p>
					  		</p>
				  		</div>
					</div>
				</div>
			</div>
			<div class="bubble-list" id="bubble<s:property value='%{noteId}'/>">
				<div class="bubble clearfix">
					<div class="bubble-content col-sm-12">
				    	<div class="col-sm-6">
					    	<img src="<s:url value='/resources/images/girlProfilePic2.jpg'/>" width="120px" height="120px">
					    </div>
					    <div class="col-sm-6">
					  		<p class="noteBody">
					  			<h5>
						  			<b>Isha Rathi</b>&nbsp;
					  			</h5>
					  			<p>Female, 27 Yrs.</p>
					  			<p><b>Religion: </b>Hindu</p>
					  			<p>Pune, India</p>
					  		</p>
				  		</div>
					</div>
				</div>
			</div>
			<div class="bubble-list" id="bubble<s:property value='%{noteId}'/>">
				<div class="bubble clearfix">
					<div class="bubble-content col-sm-12">
				    	<div class="col-sm-6">
					    	<img src="<s:url value='/resources/images/manProfilePic1.jpg'/>" width="120px" height="120px">
					    </div>
					    <div class="col-sm-6">
					  		<p class="noteBody">
					  			<h5>
						  			<b>Shishir John</b>&nbsp;
					  			</h5>
					  			<p>Male, 24 Yrs.</p>
					  			<p><b>Religion: </b>Christian</p>
					  			<p>Mumbai, India</p>
					  		</p>
				  		</div>
					</div>
				</div>
			</div>
		</div>		
	</body>
</html>