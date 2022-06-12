package test;

import org.junit.Before;
import org.junit.Test;

import main.java.DictionaryCheck;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryCheckTest {

    private static String input;
    DictionaryCheck dictionaryCheck;

    @Before
    public void setUp() {
        dictionaryCheck = new DictionaryCheck();
    }

    @Test
    public void testUserInputCaseSensitive() {
        assertEquals(2, dictionaryCheck.countMatches("cat", "aCatsdfgcatcatalogcvbof", "y"));
    }

    @Test
    public void testUserInputNotCaseSensitive() {
        assertEquals(3, dictionaryCheck.countMatches("CAT", "aCatsdfgcatcatalogcvbof", "n"));
    }
}
