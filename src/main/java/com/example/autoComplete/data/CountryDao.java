package com.example.autoComplete.data;

import com.example.autoComplete.model.Country;
import com.example.autoComplete.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rohitsharma
 */

@Component
public class CountryDao {

	@Autowired
	CountryRepository countryRepository;

	/**
	 * @param keyWord get country names that contains {@code keyword}
	 * @return list of country names
	 */
	public List<String> getCountryNamesByKeyword(String keyWord) {

		return countryRepository.findCountryNamesByKeyword(keyWord);
	}

	/**
	 * @return sorted list of all countries
	 */
	public List<Country> getAllCountries() {

		return countryRepository.findAll(Sort.by("name"));
	}
}
