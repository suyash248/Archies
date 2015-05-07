package com.archies.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import com.archies.model.address.entities.Address;
import com.archies.model.common.entities.AuditableEntity;
import com.archies.model.util.ref.RefCode;

@SuppressWarnings("serial")
@Entity
@Table(name="user_profile")
@Getter @Setter
public class UserProfile extends AuditableEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_PROFILE_ID")
	private Integer userProfileId;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDR_ID", referencedColumnName = "ADDR_ID")
	private Address address;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RELIGION")
	private RefCode religion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MOTHER_TONGUE")
	private RefCode motherTongue;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MARITAL_STATUS")
	private RefCode maritalStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EDUCATIONAL_LEVEL")
	private RefCode educationalLevel;
	
	@Column(name="EDUCATIONAL_FIELD")
	private String educationalfield;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKING_WITH")
	private RefCode workingWith;
	
	@Column(name="WORKING_AS")
	private String workingAs;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ANNUAL_INCOME")
	private RefCode annualIncome;
	
	@Column(name="SELF_DESCRIPTION")
	private String selfDescription;
	
	@Column(name="DISABILITY")
	private Boolean disability = false;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HEIGHT")
	private RefCode height;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DIET")
	private RefCode diet;
	
	@Column(name="DRINK")
	private Boolean drink = false;
	
	@Column(name="SMOKE")
	private Boolean smoke = false;
	
	@Column(name="HIV_POSITIVE")
	private Boolean hivPositive = false;
	 
}
