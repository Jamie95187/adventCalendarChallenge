package com.dayEighteen;

import com.daySeventeen.Cube;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

//    private int equateOperation(String operation) throws ScriptException {
//        int answer = 0;
//        if (operation.contains("(")) {
//            String[] values = operation.substring(1, operation.length()-1).split(" ");
//            int currentTotal = Integer.parseInt(values[0]);
//            for (int i = 1; i < values.length ; i = i+2) {
//                if (values[i].contains("*")) {
//                    currentTotal = currentTotal * Integer.parseInt(values[i+1]);
//                } else if (values[i].contains("+")) {
//                    currentTotal = currentTotal + Integer.parseInt(values[i+1]);
//                }
//            }
//            answer = currentTotal;
//        }
////        String[] values = operation.split(" ");
////        ScriptEngineManager mgr = new ScriptEngineManager();
////        ScriptEngine engine = mgr.getEngineByName("JavaScript");
////        answer = (int)(engine.eval(operation));
//        return answer;
//    }

    public void test() throws ScriptException {
        String eq_1 = "2 * 3 + (4 * 5)";
        String eq_2 = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        String eq_3 = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        ArrayList<String> listOfOp = new ArrayList<>();
        // Should print 26
        listOfOp = splitEquationIntoList(eq_1);
        for (String s : listOfOp) {
            System.out.println(s);
        }
        System.out.println(sumEquations(listOfOp));
        // Should print 437
        listOfOp = splitEquationIntoList(eq_2);
        for (String s : listOfOp) {
            System.out.println(s);
        }
        System.out.println(sumEquations(listOfOp));
        
        // Should print 12240
        listOfOp = splitEquationIntoList(eq_3);
        System.out.println(sumEquations(listOfOp));
    }

    private ArrayList<String> splitEquationIntoList(String equation) {
        ArrayList<String> listOfOperations = new ArrayList<>();
        int opBr = 0;
        int indexOpBr = 0;
        int startOpIndex = 0;
        boolean inOp = false;
        String operation = "";
        for (int i = 0; i < equation.length(); i++) {
            char character = equation.charAt(i);
            if (character == '(') {
                if (opBr == 0) {
                    indexOpBr = i;
                }
                opBr += 1;
            } else if (character == ')') {
                opBr--;
                if (opBr == 0) {
                    operation = equation.substring(indexOpBr, i+1);
                    listOfOperations.add(operation);
                }
            } else if (character != ' ' && opBr == 0) {
                if (character == '*' || character == '+') {
                    operation = equation.substring(startOpIndex, i+1);
                    listOfOperations.add(operation);
                } else {
                    startOpIndex = i;
                }
            }
        }
        return listOfOperations;
    }

    private String equateOperation(String operation) {
        int answer = Integer.parseInt(operation.substring(1,2));
        String[] stringArray = operation.substring(1, operation.length()).split(" ");
        for (int i = 1; i < stringArray.length - 1; i+=2) {
            if (stringArray[i].contains("+")) {
                if(stringArray[i+1].contains(")")) {
                    answer += Integer.parseInt(stringArray[i+1].substring(0,1));
                } else {
                    answer += Integer.parseInt(stringArray[i+1]);
                }
            } else if (stringArray[i].contains("*")) {
                if(stringArray[i+1].contains(")")) {
                    answer = answer * Integer.parseInt(stringArray[i+1].substring(0,1));
                } else {
                    answer = answer * Integer.parseInt(stringArray[i+1]);
                }
            }
        }
        return String.valueOf(answer);
    }

    private int sumEquations(ArrayList<String> equationSplitIntoList) {
        String equation = "";
        ArrayList<String> copyOfEquationList = new ArrayList<>(equationSplitIntoList.size());
        for (int i = 0; i < equationSplitIntoList.size(); i++) {
            copyOfEquationList.add(equationSplitIntoList.get(i));
        }
        for (int i = 0; i < equationSplitIntoList.size(); i++) {
            if (equationSplitIntoList.get(i).contains("(")) {
                copyOfEquationList.set(i, equateOperation(equationSplitIntoList.get(i)));
            }
        }
        for (int i = 0; i < copyOfEquationList.size(); i++) {
            equation += " " + copyOfEquationList.get(i);
        }
        equation = equation.trim();
        String[] stringArray = equation.split(" ");
        int answer = Integer.parseInt(stringArray[0]);
        for (int i = 1; i < stringArray.length - 1; i+=2) {
            if (stringArray[i].contains("+")) {
                answer += Integer.parseInt(stringArray[i+1]);
            } else if (stringArray[i].contains("*")) {
                answer = answer * Integer.parseInt(stringArray[i+1]);
            }
        }
        return answer;
    }
}
