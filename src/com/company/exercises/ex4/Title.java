package com.company.exercises.ex4;


import com.company.model.cinema.Movie;
import com.company.util.Provider;

public class Title {

	// ---------------------------------------------------------------------------
	// Tytul drugiego filmu, ktory byl rezyserowany przez Nancy Meyers
	// ---------------------------------------------------------------------------
	private static String getTitle(int movieNumber, String director) {

		int moviesToSkip = movieNumber - 1;
		return Provider.getMovies()
		        .stream()
		        .filter(f -> f.getDirector().equals(director))
		        .map(Movie::getTitle)
		        .skip(moviesToSkip)
		        .findFirst()
		        .orElse("Blad (nie ma takiego filmu)...");
	}

	public static void main(String[] args) {
		final String DIRECTOR = "Nancy Meyers";

		for (int pos = 1; pos <= 3; pos++) {
			System.out.printf("TYTUL %d-EGO Z KOLEI FILMU, WYREZYSEROWANEGO PRZEZ %s:%n", pos, DIRECTOR);
			String title = getTitle(pos, DIRECTOR);
			System.out.println(title + "\n");
		}
	}
}
