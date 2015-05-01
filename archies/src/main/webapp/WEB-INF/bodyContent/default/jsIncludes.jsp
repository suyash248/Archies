<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
	
<s:set var="jsList" value="{
		'/resources/js/jQuery/jquery-2.1.3.min.js',
		'/resources/js/bootstrap/bootstrap.min.js',
		'/resources/js/bootstrapValidator/bootstrapValidator.min.js',
		'/resources/js/datepicker/bootstrap-datepicker.js',
		'/resources/js/malsupForm/jquery.form.min.js',
		'/resources/js/customApp/customApp.js'
	}" >
</s:set>
	
<s:iterator var="jsFile" value="%{#jsList}" >
	<script src='<s:url value="%{#jsFile}" ></s:url>' ></script>
</s:iterator>