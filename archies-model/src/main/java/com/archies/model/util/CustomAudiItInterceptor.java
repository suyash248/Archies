package com.archies.model.util;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.archies.model.common.entities.AuditableEntity;

@SuppressWarnings("serial")
public class CustomAudiItInterceptor extends EmptyInterceptor implements Serializable{

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) throws CallbackException {
		boolean flag=false;
		if ( entity instanceof AuditableEntity ) {
            for ( int i=0; i<propertyNames.length; i++ ) {
                if ( "createdDate".equals( propertyNames[i] ) ) {
                    state[i] = new Date();
                    flag=true;
                } else if ( "creatorId".equals( propertyNames[i] ) ) {
                	String currentUserName;
                	if("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())){
                		currentUserName = "NOBODY";
                	} else{
                		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            		    currentUserName = (user==null || StringUtils.isEmpty(user.getUsername())) ? "NOBODY" : user.getUsername();
                	}
        		    state[i] = currentUserName;
        		    flag=true;
                }
            }
        }
        return flag;
	}
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
		boolean flag=false; 
		if ( entity instanceof AuditableEntity ) {
			 for ( int i=0; i < propertyNames.length; i++ ) {
				 if ( "lastUpdDate".equals( propertyNames[i] ) ) {
	                    currentState[i] = new Date();
	                    flag = true;
				 } else if ( "lastUpdId".equals( propertyNames[i] ) ) {
	                	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        		    String currentUserName = (user==null || StringUtils.isEmpty(user.getUsername())) ? "NOBODY" : user.getUsername();
	        		    currentState[i] = currentUserName;
	                    flag = true;
				 }
			 }
		}
		return flag;
	}
	
}
