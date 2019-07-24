package com.company.exercises.ex5;

import com.company.model.cinema.Movie;
import com.company.model.cinema.Sex;
import com.company.util.Provider;

import java.util.List;
import java.util.stream.Collectors;

public class Movies {

	// ---------------------------------------------------------------------------
	// filmy, w ktorych cala obsade stanowia mezczyzni
	// ---------------------------------------------------------------------------
	private static List<Movie> getMenMovies() {
		return Provider.getMovies()
		        .stream()
		        .filter(f -> f.getCast().stream().noneMatch(a -> a.getSex() == Sex.F))
		        .peek(System.out::println)
		        .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println("LISTA FILMOW, W KTORYCH CALA OBSADE STANOWIA MEZCZYZNI:");
		List<Movie> movies = getMenMovies();

		System.out.printf("-----%nIlosc znalezionych filmow: %d%n", movies.size());
	}
}
