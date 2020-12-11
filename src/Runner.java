import com.dayOne.*;
import com.dayTwo.*;
import com.dayThree.*;
import com.dayFour.*;
import com.dayFive.*;
import com.daySix.*;
import com.daySeven.*;
import com.dayEight.*;

import java.io.IOException;
import java.util.Queue;

public class Runner {

    public static void main(String[] args) throws IOException {
        taskEight();
    }

    private static void taskOne() {
        TaskOne solver = new TaskOne();
        solver.readFile();
        solver.printAnswerOne();
        solver.printAnswerTwo();
    }

    private static void taskTwo() {
        TaskTwo solver = new TaskTwo();
        solver.readFile();
        System.out.println(solver.checkForValidEntries());
        System.out.println(solver.checkForValidEntriesTaskTwo());
    }

    private static void taskThree() {
        TaskThree solver = new TaskThree();
        solver.readFile();
        System.out.println(solver.countNumberOfTrees(3, 1) *
                solver.countNumberOfTrees(1, 1) *
                solver.countNumberOfTrees(5, 1) *
                solver.countNumberOfTrees(7, 1) *
                solver.countNumberOfTrees(1, 2));
    }

    private static void taskFour() throws IOException {
        TaskFour solver = new TaskFour();
        solver.readFile();
        System.out.println(solver.countValidPassports());
        System.out.println(solver.countValidPassportsPartTwo());
    }

    private static void taskFive() {
        BoardingPasses solver = new BoardingPasses();
        solver.readFile();
        solver.highestSeatId();
        System.out.println(solver.getMissingSeatId());
    }

    private static void taskSix() throws IOException {
        QuestionsTask solver = new QuestionsTask();
        solver.test();
    }

    private static void taskSeven() {
        BagChecker solver = new BagChecker();
        solver.readFile();
        solver.addToSet();
//        Day7 solver = new Day7("/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/daySeven/bagData.txt");
//        solver.bagCountPart1("shiny gold");
//        solver.bagCountPart2("shiny gold");
    }

    private static void taskEight() {
        DayEight solver = new DayEight();
        solver.readFile();
        System.out.println(solver.countValueOfAccumulator());
        Queue<String[]> queue = solver.getQueue();
        for (String[] item : queue) {
            System.out.println(item[0] + " " + item[1]);
        }
        solver.accCount();
    }
}
