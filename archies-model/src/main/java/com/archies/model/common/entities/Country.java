package com.archies.model.common.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "countries")
@Getter @Setter
public class Country extends AuditableEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="COUNTRY_ID", nullable = false)
    private Integer countryId;
	
	 @Column(name="COUNTRY_CODE")
	 private String countryCode;
	 
	 @Column(name="COUNTRY_NAME")
	 private String countryName;

}