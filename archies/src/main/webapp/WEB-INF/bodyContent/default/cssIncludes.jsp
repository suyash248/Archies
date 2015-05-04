<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:set var="cssList" value="{
		'/resources/css/bootstrap/bootstrap.min.css',
		'/resources/css/bootstrap/bootstrap-theme.min.css',
		'/resources/css/bootstrapValidator/bootstrapValidator.min.css',
		'/resources/css/datepicker/datepicker.css',
		'/resources/css/fontawesome/css/font-awesome.min.css',
		'/resources/css/customApp/nav.css',
		'/resources/css/customApp/sidebar.css',
		'/resources/css/customApp/archies.css',
		'/resources/css/customApp/bubble.css'
	}" >
</s:set>
<s:iterator var="cssFile" value="%{#cssList}" >
	<link rel="stylesheet" media="print,screen" href='<s:url value="%{#cssFile}" ></s:url>' >
</s:iterator>