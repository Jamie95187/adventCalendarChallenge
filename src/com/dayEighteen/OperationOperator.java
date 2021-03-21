package com.dayEighteen;

import com.daySeventeen.Cube;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class OperationOperator {

    List<String> operations;

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
//                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEighteen/exampleOperations.txt"
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEighteen/operations.txt"
            ));
            String line = reader.readLine();
            while (line != null) {
                operations.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private int equateOperation(String operation) throws ScriptException {
        int answer = 0;
        String[] values = operation.split(" ");
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        answer = (int)(engine.eval(operation));
        return answer;
    }

    public void test() throws ScriptException {
        // Should print 26
        System.out.println(equateOperation("2 * 3 + (4 * 5)"));
        // Should print 437
        System.out.println(equateOperation("5 + (8 * 3 + 9 + 3 * 4 * 3)"));
    }
}
