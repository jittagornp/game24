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

/**
 *
 * @author jittagornp
 */
public class App {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Probability prop = new Probability();

        List<String> uniqueNumbers = prop.findUnique(Arrays.asList("5", "6", "7", "4"));
        List<String> operators = prop.findAll(Arrays.asList("+", "-", "*", "/"), 3);
        
        for (String number : uniqueNumbers) {
            for (String operator : operators) {
                String numb1 = number.charAt(0) + " ";
                String oper1 = operator.charAt(0) + " ";
                String numb2 = number.charAt(1) + " ";
                String oper2 = operator.charAt(1) + " ";
                String numb3 = number.charAt(2) + " ";
                String oper3 = operator.charAt(2) + " ";
                String numb4 = number.charAt(3) + "";

                String equation = numb1 + oper1 + numb2 + oper2 + numb3 + oper3 + numb4;
                Object result = engine.eval(equation);
                System.out.print(equation);
                if (result instanceof Integer && (Integer) result == 24) {
                    System.out.print(" /");
                }
                System.out.println("");
            }
        }
    }
}
