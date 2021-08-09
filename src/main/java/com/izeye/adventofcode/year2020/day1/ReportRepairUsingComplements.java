package com.izeye.adventofcode.year2020.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * "Day 1: Report Repair" from "Advent of Code 2020".
 *
 * @author Johnny Lim
 */
public class ReportRepairUsingComplements {

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (InputStream inputStream = ReportRepairUsingComplements.class.getClassLoader().getResourceAsStream("year2020/day1/input.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.valueOf(line));
            }
        }

        Pair pair = getPair(numbers, 2020);
        int part1Answer = pair.first * pair.second;
        System.out.println(part1Answer);

        Triple triple = getTriple(numbers);
        int part2Answer = triple.first * triple.second * triple.third;
        System.out.println(part2Answer);
    }

    private static Pair getPair(List<Integer> numbers, int sum) {
        Map<Integer, Integer> complements = new HashMap<>(numbers.size());
        for (Integer number : numbers) {
            complements.put(sum - number, number);
        }
        for (Integer number : numbers) {
            Integer complement = complements.get(number);
            if (complement != null) {
                return new Pair(number, complement);
            }
        }
        return null;
    }

    private static Triple getTriple(List<Integer> numbers) {
        for (Integer number : numbers) {
            Pair complementPair = getPair(numbers, 2020 - number);
            if (complementPair != null) {
                return new Triple(number, complementPair.first, complementPair.second);
            }
        }
        throw new IllegalArgumentException("An answer is expected.");
    }

    static class Pair {

        final int first;
        final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

    static class Triple {

        final int first;
        final int second;
        final int third;

        Triple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

    }

}
