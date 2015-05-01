package com.archies.service.role;

import java.util.List;

import com.archies.model.authority.Authority;
import com.archies.model.authority.UserAuthority;

public interface RoleService {
	public Authority getAuthorityByName(String authorityName);
	public List<UserAuthority> assignIndividualAuthoritiesToUser(String userName, String... authorityNames);
}
