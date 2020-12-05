package com.dayFour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskFour {

   private List<String> passportsInfo = new ArrayList<>();
   private List<String> validPassports = new ArrayList<>();

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
   }

   public int countValidPassports() {
       int numValidPassports = 0;

       for(String passport: passportsInfo) {
           if(passport.contains("byr:") && passport.contains("iyr:") && passport.contains("eyr:") &&
               passport.contains("hgt:") && passport.contains("hcl:") & passport.contains("ecl:") && passport.contains("pid:")) {
               validPassports.add(passport);
               numValidPassports++;
           }
       }

       return numValidPassports;
   }

    public int countValidPassportsPartTwo() {
       int count = 0;
        for(String details: validPassports) {
            if(validityChecks(details)) {
                count++;
            }
        }
        return count;
    }

   public boolean validityChecks(String passportDetails) {
       passportDetails = passportDetails.replace("\n", " ");

       String[] individualFields = passportDetails.split(" ");
       String byrValue = "";
       String iyrValue = "";
       String eyrValue = "";
       String hgtValue = "";
       String hclValue = "";
       String eclValue = "";
       String pidValue = "";

       for (String field : individualFields) {
           field = field.trim();
           if(field.contains("byr:")) {
               byrValue = field;
           } else if(field.contains("iyr:")) {
               iyrValue = field;
           } else if(field.contains("eyr:")) {
               eyrValue = field;
           } else if(field.contains("hgt:")) {
               hgtValue = field;
           } else if(field.contains("hcl:")) {
               hclValue = field;
           } else if(field.contains("ecl:")) {
               eclValue = field;
           } else if(field.contains("pid:")) {
               System.out.println("PID = " + field);
               pidValue = field;
           }
       }

       if (byrValue.length() != 8) {
           return false;
       }
       int birthYear = 0;
       birthYear = Integer.parseInt(byrValue.substring(4,8));
       if (birthYear < 1920 || birthYear > 2002) {
           return false;
       }
       System.out.println("Valid Birth Year!");

       if (iyrValue.length() != 8) {
           return false;
       }
       int issueYear = Integer.parseInt(iyrValue.substring(4,8));
       if (issueYear > 2020 || issueYear < 2010) {
           return false;
       }
       System.out.println("Issue Year!");

       if (eyrValue.length() != 8) {
           return false;
       }
       int expYear = Integer.parseInt(eyrValue.substring(4,8));
       if (expYear < 2020 || expYear > 2030) {
           return false;
       }
       System.out.println("Expiry Year!");

       if (hgtValue.contains("cm")) {
           int hgtValueCm = 0;
           if (hgtValue.length() != 9) {
               return false;
           } else {
               hgtValueCm = Integer.parseInt(hgtValue.substring(4, 7));
           }
           if (hgtValueCm < 150 || hgtValueCm > 193) {
               return false;
           }
       } else if (hgtValue.contains("in")) {
           int hgtValueIn = 0;
           if (hgtValue.length() != 8) {
               return false;
           } else {
               hgtValueIn = Integer.parseInt(hgtValue.substring(4, 6));
           }
           if (hgtValueIn < 59 || hgtValueIn > 76) {
               return false;
           }
       } else {
           return false;
       }
       System.out.println("Valid hgt!");

       if (hclValue.length() != 11){
           return false;
       }
       String hairColour = hclValue.substring(4, 11);
       if (hairColour.charAt(0) != '#') {
           return false;
       }
       for (int charIndex = 1; charIndex < hairColour.length() - 1; charIndex++) {
           String charValue = String.valueOf(hairColour.charAt(charIndex));
           if (charValue.matches("[a-f|0-9]") == false) {
               return false;
           }
       }
       System.out.println("hcl valid!");

       if (eclValue.length() != 7) {
           return false;
       }
       String eyeColour = eclValue.substring(4, 7);
        if (!eyeColour.contains("amb") && !eyeColour.contains("grn") && !eyeColour.contains("blu") && !eyeColour.contains("brn") && !eyeColour.contains("gry") && !eyeColour.contains("hzl") && !eyeColour.contains("oth")) {
            return false;
        }
       System.out.println("ecl valid!");

        if (pidValue.length() != 13) {
            return false;
        }
        String passportId = pidValue.substring(4, 13);
        for (int charIndex = 0; charIndex < passportId.length(); charIndex++) {
           if (!String.valueOf(passportId.charAt(charIndex)).matches("[0-9]")) {
               System.out.println("STRING " + passportId.charAt(charIndex));
               return false;
           }
        }
       System.out.println("PID Valid!");

       return true;
   };

   public void test() {
       System.out.println("Passport details = " + validPassports.get(0));
       System.out.println("----------------------------------------------");
       validityChecks(validPassports.get(0));
   }
}
