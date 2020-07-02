package com.wipro.lbg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wipro.lbg.model.MovieDbModel;
@Repository
public class CommonUtil {

	public List<MovieDbModel> getAvaliableMovies(){
	
		MovieDbModel model1=new MovieDbModel(1, "Ratsasan", "Crime Thriller", 4, "Very Good");
		MovieDbModel model2=new MovieDbModel(2, "Goodachari", "Crime Thriller", 4, "Good");
		MovieDbModel model3=new MovieDbModel(3, "MagaDheera", "SocioFantacy", 5, "Very Good");
		MovieDbModel model4=new MovieDbModel(4, "KGF", "Action", 3, "Good");
		MovieDbModel model5=new MovieDbModel(5, "Tupaki", "Action", 4, "Very Good");
		MovieDbModel model6=new MovieDbModel(6, "Dabbang 3", "Action", 2, "Bad");
		MovieDbModel model7=new MovieDbModel(7, "Dear Zindagi", "Drama", 2, "Average");
		MovieDbModel model8=new MovieDbModel(8, "Dilwale Dulhania Le Jayenge", "Love", 4, "Very Good");
		MovieDbModel model9=new MovieDbModel(9, "Thumbad", "Horror", 3, "Very Good");
		MovieDbModel model10=new MovieDbModel(10, "Anna Belle", "Horror", 2, "Average");
		MovieDbModel model11=new MovieDbModel(11, "Rabta", "Love", 1, "Bad");
		MovieDbModel model12=new MovieDbModel(12, "MS Dhoni", "Drama", 4, "Very Good");
		MovieDbModel model13=new MovieDbModel(13, "Puli", "SocioFantacy", 1, "Bad");
		MovieDbModel model14=new MovieDbModel(14, "The God Father", "Action", 4, "Very Good");
		List<MovieDbModel> movieList=new ArrayList<MovieDbModel>();
		movieList.add(model14);
		movieList.add(model1);
		movieList.add(model2);
		movieList.add(model3);
		movieList.add(model4);
		movieList.add(model5);
		movieList.add(model6);
		movieList.add(model7);
		movieList.add(model8);
		movieList.add(model9);
		movieList.add(model10);
		movieList.add(model11);
		movieList.add(model12);
		movieList.add(model13);
		return movieList;
	}
}
