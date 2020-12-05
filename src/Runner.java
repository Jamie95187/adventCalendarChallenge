import com.dayOne.*;
import com.dayTwo.*;
import com.dayThree.*;
import com.dayFour.*;
import com.dayFive.*;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        taskFour();
    }

    public static void taskOne() {
        TaskOne solver = new TaskOne();
        solver.readFile();
        solver.printAnswerOne();
        solver.printAnswerTwo();
    }

    public static void taskTwo() {
        TaskTwo solver = new TaskTwo();
        solver.readFile();
        System.out.println(solver.checkForValidEntries());
        System.out.println(solver.checkForValidEntriesTaskTwo());
    }

    public static void taskThree() {
        TaskThree solver = new TaskThree();
        solver.readFile();
        System.out.println(solver.countNumberOfTrees(3, 1) *
                solver.countNumberOfTrees(1, 1) *
                solver.countNumberOfTrees(5, 1) *
                solver.countNumberOfTrees(7, 1) *
                solver.countNumberOfTrees(1, 2));
    }

    public static void taskFour() throws IOException {
        TaskFour solver = new TaskFour();
        solver.readFile();
        System.out.println(solver.countValidPassports());
        System.out.println(solver.countValidPassportsPartTwo());
        System.out.println(solver.validityChecks("eyr:2027\n" +
                "ecl:amb iyr:2014 hcl:#fffffd\n" +
                "pid:838758900\n" +
                "hgt:177cm byr:1942"));
    }

    public static void taskFive() {
        BoardingPasses solver = new BoardingPasses();
        solver.readFile();
        solver.highestSeatId();
        System.out.println(solver.getMissingSeatId());
    }
}
