package com.archies.service.refCode;

import java.util.List;

import com.archies.model.util.ref.RefCode;
import com.archies.model.util.ref.RefCodeGroup;


public interface RefCodeService {

	public List<RefCode> getRefCodesByGroup(String groupName);
	
	public RefCode getRefCode(String groupName, String code);
	
	public List<RefCodeGroup> getAllRefCodeGroups();
	
	public List<RefCode> getAllRefCodesByGroup(Integer groupId);
	
	public List<RefCode> getRefCodesByGroup(Integer groupId);
	
	public RefCode getRefCode(Integer refCodeId);
	
	public RefCodeGroup getRefCodeGroup(Integer refCodeGroupId);
	
	public RefCode getRefCodeByCode(String code);
	
	public RefCodeGroup getRefCodeGroupByGroupCode(String groupCode);
	
	public RefCode addNewRefCode(String code, String value, String groupCode);
	
}
