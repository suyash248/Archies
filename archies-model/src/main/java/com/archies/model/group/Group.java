package com.archies.model.group;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.archies.model.common.entities.AuditableEntity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="groups")
@Getter @Setter
public class Group extends AuditableEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_ID")
	private Integer groupId;
	
	@Column(name="GROUP_NAME")
	private String groupName;
	
}
