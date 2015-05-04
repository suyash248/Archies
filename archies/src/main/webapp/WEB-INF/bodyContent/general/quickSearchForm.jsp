<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form id="searchForm" class="form-horizontal" role="form" novalidate="novalidate">
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
        <div class="col-sm-12">
            <s:submit id="btn-signup" value="Search" cssClass="btn btn-warning" cssStyle="width:40%" theme="simple"/>
        </div>
    </div>
</s:form>