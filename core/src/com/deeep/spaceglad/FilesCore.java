package com.deeep.spaceglad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FilesCore {

    static private final int MAX_SCORES = 5;
    static private final String FILE_NAME = "data/writtenScores.txt";

    static public void sendScore(int score) {
        System.out.println("ya tut v file " + score);
        String[] scores = readScoresFromFile();
        System.out.println(Arrays.toString(scores));
        scores = updateScores(scores, score);
        writeScoresToFile(scores);
    }

    public static String[] readScoresFromFile() {
        String[] scores = new String[MAX_SCORES];

        FileHandle fileHandle = Gdx.files.local(FILE_NAME);
        if (!fileHandle.exists()) {
            return scores;
        }

        try {
            String[] lines = fileHandle.readString().split("\\r?\\n");
            System.arraycopy(lines, 0, scores, 0, Math.min(lines.length, MAX_SCORES));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scores;
    }

    static private String[] updateScores(String[] scores, int newScore) {

        int number = Integer.parseInt(scores[MAX_SCORES - 1]);
        if (newScore <= number) {
            return scores;
        }
        scores[MAX_SCORES - 1] = String.valueOf(newScore);
        Arrays.sort(scores, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null || s2 == null) return 0;
                return Integer.compare(Integer.parseInt(s2), Integer.parseInt(s1));
            }
        });

        return scores;
    }

    static private void writeScoresToFile(String[] scores) {
        FileHandle fileHandle = Gdx.files.local(FILE_NAME);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(MAX_SCORES, scores.length); i++) {
            if (scores[i] != null) {
                stringBuilder.append(scores[i]).append("\n");
            }
        }

        try {
            fileHandle.writeString(stringBuilder.toString(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
