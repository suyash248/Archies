package com.archies.service.user;

import java.util.List;

import com.archies.model.authority.UserAuthority;
import com.archies.model.user.User;

public interface UserService {
	public User getUserDetails(String userName);
	public String registerUser(User user);
	public List<UserAuthority> getIndividualUserAuthorities(String userName);
}
