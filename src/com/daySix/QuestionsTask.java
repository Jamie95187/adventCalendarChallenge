package com.daySix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
            groups.add(group);
        }
    }

//    public Map<Character, Integer> tallyAnswers() {
//        Map<Character, Integer> tally = new HashMap<>();
//
//        for (String group: groups) {
//            for (int i = 0; i < group.length(); i++) {
//                if (tally.containsKey(group.charAt(i))) {
//                    tally.put(group.charAt(i), tally.get(group.charAt(i)));
//                } else {
//                    tally.put(group.charAt(i), 1);
//                }
//            }
//        }
//
//        return tally;
//    }

    public Set<Character> tallyAnswers(String answers) {
        char[] chars = answers.toCharArray();
        answers = answers.replaceAll("\\s+", "").trim();
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
//            System.out.println(c);
            charSet.add(c);
        }

        return charSet;
    }

    public Map<Character, Integer> tallyAnswersPartTwo(String group) {
        Map<Character, Integer> tally = new HashMap<>();
        String[] individualPerson = group.split("\\s+");
        for (String person : individualPerson) {
            char[] charSet = person.toCharArray();
            for (Character c : charSet) {
                if (tally.containsKey(c)) {
                    tally.put(c, tally.get(c) + 1);
                } else {
                    tally.put(c, 1);
                }
            }
        }
        return tally;
    }

    public void test() throws IOException {
        readFile();
        int count = 0;
        for (String s : groups) {
            int numberOfPeopleInGroup = s.split("\\s+").length;
            Map<Character, Integer> tally = tallyAnswersPartTwo(s);
            for (Map.Entry<Character, Integer> entry : tally.entrySet()){
                if (entry.getValue() == numberOfPeopleInGroup){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
