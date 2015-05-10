package com.archies.model.common.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AuditableEntity implements Serializable {
	
	@Column(name = "CREATOR_ID")
	protected String creatorId;
	
	@Column(name = "LAST_UPD_ID")
	protected String lastUpdId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	protected Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPD_DATE")
	protected Date lastUpdDate;

	public Date getCreatedDate() {
		if (this.createdDate == null)
			this.createdDate = new Date();
		return this.createdDate;
	}

	public String getCreatorId() {
		if (creatorId == null){
			creatorId = "archadmin"; // ExamJockeyUserPrincipal.getUserName();
		}
		return creatorId;
	}

	public Date getLastUpdDate() {
		if (this.lastUpdDate == null)
			this.lastUpdDate = this.getCreatedDate();
		return this.lastUpdDate;
	}
	
	public String getLastUpdId() {
		if (this.lastUpdId == null)
			this.lastUpdId = this.getCreatorId();
		return lastUpdId;
	}

}
