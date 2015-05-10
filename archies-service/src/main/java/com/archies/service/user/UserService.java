package com.archies.service.user;

import java.util.List;

import com.archies.model.authority.UserAuthority;
import com.archies.model.user.User;

public interface UserService {
	public User getUserDetails(String userName);
	
	/**
	 * 
	 * @param user - {@link com.archies.model.user.User} to be registered.
	 * @return <b>true</b> - If this user persisted successfully.<br/><b>false</b> - If this user already exists.
	 */
	public boolean registerUser(User user);
	public List<UserAuthority> getIndividualUserAuthorities(String userName);
}
