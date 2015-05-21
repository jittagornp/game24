/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.game24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author jittagornp
 */
public class Game24 {

    private static final int ANSWER = 24;
    private static ScriptEngine engine;

    private static ScriptEngine getEngine() {
        if (engine == null) {
            ScriptEngineManager manager = new ScriptEngineManager();
            engine = manager.getEngineByName("js");

        }

        return engine;
    }

    private static List<String> toList(String str) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            results.add(str.charAt(i) + "");
        }

        return results;
    }

    private static String toEquation(String number, String operator, String bracket) {
        String numb1 = number.charAt(0) + "";
        String oper1 = operator.charAt(0) + "";
        String numb2 = number.charAt(1) + "";
        String oper2 = operator.charAt(1) + "";
        String numb3 = number.charAt(2) + "";
        String oper3 = operator.charAt(2) + "";
        String numb4 = number.charAt(3) + "";

        return bracket
                .replace("A", numb1)
                .replace("B", numb2)
                .replace("C", numb3)
                .replace("D", numb4)
                .replace("x", oper1)
                .replace("y", oper2)
                .replace("z", oper3);
    }

    private static Integer execute(String equation) {
        try {
            Object result = getEngine().eval(equation);
            if (result instanceof Integer) {
                return (Integer) result;
            }
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public static List<String> getEquations(String str) {
        Probability prop = new Probability();

        List<String> uniqueNumbers = prop.findUnique(toList(str));
        List<String> operators = prop.findAll(Arrays.asList("+", "-", "*", "/"), 3);
        List<String> brackets = Arrays.asList(
                "((AxB)yC)zD",
                "(AxB)y(CzD)",
                "(Ax(ByC))zD",
                "Ax((ByC)zD)",
                "Ax(By(CzD))"
        );

        List<String> results = new ArrayList<>();
        for (String number : uniqueNumbers) {
            for (String operator : operators) {
                for (String bracket : brackets) {
                    String equation = toEquation(number, operator, bracket);
                    Integer result = execute(equation);
                    if (result == ANSWER) {
                        results.add(equation);
                    }
                }
            }
        }

        return results;
    }
}
