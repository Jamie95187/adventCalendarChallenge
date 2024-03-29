import com.dayEighteen.OperationOperator;
import com.dayEleven.SeatingSystem;
import com.dayFifteen.MemoryGame;
import com.dayNine.Encoding;
import com.dayNineteen.MonsterMessage;
import com.dayOne.*;
import com.daySeventeen.ConwaysCubes;
import com.daySeventeen.ConwaysCubesPartTwo;
import com.daySeventeen.ConwaysCubesTwo;
import com.daySixteen.TicketTranslation;
import com.dayThirteen.ShuttleSearch;
import com.dayTwelve.*;
import com.dayTwo.*;
import com.dayThree.*;
import com.dayFour.*;
import com.dayFive.*;
import com.daySix.*;
import com.daySeven.*;
import com.dayEight.*;
import com.dayTen.Adapter;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) throws IOException, ScriptException {
        taskNineteen();
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
        solver.populateConsecutiveOnesMap();
        solver.printConsecutiveOnesMap();
        solver.printAnswerTwo();
    }

    private static void taskEleven() {
        SeatingSystem ss = new SeatingSystem();
        ss.populateSeatingPlan();
//        ss.checkNeighbourMethod();
        ss.makeIterationsPartTwo();
    }

    private static void taskTwelve() {
        RainRisk rr = new RainRisk();
//        rr.makeMultipleInstructions();
        rr.multipleActionsPartTwo();
    }

    private static void taskThirteen() {
        ShuttleSearch ss = new ShuttleSearch();
        ss.chineseRemainderTheorem();
    }

    private static void taskFifteen() {
        int[] data = new int[6];
        data[0] = 15;
        data[1] = 5;
        data[2] = 1;
        data[3] = 4;
        data[4] = 7;
        data[5] = 0;
        MemoryGame mg = new MemoryGame();
        mg.game(data);
    }

    private static void taskSixteen() {
        TicketTranslation tt = new TicketTranslation();
        tt.test();
    }

    private static void taskSeventeen() {
        ConwaysCubes cc = new ConwaysCubes();
        ConwaysCubesTwo cct = new ConwaysCubesTwo();
        ConwaysCubesPartTwo ccpt = new ConwaysCubesPartTwo();
        ccpt.test();
    }

    private static void taskEighteen() throws ScriptException {
        OperationOperator oo = new OperationOperator();
//        oo.test();
        oo.solver();
    }

    private static void taskNineteen() {
        MonsterMessage mm = new MonsterMessage();
        mm.addToInitialStack();
        mm.testIteratorMethod();
        int numberOfValidMessages = 0;
        ArrayList<String> removeDuplicatesMessagesToBeChecked = new ArrayList<>();
        ArrayList<String> removeDuplicatesValidRules = new ArrayList<>();
        for (String s : mm.messagesToBeChecked) {
            if (!removeDuplicatesMessagesToBeChecked.contains(s)) {
                removeDuplicatesMessagesToBeChecked.add(s);
            }
        }
        for (String s : mm.validRules) {
            if (!removeDuplicatesValidRules.contains(s)) {
                removeDuplicatesValidRules.add(s);
            }
        }
        for (String message: removeDuplicatesMessagesToBeChecked) {
//            System.out.println(message);
            if (removeDuplicatesValidRules.contains(message)) {
                numberOfValidMessages++;
            }
        }
        System.out.println(numberOfValidMessages);
    }
}
