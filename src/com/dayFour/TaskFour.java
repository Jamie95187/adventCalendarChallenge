package com.dayFour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskFour {

   private List<String> passportsInfo = new ArrayList<>();

   public void readFile() throws IOException {
       Path fileName = Path.of("/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayFour/passports.txt");
       String passports = Files.readString(fileName);
       populatePassportsList(passports);
   }

   private void populatePassportsList(String passports) {
       String[] splitStrings = passports.split("\\n\\s+");
       for (String passport : splitStrings) {
           passportsInfo.add(passport);
       }
       System.out.println(splitStrings[splitStrings.length-1]);
   }

   public int countValidPassports() {
       int validPassports = 0;

       for(String passport: passportsInfo) {
           if(passport.contains("byr:") && passport.contains("iyr:") && passport.contains("eyr:") &&
               passport.contains("hgt:") && passport.contains("hcl:") & passport.contains("ecl:") && passport.contains("pid:")) {
               validPassports++;
           }
       }

       return validPassports;
   }

   private boolean validityChecks(String passportDetails) {
    return false;
   };
}
