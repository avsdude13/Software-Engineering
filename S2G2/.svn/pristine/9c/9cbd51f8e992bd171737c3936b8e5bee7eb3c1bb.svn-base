package swefun.cardgames;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeCardRaceTest {

	/** Verify no value constructor */
	@Test
	public void threeCardRaceTest() {
		ThreeCardRace temp = new ThreeCardRace();
		
		assertEquals("Human", temp.player1);
		assertEquals("Automatron", temp.player2);
	}
	
	/** Verify constructor with values */
	@Test
	public void threeCardRaceConstructorTest() {
		ThreeCardRacePlayer playerA = new ThreeCardRacePlayer();
		ThreeCardRacePlayer playerB = new ThreeCardRacePlayer();
		
		ThreeCardRace temp = new ThreeCardRace(playerA, playerB);
		
		assertEquals(playerA, temp.player1);
		assertEquals(playerB, temp.player2);
	}

	/** Verify player choose sequence */
	@Test
	public void playerChooseSeqTest() {
		/**
		 *    Cannot test due to user input
		 */
		
	}
	
	/** Verify set name */
	@Test
	public void setNameTest(){
		/**
		 *    Cannot test due to user input
		 */
	}
	
	/** Verify ensure different sequences. */
	@Test
	public void ensureDifferentSequencesTest() {
		ThreeCardRace temp = new ThreeCardRace();
		
        List<String> seq1 = new ArrayList<String>();
        seq1.add("red");
        seq1.add("red");
        seq1.add("red");
         
        List<String> seq2 = new ArrayList<>();
        seq2.add("black");
        seq2.add("black");
        seq2.add("black");
        
        assertTrue(temp.ensureDifferentSequences(seq1, seq1));
        assertFalse(temp.ensureDifferentSequences(seq1, seq2));
    }
}
