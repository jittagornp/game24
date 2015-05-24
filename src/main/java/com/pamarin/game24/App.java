/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.game24;

import java.util.List;

/**
 *
 * @author jittagornp
 */
public class App {

    public static void main(String[] args) {
        String numbers = "1234";
        System.out.println("Game 24 (" + numbers + ")");
        System.out.println("----------------------");

        List<String> equations = Equations
                .withAnswer(24)
                .andNumbers(numbers)
                .get();

        for (int i = 0; i < equations.size(); i++) {
            System.out.println((i + 1) + ". " + equations.get(i));
        }
    }
}
