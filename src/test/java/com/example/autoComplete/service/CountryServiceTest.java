package com.example.autoComplete.service;

import com.example.autoComplete.data.CountryDao;
import com.example.autoComplete.model.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rohitsharma
 */

@RunWith(SpringRunner.class)
public class CountryServiceTest {

	@MockBean
	CountryDao countryDao;

	@Test
	public void fetchCountryNamesTest() throws Exception {

		String keyword = "ab";
		Mockito.when(countryDao.getCountryNamesByKeyword(keyword)).thenReturn(fetchCountryNameDaoResponse());
		String countryNames = new ObjectMapper().writeValueAsString(countryDao.getCountryNamesByKeyword(keyword));
		Assert.assertEquals("[\"Gabon\",\"Libyan Arab Jamahiriya\",\"Saudi Arabia\",\"Syrian Arab Republic\",\"United Arab Emirates\"]", countryNames);
	}

	private List<String> fetchCountryNameDaoResponse() {

		List<String> countryList =  new ArrayList<>();
		countryList.add("Gabon");
		countryList.add("Libyan Arab Jamahiriya");
		countryList.add("Saudi Arabia");
		countryList.add("Syrian Arab Republic");
		countryList.add("United Arab Emirates");
		return countryList;
	}

	@Test
	public void fetchAllCountries() {

		Mockito.when(countryDao.getAllCountries()).thenReturn(fetchCountriesDaoResponse());
		String countryNames = countryDao.getAllCountries().toString();
		Assert.assertEquals("[Country{id=32, code='AF', name='Afghanistan'}, Country{id=33, code='AL', name='Albania'}, Country{id=34, code='DZ', name='Algeria'}]", countryNames);
	}

	private List<Country> fetchCountriesDaoResponse() {

		Country country1 = new Country();
		country1.setId(32);
		country1.setCode("AF");
		country1.setName("Afghanistan");

		Country country2 = new Country();
		country2.setId(33);
		country2.setCode("AL");
		country2.setName("Albania");

		Country country3 = new Country();
		country3.setId(34);
		country3.setCode("DZ");
		country3.setName("Algeria");

		List<Country> countries = new ArrayList<>();
		Collections.addAll(countries, country1, country2, country3);
		return countries;
	}
}
