/**
 * 
 */
package com.archies.model.address.entities;

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
import com.archies.model.common.entities.Country;
import com.archies.model.common.entities.State;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "addresses")
@Getter @Setter
public class Address extends AuditableEntity {
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ADDR_ID", nullable = false)
    private Integer addrId;
    
    @Column(name="CITY")
    private String city;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATE_ID")
    private State stateId;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COUNTRY_ID")
    private Country countryId;
    
    @Column(name="ZIP")
    private String zipcode;


}
