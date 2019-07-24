package com.company.exercises.ex7;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.model.cinema.Sex;
import com.company.util.Provider;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Actors {

	// ---------------------------------------------------------------------------
	// Aktorzy i aktorki, ktorych imiona rozpoczynaja sie od 'J' lub 'K
	// Lista POSORTOWANA wg nazwisko i POGRUPOWANA wg plci
	//
	private static Map<Sex, List<Actor>> getActorsWithSpecificNames() {
		return Provider.getMovies()
		        .stream()
		        .map(Movie::getCast)
		        .flatMap(Collection::stream)
		        .distinct()
		        .filter(a -> {
			        String name = a.getName();
			        return name.startsWith("J") || name.startsWith("K");
		        })
		        .sorted(Comparator.comparing(a -> a.getName().split(" ")[1]))
		        .collect(Collectors.groupingBy(Actor::getSex));
	}

	public static void main(String[] args) {
		Map<Sex, List<Actor>> foundActors = getActorsWithSpecificNames();

		System.out.println("LISTA AKTOREK O IMIONACH ROZPOCZYNAJACYCH SI? OD 'J' LUB 'K");
		long actresses = foundActors.get(Sex.F).stream().peek(System.out::println).count();
		System.out.printf("-----%nIlosc znalezionych aktorek: %d%n%n", actresses);

		System.out.println("LISTA AKTOROW O IMIONACH ROZPOCZYNAJACYCH SI? OD 'J' LUB 'K");
		long actors = foundActors.get(Sex.M).stream().peek(System.out::println).count();
		System.out.printf("-----%nIlosc znalezionych aktorow: %d%n%n", actors);
	}

}
