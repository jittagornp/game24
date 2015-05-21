/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.game24;

import java.util.Arrays;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jittagornp
 */
public class App {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Probability prop = new Probability();

        List<String> inputs = Arrays.asList("9", "8", "1", "3");
                
        List<String> uniqueNumbers = prop.findUnique(inputs);
        List<String> operators = prop.findAll(Arrays.asList("+", "-", "*", "/"), 3);
        List<String> parenthesis = Arrays.asList(
                "((AxB)yC)zD",
                "(AxB)y(CzD)",
                "(Ax(ByC))zD",
                "Ax((ByC)zD)",
                "Ax(By(CzD))"
        );

        System.out.println("Game 24 (" + StringUtils.join(inputs, ",")+ ")");
        System.out.println("----------------------");
        int resultCount = 1;
        for (String number : uniqueNumbers) {
            for (String operator : operators) {
                for (String bracket : parenthesis) {
                    String numb1 = number.charAt(0) + "";
                    String oper1 = operator.charAt(0) + "";
                    String numb2 = number.charAt(1) + "";
                    String oper2 = operator.charAt(1) + "";
                    String numb3 = number.charAt(2) + "";
                    String oper3 = operator.charAt(2) + "";
                    String numb4 = number.charAt(3) + "";

                    String equation = bracket
                            .replace("A", numb1)
                            .replace("B", numb2)
                            .replace("C", numb3)
                            .replace("D", numb4)
                            .replace("x", oper1)
                            .replace("y", oper2)
                            .replace("z", oper3);

                    Object result = engine.eval(equation);
                    if (result instanceof Integer && (Integer) result == 24) {
                        System.out.println(resultCount++ + ". " + equation);
                    }
                }
            }
        }
    }
}
