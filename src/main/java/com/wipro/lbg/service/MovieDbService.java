package com.wipro.lbg.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.wipro.lbg.model.MovieDbModel;
import com.wipro.lbg.util.CommonUtil;

@Service
public class MovieDbService {

	@Autowired
	private CommonUtil commonUtil;

	public List<MovieDbModel> allMovies() {
		List<MovieDbModel> allList = commonUtil.getAvaliableMovies();
		return allList;
	}

	public List<MovieDbModel> getByRateAscending() {
		List<MovieDbModel> AscRateList = commonUtil.getAvaliableMovies();

		Collections.sort(AscRateList, new Comparator<MovieDbModel>() {
			@Override
			public int compare(MovieDbModel mdb1, MovieDbModel mdb2) {
				return (int) (mdb1.getRating() - mdb2.getRating());
			}
		});
		return AscRateList;
	}

	public List<MovieDbModel> getByRateDescending() {
		List<MovieDbModel> DesRateList = commonUtil.getAvaliableMovies();

		Collections.sort(DesRateList, new Comparator<MovieDbModel>() {
			@Override
			public int compare(MovieDbModel mdb1, MovieDbModel mdb2) {
				return (int) (mdb2.getRating() - mdb1.getRating());
			}
		});
		return DesRateList;
	}

	public List<MovieDbModel> getByGenre(String[] genre) {
//		System.out.println("Inside service and genre --> " + genre);
		List<MovieDbModel> genreList = getByGenresName(genre);
//		System.out.println(genreList);
		return genreList;
	}

	public List<MovieDbModel> getMoviesByRating(int rating){
		List<MovieDbModel> ratingList=getByRating(rating);
		
		return ratingList;
	} 
	private List<MovieDbModel> getByGenresName(String[] genre) {
		
		List<MovieDbModel> list = commonUtil.getAvaliableMovies();
		List<MovieDbModel> genreList = new ArrayList<>();

//		List<Article> articleList = new ArrayList<Article>();
//		List<Article> filteredArticleList= articleList.stream().filter(article -> article.getDesArt().contains("test")).collect(Collectors.toList());
//	actionList=	list.stream().filter(model -> model.getMovieGenre().contains("action")).collect(Collectors.toList());
//	System.out.println("Java 8 --action List --->"+actionList.toString());
	
		for(MovieDbModel model:list) {
			for(String gnr:genre) {
				if(model.getMovieGenre().equals(gnr)) {
					genreList.add(model);
				}
			}
			
		}
	
	
		/*
		 * for (MovieDbModel movieDbModel : list) { System.out.println("condition " +
		 * movieDbModel.toString()); if
		 * (genre.equalsIgnoreCase(movieDbModel.getMovieGenre())) {
		 * actionList.add(movieDbModel); list.retainAll(actionList);
		 * //list.addAll(actionList); } else if
		 * (movieDbModel.getMovieGenre().equalsIgnoreCase(genre)) {
		 * dramaList.add(movieDbModel); list.addAll(dramaList); } else if
		 * (movieDbModel.getMovieGenre().equalsIgnoreCase(genre)) {
		 * horrorList.add(movieDbModel); list.addAll(horrorList); } else if
		 * (movieDbModel.getMovieGenre().equalsIgnoreCase("Crime Thriller")) {
		 * crimeList.add(movieDbModel); list.addAll(crimeList); } else if
		 * (movieDbModel.getMovieGenre().equalsIgnoreCase("SocioFantasy")) {
		 * fantasyList.add(movieDbModel); list.addAll(fantasyList); } else if
		 * (movieDbModel.getMovieGenre().equalsIgnoreCase("love")) {
		 * loveList.add(movieDbModel); list.addAll(loveList); } else {
		 * System.out.println("Please select Genre"); } }
		 */

	System.out.println(genreList);
		return genreList;
	}
	private List<MovieDbModel> getByRating(int rate){
		List<MovieDbModel> list=commonUtil.getAvaliableMovies();
		List<MovieDbModel> rateList=new ArrayList<>();
		rateList=list.stream().filter(model -> model.getRating() >=rate).collect(Collectors.toList());
		System.out.println(rateList.toString());
		return rateList;
		
	}
}
