package hangmanTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import hangman.Hangman;

public class HangmanTest {

    @Test
    public void test() {
        List<String> dictionary = new ArrayList<String>();
        dictionary.add("abcdefghij");
        Hangman testObj = new Hangman(dictionary, 10, 10);

	    assertEquals(10, testObj.wrongGuessLimit());
	    assertEquals(10, testObj.guessesLeft());
	    assertNotNull(testObj.words());
		assertNull(testObj.guesses());
	    assertEquals(0, testObj.record('a'));
	    assertEquals("- - - - - - - - - - ", testObj.pattern());
	    System.out.println("Pass");
	}
}
