import com.dayOne.*;
import com.dayTwo.*;

public class Runner {

    public static void main(String[] args) {
        taskTwo();
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
    }
}
