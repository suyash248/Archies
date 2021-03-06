package com.archies.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.archies.model.common.entities.AuditableEntity;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
@Getter @Setter
public class User extends AuditableEntity implements Serializable {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;

	@Id
	@Column(name="USER_NAME")
	private String userName;
	
	@OneToOne(mappedBy="user")
	private UserProfile userProfile;
	
	@Column(name="USER_PASS")
	private String userPass;
	
	@Column(name="ACTIVE")
	private Boolean active;
}
