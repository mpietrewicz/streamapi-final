package com.company.exercises.ex6;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.util.Provider;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Actors {

	// ---------------------------------------------------------------------------
	// Aktorzy i aktorki, ktorych imiona rozpoczynaja sie od 'J' lub 'K'
	// Lista uporzadkowana wg plci
	// ---------------------------------------------------------------------------
	private static List<Actor> getActorsWithSpecificNames() {
		return Provider.getMovies()
		        .stream()
		        .map(Movie::getCast)
		        .flatMap(Collection::stream)
		        .distinct()
		        .filter(a -> {
			        String name = a.getName();
			        return name.startsWith("J") || name.startsWith("K");
		        })
		        .sorted(Comparator.comparing(Actor::getSex))
		        .peek(System.out::println)
		        .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println("LISTA AKTOREK I AKTOROW, O IMIONACH "
		        + "ROZPOCZYNAJACYCH SIE OD 'J' LUB OD 'K' "
		        + "(UPORZADKOWANA WEDLUG PLCI):\n");
		List<Actor> actors = getActorsWithSpecificNames();

		System.out.printf("-----%nIlosc znalezionych aktorek/aktorow: %d%n", actors.size());
	}

}
