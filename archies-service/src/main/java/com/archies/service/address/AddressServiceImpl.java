package com.archies.service.address;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.archies.model.common.entities.Country;
import com.archies.model.common.entities.State;
import com.archies.service.AbstractServiceImpl;

@SuppressWarnings("unchecked")
@Repository
@Transactional(propagation=Propagation.REQUIRED, timeout=1500)
public class AddressServiceImpl  extends AbstractServiceImpl implements AddressService{
	
	public List<State> getAllStatesByCountry(Integer countryId) {
		String sql = "select st from State st "
				+ " left join fetch st.Country ct "
				+ " where ct.countryId=:countryId ";
		Query query = getSession().createQuery(sql);
		query.setParameter("countryId", countryId);
		List<State> allStates = query.list();
		return allStates;
	}

	public List<Country> getAllCountries() {
		List<Country> allCountries = new ArrayList<Country>();
		String sql = "from Country";
		Query query = getSession().createQuery(sql);
		allCountries = query.list();
		return allCountries;
	}
	
	public Country getCountryByCode(String countryCode) {
		Country country = new Country();
		String sql = "select ct from Country ct where ct.countryCode = :countryCode";
		Query query = getSession().createQuery(sql);
		query.setParameter("countryCode", countryCode);
		country = getFirstResult(query, Country.class);
		return country;
	}
	
	public State getStateByCode(String stateCode) {
		State state = new State();
		String sql = "select st from State st where st.stateCode =:stateCode";
		Query query = getSession().createQuery(sql);
		query.setParameter("stateCode", stateCode);
		state = getFirstResult(query, State.class);
		return state;
	}
}