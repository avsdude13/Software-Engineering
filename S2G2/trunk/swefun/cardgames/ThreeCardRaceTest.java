package swefun.cardgames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ThreeCardRaceTest {

	private ThreeCardRacePlayer playerA = new ThreeCardRacePlayer();
	private ThreeCardRacePlayer playerB = new ThreeCardRacePlayer();
	private HashMap<ThreeCardRacePlayer,Integer> playerScoreMap = new HashMap<ThreeCardRacePlayer,Integer>();
	private ThreeCardRace tempFull = new ThreeCardRace(playerA, playerB);
	private ThreeCardRace tempEmpty = new ThreeCardRace();

	/** Verify no value constructor */
	@Test
	public void threeCardRaceTest() {
		assertNotNull(tempEmpty);
	}
	
	/** Verify constructor with values */
	@Test
	public void threeCardRaceConstructorTest() {
		assertNotNull(tempFull);
	}

	/** Verify the play game method. */
	@Test
	public void playGameTest() {
		
	}
	
	
	/** Verify set name */
	@Test
	public void setNameTest(){
		/**
		 *    Cannot test due to user input
		 */
	}
	
	/** Verify check player human */
	@Test
	public void checkPlayerHumanTest(){
		assertFalse(tempEmpty.checkPlayerHuman("simulate"));
		assertTrue(tempEmpty.checkPlayerHuman("human"));
	}
	
	/** Verify player choose sequence */
	@Test
	public void playerChooseSeqTest() {
		/**
		 *    Cannot test due to user input
		 */
	}
	
	/** Verify ensure different sequences. */
	@Test
	public void ensureDifferentSequencesTest() {
		List<String> seq1 = new ArrayList<String>();
        seq1.add("red");
        seq1.add("red");
        seq1.add("red");
         
        List<String> seq2 = new ArrayList<>();
        seq2.add("black");
        seq2.add("black");
        seq2.add("black");
        
        assertFalse(tempEmpty.ensureDifferentSequences(seq1, seq1));
        assertTrue(tempEmpty.ensureDifferentSequences(seq1, seq2));
    }
	
	/** Verify wait method */
	@Test
	public void waitTest() {
		/**
		 *   no testing needed
		 */
	}
	
	/** Verify determine winner method */
	@Test
	public void determineWinnerTest(){
		playerScoreMap.put(playerA, 3);
        playerScoreMap.put(playerB, 0);
        
		assertEqual(tempFull.determineWinner(playerScoreMap), playerA);	
	}
	
	/** Verify determine tie */
	@Test
	public void determineTieTest(){
		playerScoreMap.put(playerA, 3);
        playerScoreMap.put(playerB, 3);
        
		assertTrue(tempFull.determineTie(playerScoreMap));
	}
}
