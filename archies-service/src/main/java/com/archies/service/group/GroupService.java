package com.archies.service.group;

import java.util.List;

import com.archies.model.authority.GroupAuthority;
import com.archies.model.group.GroupMember;

public interface GroupService {
	public List<GroupAuthority> getGroupAuthorities(int groupId);
	public List<GroupMember> getUserGroups(String userName);
}
