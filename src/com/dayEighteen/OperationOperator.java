package com.dayEighteen;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OperationOperator {

    ArrayList<String> operations = new ArrayList<>();

    public void readInitialGrid() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/jamie/IdeaProjects/AdventCalendarPuzzles/out/production/AdventCalendarPuzzles/com/dayEighteen/operations.txt"
            ));
            int counter = 0;
            String line = reader.readLine();
            while (line != null) {
                operations.add(line);
                line = reader.readLine();
                counter++;
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void test() {
//        String eq_1 = "2 * 3 + (4 * 5)";
//        String eq_2 = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
//        String eq_3 = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
//        String eq_4 = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
//        String test_1 = "8 + 3 * ((3 * 7 * 3 + 4 * 5) * (6 + 8 + 9 * 7 + 6) * 9 + 5 * (5 + 4 + 4 + 4))";
//        String test_2 = "(8 * 3 + 9 + 3 * 4 * 3)";
        String eq_5 = "1 + (2 * 3) + (4 * (5 + 6))";
        ArrayList<String> listOfOp = new ArrayList<>();

        // Should print 26
//        listOfOp = splitEquationIntoList(eq_1);
//        System.out.println(sumEquations(listOfOp));

        // Should print 437
//        listOfOp = splitEquationIntoList(eq_2);
//        System.out.println(sumEquations(listOfOp));

        // Should print 12240
//        listOfOp = splitEquationIntoList(eq_3);
//        System.out.println(sumEquations(listOfOp));

        // Should print 13632
//        listOfOp = splitEquationIntoList(eq_4);
//        System.out.println(sumEquations(listOfOp));

//        listOfOp = splitEquationIntoList(test_1);
//        for (int i = 0; i < listOfOp.size(); i++) {
//            System.out.println(listOfOp.get(i));
//        }
//        System.out.println(sumEquations(listOfOp));

//        equateOperation(test_2);

        // Should print 51
        listOfOp = splitEquationIntoList(eq_5);
//        for (int i = 0; i < listOfOp.size(); i++) {
//            System.out.println(listOfOp.get(i));
//        }
        System.out.println(sumEquations(listOfOp));
    }

    public void solver() {
        long sumOfEquations = 0;
        readInitialGrid();
        ArrayList<String> listOfOp;
        for (int i = 0; i < operations.size(); i++) {
            listOfOp = splitEquationIntoList(operations.get(i));
            sumOfEquations += sumEquations(listOfOp);
        }
        System.out.println(sumOfEquations);
    }

    private ArrayList<String> splitEquationIntoList(String equation) {
        ArrayList<String> listOfOperations = new ArrayList<>();
        int opBr = 0;
        int startOpIndex = 0;
        int startOpBrIndex = 0;
        String operation = " ";
        boolean inBr = false;
        for (int i = 0; i < equation.length(); i++) {
            char character = equation.charAt(i);
            if (character == '(') {
                if (opBr == 0) {
                    startOpBrIndex = i;
                }
                inBr = true;
                opBr ++;
            } else if (character == ')') {
                opBr--;
                if (opBr == 0) {
                    if (i == equation.length() - 1) {
                        operation = equation.substring(startOpBrIndex, i+1);
                    } else {
                        operation = equation.substring(startOpBrIndex, i+3);
                        i = i + 2;
                    }
                    inBr = false;
                    listOfOperations.add(operation);
                }
            } else if (character != ' ' && opBr == 0 && !inBr) {
                if (character == '*' || character == '+') {
                    operation = equation.substring(startOpIndex, i+1);
                    listOfOperations.add(operation);
                } else {
                    startOpIndex = i;
                }
            }
            if (i == equation.length()-1 && character != ')') {
                listOfOperations.add(equation.substring(startOpIndex));
            }
        }
        return listOfOperations;
    }

    private String equateOperation(String operation) {
        long answer = 1;
        if (operation.contains("(")) {
            operation = operation.substring(1, operation.length() - 1);
        }
        String[] stringArray = operation.split(" ");

        // Part One
//        answer = Integer.parseInt(stringArray[0]);
//        for (int i = 1; i < stringArray.length - 1; i+=2) {
//            if (stringArray[i].contains("+")) {
//                answer += Long.parseLong(stringArray[i+1]);
//            } else if (stringArray[i].contains("*")) {
//                answer = answer * Long.parseLong(stringArray[i+1]);
//            }
//        }

        // Part Two
        String operationForPartTwo = "";
        String[] copyOfArr = new String[stringArray.length];
        long currentTotal = Long.parseLong(stringArray[0]) ;
        for (int i = 1; i < stringArray.length - 1; i = i+2) {
            if (stringArray[i].contains("+")) {
                currentTotal += Long.parseLong(stringArray[i+1]);
                if (i == stringArray.length-2) {
                    copyOfArr[i+1] = String.valueOf(currentTotal);
                }
            } else {
                if (i == stringArray.length-2) {
                    copyOfArr[i+1] = stringArray[i+1];
                }
                copyOfArr[i] = stringArray[i];
                copyOfArr[i-1] = String.valueOf(currentTotal);
                currentTotal = Long.parseLong(stringArray[i+1]);
            }
        }

        for (int i = 0; i < copyOfArr.length; i++) {
            if (copyOfArr[i] != null) {
                operationForPartTwo += copyOfArr[i] + " ";
            }
        }

        operationForPartTwo = operationForPartTwo.trim();
        String[] arrayWithOnlyMultipliers = operationForPartTwo.split(" ");
        for (int i = 0; i < arrayWithOnlyMultipliers.length; i = i+2 ) {
            answer = answer * Long.parseLong(arrayWithOnlyMultipliers[i]);
        }
        return String.valueOf(answer);
    }

    private String equateNestedParentheses(String equation) {
        while (2 > 1) {
            int opBr = 0;
            String value = "test";
            String operation = "";
            LinkedList<Integer> openBrQueue = new LinkedList<>();
            for (int i = 0; i < equation.length(); i++) {
                char character = equation.charAt(i);
                if (character == '(') {
                    opBr++;
                    openBrQueue.add(i);
                } else if (character == ')') {
                    operation = equation.substring(openBrQueue.pollLast(), i + 1);
                    value = equateOperation(operation);
                    opBr--;
                    break;
                }
            }
            equation = equation.replace(operation, value);
            if (opBr == 0) {
                return equation;
            }
        }
    }

    private long sumEquations(ArrayList<String> equationSplitIntoList) {
        String equation = "";
        ArrayList<String> copyOfEquationList = new ArrayList<>(equationSplitIntoList.size());
        for (int i = 0; i < equationSplitIntoList.size(); i++) {
            copyOfEquationList.add(equationSplitIntoList.get(i));
        }
        for (int i = 0; i < equationSplitIntoList.size(); i++) {
            if (equationSplitIntoList.get(i).contains("(")) {
                copyOfEquationList.set(i, equateNestedParentheses(equationSplitIntoList.get(i)));
            }
        }
        for (int i = 0; i < copyOfEquationList.size(); i++) {
            equation += " " + copyOfEquationList.get(i);
        }
        equation = equation.trim();
        return Long.parseLong(equateOperation(equation));
    }

}
