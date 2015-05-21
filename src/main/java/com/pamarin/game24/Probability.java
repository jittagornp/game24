/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.game24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jittagornp
 */
public class Probability {

    private static interface Callback {

        void call(String element);
    }

    private boolean contains(List<String> elements, String target) {
        for (String el : elements) {
            if (!target.contains(el)) {
                return false;
            }
        }

        return true;
    }

    private void walking(String topElement, List<String> elements, int index, Callback callback) {
        if (index < 0) {
            callback.call(topElement);
            return;
        }

        for (String element : elements) {
            walking(topElement + element, elements, index - 1, callback);
        }
    }

    public List<String> findAll(final List<String> elements, int size) {
        final List<String> results = new ArrayList<>();
        walking("", elements, size - 1, new Callback() {

            @Override
            public void call(String element) {
                results.add(element);
            }
        });

        return results;
    }

    public List<String> findAll(final List<String> elements) {
        return findAll(elements, elements.size());
    }

    public List<String> findUnique(final List<String> elements) {
        List<String> alls = findAll(elements);
        Iterator<String> iterator = alls.iterator();
        while (iterator.hasNext()) {
            if (!contains(elements, iterator.next())) {
                iterator.remove();
            }
        }

        return alls;
    }
}
