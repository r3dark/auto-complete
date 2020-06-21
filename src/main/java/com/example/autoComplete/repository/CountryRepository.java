package com.example.autoComplete.repository;

import com.example.autoComplete.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rohitsharma
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	@Query (value = "SELECT name FROM COUNTRY WHERE LOWER(name) LIKE %:keyword%",
			nativeQuery = true)
	List<String> findCountryNamesByKeyword(@Param ("keyword") String keyword);
}
