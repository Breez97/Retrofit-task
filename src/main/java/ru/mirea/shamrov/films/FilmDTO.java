package ru.mirea.shamrov.films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDTO {

	@JsonProperty("title")
	private String title;

	@JsonProperty("year")
	private int year;

	@JsonProperty("cast")
	private List<String> cast;

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public List<String> getCast() {
		return cast;
	}

}
