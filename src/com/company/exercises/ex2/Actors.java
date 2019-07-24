package com.company.exercises.ex2;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.model.cinema.Sex;
import com.company.util.Provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Actors {

	// ---------------------------------------------------------------------------
	// Wszyscy aktorzy (mezczyzni) pojawiajacy sie w obsadach filmow
	// ---------------------------------------------------------------------------
	private static List<Actor> getActors() {
		return Provider.getMovies()
		        .stream()
		        .map(Movie::getCast)
		        .flatMap(Collection::stream)
		        .filter(a -> a.getSex() == Sex.M)
		        .distinct()
		        .peek(System.out::println)
		        .collect(Collectors.toList());
	}

	public static void main(String[] args) {

		System.out.println("LISTA AKTOROW (MEZCZYZN) POJAWIAJACYCH SIE W OBSADACH FILMOW:\n");
		List<Actor> foundActors = getActors();

		System.out.printf("-----%nIlosc znalezionych aktorow: %d%n", foundActors.size());

	}

}
