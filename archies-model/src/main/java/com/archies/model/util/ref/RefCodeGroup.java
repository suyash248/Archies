package com.archies.model.util.ref;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

import com.archies.model.common.entities.AuditableEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="REF_CODE_GROUPS")
@Getter @Setter
public class RefCodeGroup extends AuditableEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="LABEL")
	private String label;
	
	@Column(name="ACTIVE")
	private boolean active = true;
	
	@Column(name="UI_MANAGEABLE")
	private boolean uiManageable;
	
	@OneToMany(mappedBy="refCodeGroup")
	private Set<RefCode> refCodes;
	
	@PrePersist
	public void prePersist(){
		// we need to generate code, because it cannot be null
		if(StringUtils.isEmpty(code)){
			code = StringUtils.join(StringUtils.split(label), "_").toUpperCase();
		}
	}
}
