package com.redfox.model.BEAN;

import javax.servlet.http.Part;

public class Movie {
	private String title, description, genre, director, cast_one, cast_two, cast_three, year_of_release;
	private double rate;
	private String trailer_link;
	private Part thumbnail;
	private int movie_id;

	public Movie() {
		super();
	}
	
	public Movie(String title, String description, String genre, String director, String cast_one,
			String cast_two, String cast_three, String trailer_link, String year_of_release, Part thumbnail) {
		super();
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.director = director;
		this.cast_one = cast_one;
		this.cast_two = cast_two;
		this.cast_three = cast_three;
		this.trailer_link = trailer_link;
		this.thumbnail = thumbnail;
		this.year_of_release = year_of_release;
	}
	
	public Movie(String title, String description, String genre, String director, String cast_one,
			String cast_two, String cast_three, String trailer_link, String year_of_release) {
		super();
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.director = director;
		this.cast_one = cast_one;
		this.cast_two = cast_two;
		this.cast_three = cast_three;
		this.trailer_link = trailer_link;
		this.year_of_release = year_of_release;
	}
	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast_one() {
		return cast_one;
	}
	public void setCast_one(String cast_one) {
		this.cast_one = cast_one;
	}
	public String getCast_two() {
		return cast_two;
	}
	public void setCast_two(String cast_two) {
		this.cast_two = cast_two;
	}
	public String getCast_three() {
		return cast_three;
	}
	public void setCast_three(String cast_three) {
		this.cast_three = cast_three;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Part getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Part thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTrailer_link() {
		return trailer_link;
	}
	public void setTrailer_link(String trailer_link) {
		this.trailer_link = trailer_link;
	}
	public String getYear_of_release() {
		return year_of_release;
	}
	public void setYear_of_release(String year_of_release) {
		this.year_of_release = year_of_release;
	}
	
	public String toString() {
		return "Movie [title=" + title + ", description=" + description + ", genre=" + genre + ", director=" + director
				+ ", cast_one=" + cast_one + ", cast_two=" + cast_two + ", cast_three=" + cast_three
				+ ", year_of_release=" + year_of_release + ", rate=" + rate + ", trailer_link=" + trailer_link + "]";
	}

}
