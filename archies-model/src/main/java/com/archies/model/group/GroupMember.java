package com.archies.model.group;

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
import com.archies.model.user.User;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="group_members")
@Getter @Setter
public class GroupMember extends AuditableEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_MEMBER_ID")
	private Integer groupMemberId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_NAME")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_ID")
	private Group group;
}
