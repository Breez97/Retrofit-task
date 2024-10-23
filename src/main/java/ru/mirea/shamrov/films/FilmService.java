package ru.mirea.shamrov.films;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FilmService {

	@GET("prust/wikipedia-movie-data/master/movies.json")
	Call<List<FilmDTO>> getFilms();

}
