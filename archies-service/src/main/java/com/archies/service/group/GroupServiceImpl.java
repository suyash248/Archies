package com.archies.service.group;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.archies.model.authority.GroupAuthority;
import com.archies.model.group.GroupMember;
import com.archies.service.AbstractServiceImpl;

@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class GroupServiceImpl extends AbstractServiceImpl implements GroupService {
	
	@SuppressWarnings("unchecked")
	public List<GroupAuthority> getGroupAuthorities(int groupId) {
		Session session = getSession();
		List<GroupAuthority> groupAuthorities = new ArrayList<GroupAuthority>();
		String sql = "select distinct ga from GroupAuthority ga "
				+ " left join fetch ga.group grp "
				+ " left join fetch ga.authority auth "
				+ " where grp.groupId=:groupId ";
		Query query = session.createQuery(sql);
		query.setParameter("groupId", groupId);
		groupAuthorities = query.list();
		return groupAuthorities;
	}
	
	@SuppressWarnings("unchecked")
	public List<GroupMember> getUserGroups(String userName) {
		Session session = getSession();
		List<GroupMember> userGroups = new ArrayList<GroupMember>();
		String sql = "select gm from GroupMember gm "
				+ " left join fetch gm.group grp "
				+ " left join fetch gm.user usr "
				+ " where usr.userName=:userName";
		Query query = session.createQuery(sql);
		query.setParameter("userName", userName);
		userGroups = query.list();
		return userGroups;
	}
	
}
