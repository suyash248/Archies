package com.archies.model.util.ref;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import com.archies.model.common.entities.AuditableEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="REF_CODES")
@Getter @Setter
public class RefCode extends AuditableEntity {
	
	public static class RefGroup{
		public static final String MARATIAL_STATUS = "MARATIAL_STATUS";
		public static final String COMMUNITY = "COMMUNITY";
		public static final String RELEGION = "RELEGION";
		public static final String MOTHER_TOUNGUE = "MOTHER_TOUNGUE";
		public static final String WORKING_WITH_COMPANY = "WORKING_WITH_COMPANY";
		public static final String HEIGHT = "HEIGHT";
	}
	
	public RefCode(){
		
	}
	
	public RefCode(String code, String value){
		this.code = code;
		this.value = value;
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="CODE")
	private String code;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REF_CODE_GROUP_ID")
	private RefCodeGroup refCodeGroup;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="ACTIVE")
	private Boolean active = true;
	
	
	@PrePersist
	public void prePersist(){
		// we need to generate code, because it cannot be null
		if(StringUtils.isEmpty(code)){
			code = StringUtils.join(StringUtils.split(value), "_").toUpperCase()+"_"+refCodeGroup.getId();
		}
	}

}
