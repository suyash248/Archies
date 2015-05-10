package com.archies.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_PROFILE_ID" , nullable=true)
	private UserProfile userProfile;
	
	@Column(name="USER_PASS")
	private String userPass;
	
	@Column(name="ACTIVE")
	private Boolean active;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
}
