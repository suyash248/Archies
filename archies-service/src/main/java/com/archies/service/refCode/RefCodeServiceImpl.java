package com.archies.service.refCode;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.archies.model.util.ref.RefCode;
import com.archies.model.util.ref.RefCodeGroup;
import com.archies.service.AbstractServiceImpl;

@Repository
@Transactional(timeout=1500)
public class RefCodeServiceImpl extends AbstractServiceImpl implements RefCodeService {
	
	public List<RefCode> getRefCodesByGroup(String groupCode){
		return getRefCodesByGroup(null, groupCode, true);
	}
	
	public List<RefCode> getRefCodesByGroup(Integer groupId){
		return getRefCodesByGroup(groupId, null, true);
	}
	
	public List<RefCode> getAllRefCodesByGroup(Integer groupId){
		return getRefCodesByGroup(groupId, null, null);
	}
	
	@SuppressWarnings("unchecked")
	private List<RefCode> getRefCodesByGroup(Integer refCodeGroupId, String groupCode, Boolean activeIndicator){
		Session session = getSession();
		String sql = "from RefCode ref where "
				+ " (:groupCode is null or ref.group.code = :groupCode ) "
				+ " and (:groupId is null or ref.group.id = :groupId ) "
				+ " and (:active is null or ref.active = :active)"
				+ " order by ref.value asc ";
		Query query = session.createQuery(sql);
		query.setParameter("groupCode", groupCode);
		query.setParameter("groupId", refCodeGroupId);
		query.setParameter("active", activeIndicator);
		List<RefCode> refCodes = query.list();
		return refCodes;
	}
	
	public RefCode getRefCode(Integer refCodeId){
		Query query = getSession().createQuery("from RefCode ref join fetch ref.group where ref.id = :refCodeId")
				.setParameter("refCodeId", refCodeId);
				return (RefCode) query.uniqueResult();
	}
	
	public RefCode getRefCode(String groupCode, String code){
		String sql = "from RefCode ref "
				+ " join fetch ref.group "
				+ " where ref.group.code = :groupCode "
				+ " and ref.code = :code "
				+ " and ref.active = :active";
		Query query = getSession().createQuery(sql)
		.setParameter("groupCode", groupCode)
		.setParameter("code", code)
		.setParameter("active", true);
		RefCode refCode = getFirstResult(query, RefCode.class);
		return refCode;
	}
	
	public RefCode getRefCodeByCode(String code){
		Query query = getSession().createQuery("from RefCode rf where rf.code = :code");
		query.setParameter("code", code);
		return getFirstResult(query, RefCode.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<RefCodeGroup> getAllRefCodeGroups(){
		Query query =getSession().createQuery("select distinct rf from RefCodeGroup rf left join fetch rf.refCodes "
										+ " where rf.uiManageable = :uiManageable order by rf.label asc");
		query.setParameter("uiManageable", true);
		List<RefCodeGroup> codeGroups =  query.list();
		for (RefCodeGroup refCodeGroup : codeGroups) {
			populateGroupItemCounts(refCodeGroup);
		}
		return codeGroups;
	}
	
	public RefCodeGroup getRefCodeGroup(Integer refCodeGroupId){
		Query query =getSession().createQuery("select distinct rf from RefCodeGroup rf left join fetch rf.refCodes where rf.id = :refCodeGroupId order by rf.label asc");
		query.setParameter("refCodeGroupId", refCodeGroupId);
		RefCodeGroup refCodeGroup = getFirstResult(query, RefCodeGroup.class);
		populateGroupItemCounts(refCodeGroup);
		return refCodeGroup;
	}
	
	private void populateGroupItemCounts(RefCodeGroup refCodeGroup){
		refCodeGroup.setTotalItemCount(refCodeGroup.getRefCodes().size());
		int activeCount = 0;
		for (RefCode refCode : refCodeGroup.getRefCodes()) {
			if(refCode.getActive()){
				activeCount++;
			}
		}
		refCodeGroup.setActiveItemCount(activeCount);
	}
	
	public RefCodeGroup getRefCodeGroupByGroupCode(String groupCode) {
		String sql = "select distinct rcg from RefCodeGroup rcg "
				+ " where rcg.code = :groupCode";
		Query query =getSession().createQuery(sql);
		query.setParameter("groupCode", groupCode);
		RefCodeGroup refCodeGroup = getFirstResult(query, RefCodeGroup.class);
		populateGroupItemCounts(refCodeGroup);
		return refCodeGroup;
	}
	
	public RefCode addNewRefCode(String code, String value, String groupCode) {
		RefCode refCode = getRefCode(groupCode, code);
		if(refCode!=null){
			refCode.setCode(code);
			refCode.setValue(value);
			getSession().merge(refCode);
		} else{
			refCode = new RefCode();
			refCode.setActive(true);
			refCode.setCode(code);
			refCode.setValue(value);
			refCode.setRefCodeGroup(getRefCodeGroupByGroupCode(groupCode));
			getSession().persist(refCode);
		}
		return refCode;
	}
	
}
