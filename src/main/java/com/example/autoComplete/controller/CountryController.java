package com.example.autoComplete.controller;

import com.example.autoComplete.service.CountryService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rohitsharma
 */

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	private static final Logger log = LogManager.getLogger(CountryController.class);

	/**
	 * @param keyword to be searched
	 * @param limit the number of results to be shown
	 * @return list of country names wrapped in {@code ResponseEntity}
	 * @throws Exception if unable to return country names
	 */
	@GetMapping(value = "/countries", produces = "application/json")
	@ApiOperation("Fetch country names which contains the keyword entered based on limit. " +
			"If limit is not provided, all the values based on keyword matching will be returned.")
	public ResponseEntity<String> fetchCountries(@RequestParam ("keyword") String keyword, @RequestParam (value = "limit", required = false) Integer limit) throws Exception {

		try {
			log.debug("Request received for fetching country names by auto complete with keyword : " + keyword + " and limit : " + limit);

			String fetchCountriesResponse = countryService.fetchCountryNames(keyword, limit);

			log.debug("Response for fetching country names by auto complete with keyword : " + keyword + " and limit : " + limit + " is " + fetchCountriesResponse);

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity<>(fetchCountriesResponse, httpHeaders, HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Error occurred while fetching country names by auto-complete", ex);
			throw ex;
		}
	}

	/**
	 * @return list of all the countries wrapped in {@code ResponseEntity}
	 * @throws Exception if unable to return the list of countries
	 */
	@GetMapping(value = "/countries/all", produces = "application/json")
	@ApiOperation("Fetch all countries sorted by name.")
	public ResponseEntity<String> fetchAllCountries() throws Exception {

		try {
			log.debug("Request received for fetching all countries");

			String fetchAllCountriesResponse = countryService.fetchAllCountries();

			log.debug("Response for fetching all countries is " + fetchAllCountriesResponse);

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity<>(fetchAllCountriesResponse, httpHeaders, HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Error occurred while fetching all countries", ex);
			throw ex;
		}
	}
}
