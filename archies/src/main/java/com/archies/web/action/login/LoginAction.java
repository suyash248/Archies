package com.archies.web.action.login;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.archies.model.common.entities.Country;
import com.archies.model.common.entities.State;
import com.archies.model.util.ref.RefCode;
import com.archies.service.address.AddressService;
import com.archies.service.refCode.RefCodeService;
import com.archies.web.action.ArchiesAction;
import com.fasterxml.jackson.core.JsonProcessingException;

@SuppressWarnings("serial")
@Component
@Getter @Setter
public class LoginAction extends ArchiesAction {
	
	public String execute(){
		return LOGIN;
	}
	
	public String submit(){
		
		return "home";
	}

}