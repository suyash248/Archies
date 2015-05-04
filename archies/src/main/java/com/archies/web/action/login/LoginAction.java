package com.archies.web.action.login;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import com.archies.web.action.ArchiesAction;

@SuppressWarnings("serial")
@Component
public class LoginAction extends ArchiesAction {
	public String execute(){
		return "login";
	}
	
	
}