import com.dayOne.*;
import com.dayTwo.*;
import com.dayThree.*;

public class Runner {

    public static void main(String[] args) {
        taskThree();
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
        System.out.println(solver.countNumberOfTrees());
    }
}
