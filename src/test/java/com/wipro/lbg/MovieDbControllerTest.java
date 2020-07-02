package com.wipro.lbg;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wipro.lbg.controller.MovieDbController;
import com.wipro.lbg.model.MovieDbModel;
import com.wipro.lbg.service.MovieDbService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieDbController.class)
public class MovieDbControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MovieDbController moviedbcontroller;
	@MockBean
	private MovieDbService mockService;
	
	List<MovieDbModel> mockList = new ArrayList<MovieDbModel>();
	List<MovieDbModel> filterList = new ArrayList<MovieDbModel>();
	List<MovieDbModel> genreList = new ArrayList<MovieDbModel>();
	

	@Before
	public void init() {
		MovieDbModel mockModel1 = new MovieDbModel(1, "Ratsasan", "Crime Thriller", 4, "Very Good");
		MovieDbModel mockModel2 = new MovieDbModel(2, "Goodachari", "Crime Thriller", 4, "Good");
		MovieDbModel mockModel3 = new MovieDbModel(3, "MagaDheera", "SocioFantacy", 5, "Very Good");
		MovieDbModel mockModel4 = new MovieDbModel(4, "KGF", "Action", 3, "Good");
		MovieDbModel mockModel5 = new MovieDbModel(5, "Tupaki", "Action", 4, "Very Good");
		MovieDbModel mockModel6 = new MovieDbModel(6, "The God Father", "Action", 4, "Very Good");
		mockList.add(mockModel1);
		mockList.add(mockModel2);
		mockList.add(mockModel3);
		mockList.add(mockModel4);
		mockList.add(mockModel5);
		mockList.add(mockModel6);
		
		MovieDbModel mockModelFilter1 = new MovieDbModel(1, "Ratsasan", "Crime Thriller", 4, "Very Good");
		MovieDbModel mockModelFilter2 = new MovieDbModel(2, "Goodachari", "Crime Thriller", 4, "Good");
		MovieDbModel mockModelFilter3 = new MovieDbModel(3, "MagaDheera", "SocioFantacy", 5, "Very Good");
		filterList.add(mockModelFilter1);
		filterList.add(mockModelFilter2);
		filterList.add(mockModelFilter3);
		
		MovieDbModel mockModelGenre1 = new MovieDbModel(1, "Ratsasan", "Crime Thriller", 4, "Very Good");
		MovieDbModel mockModelGenre2 = new MovieDbModel(2, "Goodachari", "Crime Thriller", 4, "Good");
		MovieDbModel mockModelGenre3 = new MovieDbModel(3, "MagaDheera", "SocioFantacy", 5, "Very Good");
		MovieDbModel mockModelGenre4 = new MovieDbModel(4, "Arjun Reddy", "Love", 3, "Good");
		genreList.add(mockModelGenre1);
		genreList.add(mockModelGenre2);
		genreList.add(mockModelGenre3);
		genreList.add(mockModelGenre4);
	}

	String expectedAllMovies = "[{\"movieId\":1,\"movieName\":\"Ratsasan\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Very Good\"}"
			+ ","
			+ "{\"movieId\":2,\"movieName\":\"Goodachari\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Good\"}"
			+ ","
			+ "{\"movieId\":3,\"movieName\":\"MagaDheera\",\"movieGenre\":\"SocioFantacy\",\"rating\":5,\"popularity\":\"Very Good\"}"
			+ ","
			+ "{\"movieId\":4,\"movieName\":\"KGF\",\"movieGenre\":\"Action\",\"rating\":3,\"popularity\":\"Good\"}"
			+ ","
			+ "{\"movieId\":5,\"movieName\":\"Tupaki\",\"movieGenre\":\"Action\",\"rating\":4,\"popularity\":\"Very Good\"}"
			+ ","
			+ "{\"movieId\":6,\"movieName\":\"The God Father\",\"movieGenre\":\"Action\",\"rating\":4,\"popularity\":\"Very Good\"}]";

	String expectedFilterMovies = "[{\"movieId\":1,\"movieName\":\"Ratsasan\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Very Good\"}"
			+ ","
			+ "{\"movieId\":2,\"movieName\":\"Goodachari\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Good\"}"
			+ ","
			+ "{\"movieId\":3,\"movieName\":\"MagaDheera\",\"movieGenre\":\"SocioFantacy\",\"rating\":5,\"popularity\":\"Very Good\"}]";

	String expectedGenreMovies = "[{\"movieId\":1,\"movieName\":\"Ratsasan\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Very Good\"}"
			+ ","
			+ "{\"movieId\":2,\"movieName\":\"Goodachari\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Good\"}"
			+ ","
			+ "{\"movieId\":3,\"movieName\":\"MagaDheera\",\"movieGenre\":\"SocioFantacy\",\"rating\":5,\"popularity\":\"Very Good\"}]";
	@Test
	public void testGetAllMovies() throws Exception {

		Mockito.when(moviedbcontroller.nowShowingAll()).thenReturn((mockList));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/allMovies").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		System.out.println("junit response -->"+result.getResponse().getContentAsString());

//		String expected="{movieId:1,movieName:Ratsasan, movieGenre:Crime Thriller, rating:4, popularity:Very Good}";
//		String expected="[{\"movieId\":6,\"movieName\":\"The God Father\",\"movieGenre\":\"Action\",\"rating\":4,\"popularity\":\"Very Good\"}]";
		/*
		 * String
		 * expected="[{\"movieId\":1,\"movieName\":\"Ratsasan\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Very Good\"}"
		 * +"," +
		 * "{\"movieId\":2,\"movieName\":\"Goodachari\",\"movieGenre\":\"Crime Thriller\",\"rating\":4,\"popularity\":\"Good\"}"
		 * +"," +
		 * "{\"movieId\":3,\"movieName\":\"MagaDheera\",\"movieGenre\":\"SocioFantacy\",\"rating\":5,\"popularity\":\"Very Good\"}"
		 * +"," +
		 * "{\"movieId\":4,\"movieName\":\"KGF\",\"movieGenre\":\"Action\",\"rating\":3,\"popularity\":\"Good\"}"
		 * +"," +
		 * "{\"movieId\":5,\"movieName\":\"Tupaki\",\"movieGenre\":\"Action\",\"rating\":4,\"popularity\":\"Very Good\"}"
		 * +"," +
		 * "{\"movieId\":6,\"movieName\":\"The God Father\",\"movieGenre\":\"Action\",\"rating\":4,\"popularity\":\"Very Good\"}]"
		 * ; System.out.println("Expected Response :-->>"+expected);
		 * System.out.println("");
		 * System.out.println("Actual Response :-->>"+result.getResponse().
		 * getContentAsString());
		 */

		JSONAssert.assertEquals(expectedAllMovies, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void testFilterByRating() throws Exception {
		int rate = 4;
		Mockito.when(moviedbcontroller.filterByRating(rate)).thenReturn(filterList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/filter/" + rate)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(expectedFilterMovies, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testGetByGenre() throws Exception {
		String []genres= {"SocioFantacy","Love"};
		/*
		 * String genre= "SocioFantacy"; String url="/byGenre/"; for (String string :
		 * genres) { url +=string+","; } System.out.println("URL :"+url);
		 */
		Mockito.when(moviedbcontroller.getByGenre(genres)).thenReturn(genreList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/byGenre/"+genres).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("result :-> "+result.getResponse().getContentAsString());
		System.out.println("output --> "+genreList);
//		JSONAssert.assertEquals(expectedGenreMovies, result.getResponse().getContentAsString(), false);
	}

	@Ignore
	@Test
	public void testGetByRateDescending() throws Exception {

	}

	@Ignore
	@Test
	public void testGetByRateAscending() {

	}

	@After
	public void finalize() {
		mockList.clear();
	}
}
