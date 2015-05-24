/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pamarin.game24.Probability;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author jittagornp
 */
public class ProbabilityTest {

    @Test
    public void allOf2ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B")
                .find();

        List<String> results = Arrays.asList(
                "A:A",
                "A:B",
                "B:A",
                "B:B"
        );

        assertEquals(probs, results);
    }

    @Test
    public void allOf3ElementsSize3() {
        List<String> probs = Probability
                .ofElements("A", "B", "C")
                .find();

        List<String> results = Arrays.asList(
                "A:A:A",
                "A:A:B",
                "A:A:C",
                "A:B:A",
                "A:B:B",
                "A:B:C",
                "A:C:A",
                "A:C:B",
                "A:C:C",
                "B:A:A",
                "B:A:B",
                "B:A:C",
                "B:B:A",
                "B:B:B",
                "B:B:C",
                "B:C:A",
                "B:C:B",
                "B:C:C",
                "C:A:A",
                "C:A:B",
                "C:A:C",
                "C:B:A",
                "C:B:B",
                "C:B:C",
                "C:C:A",
                "C:C:B",
                "C:C:C"
        );

        assertEquals(probs, results);
    }

    @Test
    public void distinctOf2ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B")
                .distinct()
                .find();

        List<String> results = Arrays.asList(
                "A:B",
                "B:A"
        );

        assertEquals(probs, results);
    }

    @Test
    public void distinctOf3ElementsSize3() {
        List<String> probs = Probability
                .ofElements("A", "B", "C")
                .distinct()
                .find();

        List<String> results = Arrays.asList(
                "A:B:C",
                "A:C:B",
                "B:A:C",
                "B:C:A",
                "C:A:B",
                "C:B:A"
        );

        assertEquals(probs, results);
    }

    @Test
    public void distinctOf4ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B", "C", "D")
                .distinct()
                .size(2)
                .find();

        List<String> results = Arrays.asList(
                "A:B",
                "A:C",
                "A:D",
                "B:A",
                "B:C",
                "B:D",
                "C:A",
                "C:B",
                "C:D",
                "D:A",
                "D:B",
                "D:C"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueOf2ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B")
                .unique()
                .find();

        List<String> results = Arrays.asList(
                "A:A",
                "A:B",
                "B:B"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueOf3ElementsSize3() {
        List<String> probs = Probability
                .ofElements("A", "B", "C")
                .unique()
                .find();

        List<String> results = Arrays.asList(
                "A:A:A",
                "A:A:B",
                "A:A:C",
                "A:B:B",
                "A:B:C",
                "A:C:C",
                "B:B:B",
                "B:B:C",
                "B:C:C",
                "C:C:C"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueAndDistinctOf2ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B")
                .distinct()
                .unique()
                .find();

        List<String> results = Arrays.asList(
                "A:B"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueAndDistinctOf3ElementsSize3() {
        List<String> probs = Probability
                .ofElements("A", "B", "C")
                .distinct()
                .unique()
                .find();

        List<String> results = Arrays.asList(
                "A:B:C"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueAndDistinctOf3ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B", "C")
                .distinct()
                .unique()
                .size(2)
                .find();

        List<String> results = Arrays.asList(
                "A:B",
                "A:C",
                "B:C"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueAndDistinctOf4ElementsSize2() {
        List<String> probs = Probability
                .ofElements("A", "B", "C", "D")
                .distinct()
                .unique()
                .size(2)
                .find();

        List<String> results = Arrays.asList(
                "A:B",
                "A:C",
                "A:D",
                "B:C",
                "B:D",
                "C:D"
        );

        assertEquals(probs, results);
    }

    @Test
    public void uniqueAndDistinctOf4ElementsSize3() {
        List<String> probs = Probability
                .ofElements("A", "B", "C", "D")
                .distinct()
                .unique()
                .size(3)
                .find();

        List<String> results = Arrays.asList(
                "A:B:C",
                "A:B:D",
                "A:C:D",
                "B:C:D"
        );

        assertEquals(probs, results);
    }
}
