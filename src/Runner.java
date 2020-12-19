import com.dayNine.Encoding;
import com.dayOne.*;
import com.dayTwo.*;
import com.dayThree.*;
import com.dayFour.*;
import com.dayFive.*;
import com.daySix.*;
import com.daySeven.*;
import com.dayEight.*;
import com.dayTen.Adapter;

import java.io.IOException;
import java.util.Map;

public class Runner {

    public static void main(String[] args) throws IOException {
        taskTen();
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
    }

    private static void taskEight() {
        DayEight solver = new DayEight();
        solver.readFile();
        System.out.println(solver.countValueOfAccumulator());
        solver.accCount();
    }

    private static void taskNine() {
        Encoding solver = new Encoding();
        solver.readFile();
//        solver.printAnswer();
//        solver.printDataTwo();
//        System.out.println("----------------------------------------------------");
//        System.out.println("lowest = " + solver.findRange()[0]);
//        System.out.println("highest = " + solver.findRange()[1]);
        System.out.println(solver.findRange()[0] + solver.findRange()[1]);
    }

    private static void taskTen() {
        Adapter solver = new Adapter();
        solver.readFile();
        solver.sortList();
        solver.printData();
        Map<Integer,Integer> taskOneAns = solver.getJoltageCount();
        for (Map.Entry<Integer, Integer> joltCount : taskOneAns.entrySet()) {
            System.out.println("Difference: " + joltCount.getKey() + "  " + "Count: " + joltCount.getValue());
        }
        System.out.println(taskOneAns.get(1) * taskOneAns.get(3));
    }
}
