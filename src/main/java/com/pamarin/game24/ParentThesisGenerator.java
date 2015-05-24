/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.game24;

/**
 *
 * @author jittagornp
 */
public class ParentThesisGenerator {

    private static boolean isSingle(String str) {
        return str.matches("^(\\([\\d]{2}\\)).*|.*(\\([\\d]{2}\\))$");
    }

    private static boolean invalid(String str) {
        return str.matches(".*\\([\\d]\\).*");
    }

    private static void generate(int n, int opened, int closed, String print, int index) {
        if (opened < n) {
            generate(n, opened + 1, closed, print + "(" + index, (index + 1));
        }

        if (closed < opened) {
            generate(n, opened, closed + 1, print + "" + index + ")", (index + 1));
        }

        if (opened == closed && opened == n) {
            if (!isSingle(print)) {
                for (int i = 0; i <= 5; i++) {
                    String replace = print.replace(i + "", "");
                    if (!invalid(replace)) {
                        System.out.println(replace.substring(1, replace.length() - 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        generate(2, 0, 0, "", 0);
    }
}
