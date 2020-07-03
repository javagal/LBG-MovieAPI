package com.wipro.lbg.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.lbg.model.MovieDbModel;
import com.wipro.lbg.service.MovieDbService;

@RestController
public class MovieDbController {

	@Autowired
	private MovieDbService service;
	
	@GetMapping("/allMovies")
	public List<MovieDbModel> nowShowingAll(){
		//List<MovieDbModel> allList=service.allMovies();
		List<MovieDbModel> mostPopularToLowPopularList=getPopularMovies();
		return mostPopularToLowPopularList;
	}
	
	@GetMapping("/byRateDescending")
	public List<MovieDbModel> getByRateDescending(){
		List<MovieDbModel> ratingList=service.getByRateDescending();
		return ratingList;
	}
	
	@GetMapping("/byRateAscending")
	public List<MovieDbModel> getByRateAscending(){
		List<MovieDbModel> ratingList=service.getByRateAscending();
		return ratingList;
	}
	
	@GetMapping("/filter/{rate}")
	public List<MovieDbModel> filterByRating(@PathVariable("rate") int rating){
		List<MovieDbModel> ratingList=service.getMoviesByRating(rating);
		return ratingList;
	}
	
	@GetMapping("/byGenre/{genre}")
	public List<MovieDbModel> getByGenre(@PathVariable("genre") String[] genres){
		List<MovieDbModel> genreList=service.getByGenre(genres);
		return genreList;
	}
	
	private List<MovieDbModel> getPopularMovies(){
		List<MovieDbModel> genreList=service.allMovies();
		List<MovieDbModel> popularToLow=new ArrayList<MovieDbModel>();
		List<MovieDbModel> veryGoodList=	new ArrayList<>();
		List<MovieDbModel> goodList=	new ArrayList<>();
		List<MovieDbModel> averageList=	new ArrayList<>();
		List<MovieDbModel> badList=	new ArrayList<>();
		for(MovieDbModel model:genreList) {
			if(model.getPopularity().equals("Very Good")) {
				veryGoodList.add(model);
			}else if(model.getPopularity().equals("Good")) {
				goodList.add(model);
			}else if(model.getPopularity().equals("Average")) {
				averageList.add(model);
			}else if(model.getPopularity().equals("Bad")){
					badList.add(model);
			}else {
				System.out.println("No Movies right now Playing");
			}
		}
		popularToLow.addAll(veryGoodList);
		popularToLow.addAll(goodList);
		popularToLow.addAll(averageList);
		popularToLow.addAll(badList);
		System.out.println(popularToLow);
		return popularToLow;
	}
}
