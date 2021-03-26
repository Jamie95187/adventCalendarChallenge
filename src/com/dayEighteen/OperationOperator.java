package com.dayEighteen;

import com.daySeventeen.Cube;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
        if (operation.contains("(")) {
            String[] values = operation.substring(1, operation.length()-1).split(" ");
            int currentTotal = Integer.parseInt(values[0]);
            for (int i = 1; i < values.length ; i = i+2) {
                if (values[i].contains("*")) {
                    currentTotal = currentTotal * Integer.parseInt(values[i+1]);
                } else if (values[i].contains("+")) {
                    currentTotal = currentTotal + Integer.parseInt(values[i+1]);
                }
            }
            answer = currentTotal;
        }
//        String[] values = operation.split(" ");
//        ScriptEngineManager mgr = new ScriptEngineManager();
//        ScriptEngine engine = mgr.getEngineByName("JavaScript");
//        answer = (int)(engine.eval(operation));
        return answer;
    }

    public void test() throws ScriptException {
        String eq_1 = "2 * 3 + (4 * 5)";
        String eq_2 = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        String eq_3 = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        // Should print 26
        System.out.println(Arrays.toString(splitEquationIntoArray(eq_1)));
        System.out.println(sumEquations(splitEquationIntoArray(eq_1)));
//         Should print 437
        System.out.println(Arrays.toString(splitEquationIntoArray(eq_2)));
        System.out.println(sumEquations(splitEquationIntoArray(eq_2)));
        // Should print 12240
        System.out.println(Arrays.toString(splitEquationIntoArray(eq_3)));
        System.out.println(sumEquations(splitEquationIntoArray(eq_3)));
    }

    private String[] splitEquationIntoArray(String equation) {
        "(\\d+\s\\+)|(\\d+\s\\*)|(?=\\d+\s\\\d+)?"
        String[] splitEquation = equation.split("(?=[0-9]+(?![^(]*\\)))|(?=\\()|(?<=\\))");
        return splitEquation;
    }

    private int sumEquations(String[] equationSplitIntoArray) throws ScriptException {
        int answer = 0;
        for (int i = 0; i < equationSplitIntoArray.length - 1; i++) {
            if (i == 0) {
                if (equationSplitIntoArray[i].contains("+") && !equationSplitIntoArray[i+1].contains("(")) {
                    answer = Integer.parseInt(equationSplitIntoArray[0].split(" ")[0]) + Integer.parseInt(equationSplitIntoArray[1].split(" ")[0]);
                } else if (equationSplitIntoArray[i].contains("*") && !equationSplitIntoArray[i+1].contains("(")) {
                    answer = Integer.parseInt(equationSplitIntoArray[0].split(" ")[0]) * Integer.parseInt(equationSplitIntoArray[1].split(" ")[0]);
                } else if (equationSplitIntoArray[i].contains("+") && equationSplitIntoArray[i+1].contains("(")){
                    answer = Integer.parseInt(equationSplitIntoArray[0].split(" ")[0]) + equateOperation(equationSplitIntoArray[1]);
                } else if (equationSplitIntoArray[i].contains("*") && equationSplitIntoArray[i+1].contains("(")) {
                    answer = Integer.parseInt(equationSplitIntoArray[0].split(" ")[0]) * equateOperation(equationSplitIntoArray[1]);
                }
            } else if (i != 0) {
                if (equationSplitIntoArray[i].contains("+") && !equationSplitIntoArray[i+1].contains("(")) {
                    answer = answer + Integer.parseInt(equationSplitIntoArray[i+1].split(" ")[0]);
                } else if (equationSplitIntoArray[i].contains("*") && !equationSplitIntoArray[i+1].contains("(")) {
                    answer = answer * Integer.parseInt(equationSplitIntoArray[i+1].split(" ")[0]);
                } else if (equationSplitIntoArray[i].contains("+") && equationSplitIntoArray[i+1].contains("(")){
                    answer = answer + equateOperation(equationSplitIntoArray[i+1]);
                } else if (equationSplitIntoArray[i].contains("*") && equationSplitIntoArray[i+1].contains("(")){
                    answer = answer * equateOperation(equationSplitIntoArray[i+1]);
                }
            }

            answer += equateOperation(equationSplitIntoArray[i]);
        }
        return answer;
    }
}
