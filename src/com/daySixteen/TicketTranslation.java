package com.daySixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class TicketTranslation {

    List<int[]> rules = new ArrayList<>();
    List<String> nearbyTickets = new ArrayList<>();

    private void getRules() {
        try {
            String path = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Rules.txt";
            String content = Files.readString(Paths.get(path), StandardCharsets.US_ASCII);
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(content);
            while (m.find()) {
                int[] rule = new int[2];
                rule[0] = Integer.parseInt(m.group());
                m.find();
                rule[1] = Integer.parseInt(m.group());
                rules.add(rule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getNearbyTickets() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Tickets.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                nearbyTickets.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int countErrors() {
        for (int i = 0; i < nearbyTickets.size(); i++) {
            String[] values = nearbyTickets.get(i).split(",");
            for ()
        }
    }

    public void test() {
        getRules();
        getNearbyTickets();
    }

}
