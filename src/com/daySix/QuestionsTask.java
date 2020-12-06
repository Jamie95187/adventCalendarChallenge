package com.daySix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsTask {

    List<String> groups = new ArrayList<>();

    public void readFile() throws IOException {
        Path fileName = Path.of("/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySix/answers.txt");
        String answers = Files.readString(fileName);
        populateAnswersList(answers);
    }

    private void populateAnswersList(String answers) {
        String[] groupedAnswers = answers.split("\\n\\s+");
        for (String group : groupedAnswers) {
            groups.add(group.trim());
        }
    }

    public Map<Character, Integer> tallyAnswers() {
        Map<Character, Integer> tally = new HashMap<>();

        for (String group: groups) {
            for (int i = 0; i < group.length(); i++) {
                if (tally.containsKey(group.charAt(i))) {
                    tally.put(group.charAt(i), tally.get(group.charAt(i)));
                } else {
                    tally.put(group.charAt(i), 1);
                }
            }
        }

        return tally;
    }

    public void test() throws IOException {
        readFile();
        for (String s : groups) {
            System.out.println(s);
            System.out.println("-----------------------------");
        }
    }
}
