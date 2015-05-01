package com.archies.model.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="authorities")
@Getter @Setter
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AUTH_ID")
	private Integer authId;
	
	@Column(name="AUTHORITY_NAME")
	private String authName;
}
