package com.example.autoComplete.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rohitsharma
 */

@Component
public class CountryHolder {

	private List<Country> countries;

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "CountryHolder{" +
				"countries=" + countries +
				'}';
	}
}
