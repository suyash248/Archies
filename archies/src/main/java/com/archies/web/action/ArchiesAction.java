package com.archies.web.action;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.archies.model.user.User;
import com.archies.service.auth.AuthServiceImpl.SecureUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public abstract class ArchiesAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, Preparable, SessionAware {
	
	protected String mode = "";
	protected String referer;
	protected Throwable actionException = null;
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected Map session;
	protected String  userName;
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String done() {
		return SUCCESS;
	}
	
	
	/*
	 *  The base class does not do anything. Override this to attach specific behavior
	 */
	public void prepare() throws Exception {
		
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String init(){
		return SUCCESS;
	}
	
	/**
	 * 
	 * @param key
	 * @param args
	 */
	public final void addActionError(String key, Object[] args) 
    {
		this.addActionError(this.getText(key, Arrays.asList(args)));
    }
	
	/**
	 * 
	 * @param key
	 * @param args
	 */
	public final void addActionError(String key,  List<Object> args) 
    {
		this.addActionError(this.getText(key, args));
    }
	/**
	 * Adds a new actionException message with the given arguments. 
	 * 
	 * @param key
	 * @param args
	 */
    public final void addActionMessage(String key, Object[] args) 
    {
    
      this.addActionMessage(this.getText(key, Arrays.asList(args)));
    }
    
    /**
     * Adds a new actionException message with the given arguments. 
     * @param key
     * @param args
     */
    public final void addActionMessage(String key, List<Object> args) 
    {
    	this.addActionMessage(this.getText(key, args));
    }
    
    /**
     * 
     *
     */
    public void reset()
	{
		this.mode = "init";
		this.actionException = null;
	}
    
    /**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}


	/**
	 * @param referer the referer to set
	 */
	public void setReferer(String referer) {
		this.referer = referer;
	}


	/**
	 * @return the actionException
	 */
	public Throwable getActionException() {
		return actionException;
	}

	/**
	 * @param actionException the actionException to set
	 */
	public void setActionException(Throwable action) {
		this.actionException = action;
	}


	/**
	 * @param request the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}


	/**
	 * @param response the response to set
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public static User getUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SecureUser secUser = (SecureUser) authentication.getPrincipal();
		return secUser.getUser();
	}
	
	public static String getUserName() {
		return getUser().getUserName();
	}
	
	public String getBaseUrl(){
	    String serverName = request.getServerName();
	    int portNumber = request.getServerPort();
	    return "http://" + serverName+":"+portNumber;
	}
	
	protected void writeAjaxResponse(String ajaxResponse, String mediaType){
		PrintWriter writer = null;
		try {
			response.setContentType(mediaType);
			writer = this.response.getWriter();
			writer.write(ajaxResponse);
			writer.flush();
		} catch (Exception e) {
			writer.write("Service Failed");
			writer.flush();
		}
		finally{
			IOUtils.closeQuietly(writer);
		}
	}	
	
	protected void writeAjaxResponse(String ajaxResponse){
		writeAjaxResponse(ajaxResponse, "application/json");
	}
	
	// TODO - ServiceResult
	/*protected void writeAjaxResponse(ServiceResult<?> result) throws Exception{
		String serviceResultJson = jsonMapper.writer().writeValueAsString(result);
		writeAjaxResponse(serviceResultJson);
	}*/

	/*********************************************************************************************/	

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	public HttpSession getHttpSession(){
		return request.getSession();
	}
	
	
	// TODO - ServiceResult
	/*protected void processServiceResult(ServiceResult<?> serviceResult){
		if(serviceResult != null){
			for (String violation : serviceResult.getViolations()) {
				addActionError(violation);
			}
			for (String message : serviceResult.getMessages()) {
				addActionMessage(message);
			}			
		}
	}*/
	
	public boolean hasRole(String role){
		if(request.isUserInRole(role)){
			return true;
		}
		return false;
	}
	
	/*public boolean hasHighestRole(String role){
		return userService.isUserHighestRole(ExamJockeyUserPrincipal.getUserName(), role);
	}*/
	
	public String toCommaString(Collection<?> objectList){
		String returnString = "";
		if(objectList != null && objectList.size() > 0){
			returnString = StringUtils.join(objectList, ",");
		}
		return returnString;
	}
	
}
