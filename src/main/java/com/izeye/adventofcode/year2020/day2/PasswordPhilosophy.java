package com.izeye.adventofcode.year2020.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * "Day 2: Password Philosophy" from "Advent of Code 2020".
 *
 * @author Johnny Lim
 */
public class PasswordPhilosophy {

    public static void main(String[] args) throws IOException {
        int part1Valid = 0;
        int part2Valid = 0;
        try (InputStream inputStream = PasswordPhilosophy.class.getClassLoader().getResourceAsStream("year2020/day2/input.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (isValidForPart1(line)) {
                    part1Valid++;
                }
                if (isValidForPart2(line)) {
                    part2Valid++;
                }
            }
        }
        System.out.println(part1Valid);
        System.out.println(part2Valid);
    }

    private static boolean  isValidForPart1(String line) {
        String[] policyAndPassword = line.split(": ");
        String policy = policyAndPassword[0];
        String password = policyAndPassword[1];

        String[] minMaxAndLetter = policy.split(" ");
        String[] minAndMax = minMaxAndLetter[0].split("-");
        int min = Integer.parseInt(minAndMax[0]);
        int max = Integer.parseInt(minAndMax[1]);
        char letter = minMaxAndLetter[1].charAt(0);

        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == letter) {
                count++;
            }
        }

        return count >= min && count <= max;
    }

    private static boolean  isValidForPart2(String line) {
        String[] policyAndPassword = line.split(": ");
        String policy = policyAndPassword[0];
        String password = policyAndPassword[1];

        String[] positionsAndLetter = policy.split(" ");
        String[] positions = positionsAndLetter[0].split("-");
        int position1 = Integer.parseInt(positions[0]);
        int position2 = Integer.parseInt(positions[1]);
        char letter = positionsAndLetter[1].charAt(0);

        int count = 0;
        if (password.charAt(position1 - 1) == letter) {
            count++;
        }
        if (password.charAt(position2 - 1) == letter) {
            count++;
        }
        return count == 1;
    }

}
