package odde;

import org.junit.Test;

import static odde.Braces.isValid;
import static org.junit.Assert.*;

public class BracesTest {
    @Test
    public void curlyBraces() {
        assertTrue(isValid("{}"));
    }

    @Test
    public void onlyOpenBrace() {
        assertFalse(isValid("{"));
    }

    @Test
    public void roundBraces() {
        assertTrue(isValid("()"));
    }

    @Test
    public void unacceptedBrace() {
        assertFalse(isValid("<>"));
    }

    @Test
    public void multipleBraces() {
        assertTrue(isValid("{[[()]]}"));
    }

}
