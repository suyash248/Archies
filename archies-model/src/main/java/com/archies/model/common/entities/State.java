package com.archies.model.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "states")
public class State extends AuditableEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="STATE_ID", nullable = false)
    private Integer stateId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID")
    private Country countryId;
	
	@Column(name="STATE_CODE")
	private String stateCode;
	 
	@Column(name="STATE_NAME")
	private String stateName;
	 
}
