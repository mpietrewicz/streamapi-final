package com.company.exercises.ex3;

import com.company.model.cinema.Actor;
import com.company.model.cinema.Movie;
import com.company.model.cinema.Sex;
import com.company.util.Provider;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Actresses {

	// ---------------------------------------------------------------------------
	// Aktorki filmu o nr 3 uporzadkowane wg nazwisk i imionÓ
	// ---------------------------------------------------------------------------Ó
	private static List<Actor> getActressesofMovie(int movieNumber) {
		return Provider.getMovies()
		        .stream()
		        .filter(f -> f.getNr() == movieNumber)
		        .map(Movie::getCast)
		        .flatMap(Collection::stream)
		        .filter(a -> a.getSex() == Sex.F)
		        .sorted(Comparator.comparing((Actor a) -> a.getName().split(" ")[1])
		                .thenComparing(Actor::compareTo))
		        .peek(System.out::println)
		        .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println("LISTA AKTOREK FILMU NR 3 UPORZADKOWANA WG NAZWISK I IMION:\n");
		List<Actor> foundActresses = getActressesofMovie(3);

		System.out.printf("-----%nIlosc znalezionych aktorek: %d%n", foundActresses.size());
	}

}
