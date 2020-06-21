package com.example.autoComplete.service;

import com.example.autoComplete.data.CountryDao;
import com.example.autoComplete.model.Country;
import com.example.autoComplete.model.CountryHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rohitsharma
 */

@Service
public class CountryService {

	@Autowired
	CountryDao countryDao;

	@Autowired
	CountryHolder countryHolder;

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	/**
	 * @param keyword to be searched
	 * @param limit the number of results to be shown
	 * @return sorted list of country names that matches with {@code}keyword and satisfies {@code}limit
	 * @throws Exception if unable to fetch country names
	 */
	public String fetchCountryNames(String keyword, Integer limit) throws Exception {

		List<String> countryNames = countryDao.getCountryNamesByKeyword(keyword.toLowerCase());

		Collections.sort(countryNames);

		if (limit == null || limit == 0) {
			return OBJECT_MAPPER.writeValueAsString(countryNames);
		} else {
			List<String> countryNamesWithLimit = countryNames.stream().limit(limit).collect(Collectors.toList());
			return OBJECT_MAPPER.writeValueAsString(countryNamesWithLimit);
		}
	}

	/**
	 * @return sorted list of all countries
	 * @throws Exception if unable to fetch country list
	 */
	public String fetchAllCountries() throws Exception {

		List<Country> countries = countryDao.getAllCountries();
		countryHolder.setCountries(countries);
		return OBJECT_MAPPER.writeValueAsString(countryHolder);
	}
}
