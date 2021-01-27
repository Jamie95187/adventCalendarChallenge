package com.daySixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class TicketTranslation {

    List<int[]> rules = new ArrayList<>();

    public void getRules() {
        BufferedReader reader;
        try {
            String path = "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySixteen/Rules.txt";
            System.out.println(Paths.get(path).toAbsolutePath());
            String content = Files.readString(Paths.get(path), StandardCharsets.US_ASCII);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        getRules();
    }

}
