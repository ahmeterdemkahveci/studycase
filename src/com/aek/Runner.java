package com.aek;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final String FILE_NAME = "data.txt";
    private static final String EXCEPTION_MESSAGE_INVALID_DATA = "Your input doesn't seem as integer value so game serie will be skipped.";
    private static final String EXCEPTION_MESSAGE_INVALID_SCORE = "Your input doesn't seem as integer value so this score will be skipped.";
    private static final String EMPTY_CHAR = " ";

    private void displayResult(int gameCount, String[] scores) {
        int highest = findHighestGamesCount(gameCount, scores);
        int lowest = findLowestGamesCount(gameCount, scores);
        System.out.println(highest + " " + lowest);
    }

    private int findHighestGamesCount(int gameCount, String[] scores) {
        int count = 0;
        try {
            int highest = Integer.parseInt(scores[0]);
            highest = Math.max(highest, 0);
            for (int i = 1; i < (Math.min(gameCount, scores.length)); i++) {
                try {
                    if (highest < Integer.parseInt(scores[i])) {
                        count += 1;
                        highest = Integer.parseInt(scores[i]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(EXCEPTION_MESSAGE_INVALID_SCORE);
                }

            }

        } catch (NumberFormatException e) {
            System.out.println(EXCEPTION_MESSAGE_INVALID_SCORE);
        }
        return count;
    }

    private int findLowestGamesCount(int gameCount, String[] scores) {
        int count = 0;
        int value = 0;
        try {
            int lowest = Integer.parseInt(scores[0]);
            lowest = Math.max(lowest, 0);
            for (int i = 1; i < (Math.min(gameCount, scores.length)); i++) {
                try {
                    value = Integer.parseInt(scores[i]);
                    value = value < 0 ? lowest : value;
                    if (lowest > value) {
                        count += 1;
                        lowest = value;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(EXCEPTION_MESSAGE_INVALID_SCORE);
                }

            }
        } catch (NumberFormatException e) {
            System.out.println(EXCEPTION_MESSAGE_INVALID_SCORE);
        }
        return count;
    }

    public void makeCalculations() {
        List<String> matchesAndScores = new ArrayList<>();
        String[] dividedAsMatchAndScores = new String[0];
        boolean complexityFlag = false;
        String[] scores = new String[0];
        int gameCount = 0;
        try {
            Files.lines(Paths.get(ClassLoader.getSystemResource(FILE_NAME)
                    .toURI())).forEach(matchesAndScores::add);
            dividedAsMatchAndScores = matchesAndScores.toArray(new String[0]);

        } catch (Exception e) {
            System.out.println("Input file includes wrong data type");
        }

        for (int i = 0; i < dividedAsMatchAndScores.length; i++) {
            if (i % 2 == 0) {
                try {
                    gameCount = Integer.parseInt(dividedAsMatchAndScores[i]);
                    gameCount = Math.min(gameCount, 1000);
                } catch (NumberFormatException e) {
                    System.out.println(EXCEPTION_MESSAGE_INVALID_DATA);
                    i = i + 1;
                }
            } else {
                if (dividedAsMatchAndScores.length > 2) {
                    complexityFlag = true;
                    displayResult(gameCount, dividedAsMatchAndScores[i].split(EMPTY_CHAR));
                } else {
                    scores = dividedAsMatchAndScores[i].split(EMPTY_CHAR);
                }
            }
        }
        if (!complexityFlag) {
            displayResult(gameCount, scores);
        }

    }
}




