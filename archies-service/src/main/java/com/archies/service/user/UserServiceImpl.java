package com.archies.service.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.archies.model.authority.UserAuthority;
import com.archies.model.user.User;
import com.archies.service.AbstractServiceImpl;

@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=300)
public class UserServiceImpl extends AbstractServiceImpl implements UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User getUserDetails(String userName){
		Session session = getSession();
		User user;
		String sql = "select usr from User usr "
				+ " where usr.userName=:userName ";
		Query query = session.createQuery(sql);
		query.setParameter("userName", userName);
		user = (User) query.uniqueResult();
		return user;
	}
	
	public boolean registerUser(User user){
		user.setUserName(user.getEmail());
		if(getUserDetails(user.getUserName())!=null){
			return false;
		}
		user.setActive(true);
		user.setUserPass(passwordEncoder.encode(user.getUserPass()));
		getSession().save(user);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserAuthority> getIndividualUserAuthorities(String userName){
		Session session = getSession();
		List<UserAuthority> userAuthorities = new ArrayList<UserAuthority>();
		String sql = "select distinct ua from UserAuthority ua "
				+ " left join fetch ua.user usr "
				+ " left join fetch ua.authority auth "
				+ " where usr.userName=:userName";
		Query query = session.createQuery(sql);
		query.setParameter("userName", userName);
		userAuthorities = query.list();
		return userAuthorities;
	}

}
