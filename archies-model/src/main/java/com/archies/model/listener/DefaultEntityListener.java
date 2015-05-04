package com.archies.model.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.archies.model.common.entities.AuditableEntity;

/**
 * Default listener to be applied to all entities.
 * 
 * Update the audit related information of an entity whenever it gets
 * created for the first time or updated
 * 
 */
public class DefaultEntityListener {
	/**
	 * Called before the entity is created
	 * @param entity
	 */
	
	@PrePersist
	public void prePersist(Object entity) {
		AuditableEntity auditableEntity = this.getAuditableEntity(entity);
		if(auditableEntity!= null) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String currentUserName = user.getUsername();
			auditableEntity.setCreatedDate(new Date());
			auditableEntity.setCreatorId(currentUserName);	// ArchiesUserPrincipal.getUserName()
		}
	}
	
	/**
	 * Called before the entity is updated
	 * @param entity
	 */
	@PreUpdate
	public void preUpdate(Object entity) {
		AuditableEntity meta = this.getAuditableEntity(entity);
		if(meta!= null) {
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String currentUserName = user.getUsername();
			meta.setLastUpdDate(new Date());
			meta.setLastUpdId(currentUserName); // ArchiesUserPrincipal.getUserName()
		}
	}
	
	/**
	 * @param entity
	 * @return An instance of {@link AuditableEntity}
	 */
	private AuditableEntity getAuditableEntity(Object entity) {
		if(entity instanceof AuditableEntity)
			return (AuditableEntity)entity;
		return null;
	}
}
