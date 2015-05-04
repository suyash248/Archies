package com.archies.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomeAction extends ArchiesAction {
	public String execute(){
		return "home";
	}
	
	public String logout(){
		return "logout";
	}
	
	public String dummy(){
		
		return null;

	}
}
