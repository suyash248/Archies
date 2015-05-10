<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form id="registerForm" action="registration/register" namespace="/" class="form-horizontal" role="form" novalidate="novalidate">
	<div class="form-group">
		<div class="col-sm-12">
			<label class="col-sm-3 control-label">Name</label>
			<div class="col-sm-9">
				<s:textfield cssClass="form-control" name="newUser.firstName" placeholder="First Name" required="true" theme="simple" />
				<s:textfield cssClass="form-control" name="newUser.lastName" placeholder="Last Name" theme="simple" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-12">
			<label class="col-sm-3 control-label">Password</label>
			<div class="col-sm-9">
	  			<div class="input-group">
	 				<s:password id="pass" cssClass="form-control" name="newUser.userPass" placeholder="Password" required="true" theme="simple" 
	 					data-bv-stringlength="true" data-bv-stringlength-min="4" data-bv-stringlength-max="15" data-bv-stringlength-message="Password length must be beween 4 to 15"/>
	 				<span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></i></span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-12">
			<label class="col-sm-3 control-label">Confirm Password</label>
			<div class="col-sm-9">
				<div class="input-group">
					<s:password id="confirmPass" cssClass="form-control" name="passwd" required="true" theme="simple" placeholder="Confirm Password" data-match="#pass" 
	                       data-bv-identical="true" data-bv-identical-field="newUser.userPass" data-bv-identical-message="The passwords do not match"/>
	              	<span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></i></span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">Email</label>
			<div class="col-sm-9">
				<s:textfield cssClass="form-control" name="newUser.email" placeholder="Email" data-bv-emailaddress="true" required="true" theme="simple"/>
			</div>
		</div>
	</div>
	
	<%-- 
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">Phone</label>
			<div class="col-sm-9">
				<div class="input-group">
					<s:textfield cssClass="form-control" name="phone" placeholder="Mobile No." required="true" theme="simple"
						data-bv-integer="true" data-bv-integer-message="Please enter integers only." 
						data-bv-stringlength="true" data-bv-stringlength-max="10" data-bv-stringlength-min="10" data-bv-stringlength-message="Phone number must be 10 digits long."/>
					<span class="input-group-addon"><i class="fa fa-phone"></i></i></span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">Gender</label>
			<div class="col-sm-9">
				<s:radio name="gender" list="#{'Male':'Male', 'Female':'Female'}" theme="simple"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">D.O.B.</label>
			<div class="col-sm-9">
				<div class="input-group">
					<s:textfield cssClass="form-control datepicker" name="dob" placeholder="Date of birth" disabled="disabled" theme="simple" />
					<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
				</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">Profile For</label>
			<div class="col-sm-9">
				<s:select list="allProfileFor" listKey="code" listValue="value" theme="simple" headerKey="" headerValue="" cssClass="form-control" cssStyle="width:100%"
				 	required="true"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">Religion</label>
			<div class="col-sm-9">
				<s:select list="allReligions" listKey="code" listValue="value" theme="simple" headerKey="" headerValue="" cssClass="form-control" cssStyle="width:100%"
					required="true"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-12">
			<label class="col-sm-3 control-label">Mother Tongue</label>
			<div class="col-sm-9">
				<s:select list="allMotherTongues" listKey="code" listValue="value" theme="simple" headerKey="" headerValue="" cssClass="form-control" cssStyle="width:100%"
					required="true"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-12">
			<label class="col-sm-3 control-label">Country</label>
			<div class="col-sm-9">
				<s:select list="allCountries" listKey="countryId" listValue="countryName" theme="simple" headerKey="" headerValue="" cssClass="form-control" 
					cssStyle="width:100%" required="true" />
			</div>
		</div>
	</div> --%>
	<div class="form-group">
        <div class="col-sm-12">
			<label class="col-sm-3 control-label"><!-- <input type="checkbox" name="agree" class="form-control"/> I agree to T&C --></label>
			<div class="col-sm-9">
				<%--  --%>
	            <s:submit id="btn-signup" value="Sign Up" cssClass="btn btn-warning" cssStyle="width:40%" theme="simple"/>
            </div>
        </div>
    </div>
</s:form>