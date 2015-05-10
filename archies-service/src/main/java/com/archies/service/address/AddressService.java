package com.archies.service.address;

import java.util.List;

import com.archies.model.common.entities.Country;
import com.archies.model.common.entities.State;

public interface AddressService {
	public List<State> getAllStatesByCountry(Integer countryId);
	public List<Country> getAllCountries();
	public Country getCountryByCode(String countryCode);
	public State getStateByCode(String stateCode);
}
