package com.dayFour;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskFour {

   private List<String> passports = new ArrayList<>();

   public void readFile() {
       String content = new Scanner(new File("Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayFour/")).useDelimiter("\\Z").next();
   }

   public void populatePassportsList() {

   }

}
