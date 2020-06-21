package com.example.autoComplete.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author rohitsharma
 */

@Entity
@Component
public class Country {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;

	@Column (length = 2, name = "code")
	private String code;

	@Column (length = 100, name = "name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
