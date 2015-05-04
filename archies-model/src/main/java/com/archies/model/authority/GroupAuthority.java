package com.archies.model.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.archies.model.common.entities.AuditableEntity;
import com.archies.model.group.Group;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="group_authorities")
@Getter @Setter
public class GroupAuthority extends AuditableEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer groupAuthorityId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_ID")
	private Group group;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AUTH_ID")
	private Authority authority;
	
}
