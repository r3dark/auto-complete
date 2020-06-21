package com.example.autoComplete.controller;

import com.example.autoComplete.model.Country;
import com.example.autoComplete.model.CountryHolder;
import com.example.autoComplete.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
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

@RunWith (SpringRunner.class)
public class CountryControllerTest {

	@MockBean
	CountryService countryService;

	@Test
	public void fetchCountryNamesTest() throws Exception {

		String keyword = "ab";
		Integer limit = 5;
		Mockito.when(countryService.fetchCountryNames(keyword, limit)).thenReturn(fetchCountryNameServiceResponse());
		String response = countryService.fetchCountryNames(keyword, limit);
		Assert.assertEquals("[\"Gabon\",\"Libyan Arab Jamahiriya\",\"Saudi Arabia\",\"Syrian Arab Republic\",\"United Arab Emirates\"]", response);
	}

	private String fetchCountryNameServiceResponse() throws JsonProcessingException {

		List<String> countryList =  new ArrayList<>();
		countryList.add("Gabon");
		countryList.add("Libyan Arab Jamahiriya");
		countryList.add("Saudi Arabia");
		countryList.add("Syrian Arab Republic");
		countryList.add("United Arab Emirates");
		return new ObjectMapper().writeValueAsString(countryList);
	}

	@Test
	public void fetchAllCountries() throws Exception {

		Mockito.when(countryService.fetchAllCountries()).thenReturn(fetchCountriesServiceResponse());
		String countryNames = countryService.fetchAllCountries();
		Assert.assertEquals("{\"countries\":[{\"id\":32,\"code\":\"AF\",\"name\":\"Afghanistan\"},{\"id\":33,\"code\":\"AL\",\"name\":\"Albania\"},{\"id\":34,\"code\":\"DZ\",\"name\":\"Algeria\"}]}", countryNames);
	}

	private String fetchCountriesServiceResponse() throws JsonProcessingException {

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

		CountryHolder holder = new CountryHolder();
		holder.setCountries(countries);
		return new ObjectMapper().writeValueAsString(holder);
	}
}
