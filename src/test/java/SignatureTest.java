
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jittagornp
 */
public class SignatureTest {

    private String findSignature(String str) {
        String[] els = StringUtils.split(str, ":");
        Arrays.sort(els);
        return StringUtils.join(els, ":");
    }

    @Test
    public void findSignature() {
        assertEquals("A:B:C:D", findSignature("B:A:C:D"));
        assertEquals("A:B:C:D", findSignature("C:A:B:D"));
        assertEquals("A:B:C:D", findSignature("D:A:C:B"));
        assertEquals("A:B:C:D", findSignature("D:B:C:A"));
        assertEquals("A:B:C:D", findSignature("A:B:C:D"));
        assertEquals("A:B:C:D", findSignature("D:B:A:C"));
    }
}
