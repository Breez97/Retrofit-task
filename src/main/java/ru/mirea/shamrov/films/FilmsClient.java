package ru.mirea.shamrov.films;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FilmsClient {

	public static void main(String[] args) throws IOException {
		Retrofit client = new Retrofit.Builder()
				.baseUrl("https://raw.githubusercontent.com/")
				.addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
				.build();

		FilmService filmService = client.create(FilmService.class);
		Call<List<FilmDTO>> call = filmService.getFilms();

		Response<List<FilmDTO>> response = call.execute();
		if (response.isSuccessful() && response.body() != null) {
			List<FilmDTO> allFilms = response.body();
			Optional<FilmDTO> resultFilm = allFilms.stream()
					.filter(film -> film.getYear() < 2000 && film.getCast() != null)
					.max(Comparator.comparingInt(film -> film.getCast().size()));
			if (resultFilm.isPresent()) {
				System.out.println("Title: " + resultFilm.get().getTitle());
				System.out.println("Year: " + resultFilm.get().getYear());
				System.out.println("Cast amount: " + resultFilm.get().getCast().size());
				System.out.println("Cast: " + resultFilm.get().getCast());
			} else {
				System.out.println("No such film");
			}
		} else {
			System.out.println("error");
		}
	}

}
