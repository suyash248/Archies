package com.archies.web.action.register;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.archies.model.authority.Authority.AuthorityName;
import com.archies.model.common.entities.Country;
import com.archies.model.common.entities.State;
import com.archies.model.user.User;
import com.archies.model.util.ref.RefCode;
import com.archies.service.address.AddressService;
import com.archies.service.refCode.RefCodeService;
import com.archies.service.role.RoleService;
import com.archies.service.user.UserService;
import com.archies.web.action.ArchiesAction;
import com.fasterxml.jackson.core.JsonProcessingException;

@SuppressWarnings("serial")
@Component("registerAction")
@Getter @Setter
public class RegisterAction extends ArchiesAction {
	
	private User newUser;
	
	private int countryId;
	
	private List<RefCode> allProfileFor = new ArrayList<RefCode>();
	private List<RefCode> allMotherTongues = new ArrayList<RefCode>();
	private List<RefCode> allReligions = new ArrayList<RefCode>();
	private List<Country> allCountries = new ArrayList<Country>();
	private List<State> allStates = new ArrayList<State>();

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private RefCodeService refCodeService;
	
	@Autowired
	private RoleService roleService;
	
	public String register(){
		boolean status = userService.registerUser(newUser);
		roleService.assignIndividualAuthoritiesToUser(newUser.getUserName(), AuthorityName.ROLE_USER.getLabel());
			
		this.resetAllActionMessages();
		if(status){
			this.addActionMessage("User "+ newUser.getFirstName() +" registered successfully.");
		} else{
			this.addActionMessage("User " + newUser.getFirstName() + " already exists");
		}
		
		//loadLists();
		return LOGIN;	// TODO - Return to the another page wherein remaining fields for registration will be shown.
	}
	
	public String registrationDetails(){
		loadLists();
		// TODO - Save addition details related to registration.
		return LOGIN;
	}
	
	public void populateStatesByCountry() throws JsonProcessingException{ 
		allStates = addressService.getAllStatesByCountry(countryId);
		String stateJson = jsonMapper.writer().writeValueAsString(allStates);
		writeAjaxResponse(stateJson);
	}
	
	private void loadLists(){
		allProfileFor = refCodeService.getRefCodesByGroup(RefCode.RefCodeGrp.PROFILE_FOR.getLabel());
		allMotherTongues = refCodeService.getRefCodesByGroup(RefCode.RefCodeGrp.PROFILE_MOTHER_TONGUE.getLabel());
		allReligions = refCodeService.getRefCodesByGroup(RefCode.RefCodeGrp.PROFILE_RELIGION.getLabel());
		allCountries = addressService.getAllCountries();
	}
}
