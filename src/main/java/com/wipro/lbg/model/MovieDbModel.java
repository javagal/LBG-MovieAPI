package com.wipro.lbg.model;

public class MovieDbModel {

	private int movieId;
	private String movieName;
	private String movieGenre;
	private int rating;
	private String popularity;
	
	
	public MovieDbModel(int movieId, String movieName, String movieGenre, int rating, String popularity) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.rating = rating;
		this.popularity = popularity;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	@Override
	public String toString() {
		return "MovieDbModel [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", rating=" + rating + ", popularity=" + popularity + "]";
	}
	
	
}
