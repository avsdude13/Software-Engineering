package swefun.cardgames;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import swefun.cardgames.playingcards.*;
import java.util.concurrent.TimeUnit;

import swefun.cardgames.GameRunner;
import swefun.cardgames.ThreeCardRacePlayer;
import java.util.concurrent.TimeUnit;

import static swefun.cardgames.GameRunner.version;

/**
 * Driver for the Three-Card Race game.
 *
 * <P>The three-card race game is a two-player contest (players A and B).
 * The game is played with a standard 52-card deck.
 * Only the color of the cards, red or black, is significant;
 *     ranks do not matter.</P>
 *
 * Play of the game:
 * <OL>
 * <LI>Player A designates a length-three sequence indicating the colors
 *     of three sequential cards (sequence A).</LI>
 * <LI>Player B designates a length-three sequence indicating the colors
 *     of three sequential cards (sequence B).</LI>
 * <LI>The deck is suffled.</LI>
 * <LI>Cards are dealt face up one at a time from the deck
 *     until three sequential cards are revealed whose colors
 *     exactly match a designated sequence (A or B).
 *     The player whose sequence was matched earns a point
 *     ("takes the trick") and all dealt cards are discarded.</LI>
 * <LI>The game continues by repeating the previous step
 *     until the deck is exhausted.</LI>
 * <LI>The player with the highest point total (greatest number of
 *     tricks taken) wins the game.</LI>
 * </OL>
 * @group S2G2
 * @authors Mark Huntington, Matt Kline, Aaron Loomis, Guillermo Martinez
 * @version 1.1 $Id: ThreeCardRace.java 484 S2G2 $
 */

public class ThreeCardRace extends GameRunner {
    /** Color constants for this game. */
    public static final Set<String> COLORS = new HashSet<>();
    /** Number of suit colors required for three card race game. */
    public static final int NUM_COLORS = 2;
    /** Length of color sequence. */
    public static final int SEQUENCE_LENGTH = 3;
    /** Number of players in this game. */
    public static final int NUM_PLAYERS = 2;
    static List<String> seq1 = new ArrayList<String>(3);
    static List<String> seq2 = new ArrayList<String>(3);
    static Scanner keyboard;
    static boolean isHuman;
    static ThreeCardRacePlayer player1;
    static ThreeCardRacePlayer player2;


    static {
        for (Suit s : Suit.values()) {
            COLORS.add(s.color());
        }
    }

    /**
     * Construct Three Card Game Runner.
     * Creates one interactive player and one non-interactive player.
     * Uses colors from Suit.
     */
    public ThreeCardRace() {
        this(new ThreeCardRacePlayer("Human", true),
                new ThreeCardRacePlayer("Automaton", false));
    }

    /**
     * Construct Three Card Game Runner.
     * Uses colors from Suit; exits if invalid number of suit colors.
     * @param playerA the first player
     * @param playerB the second player
     */
    public ThreeCardRace(final ThreeCardRacePlayer playerA,
                         final ThreeCardRacePlayer playerB) {
        ThreeCardRace.player1 = playerA;
        ThreeCardRace.player2 = playerB;
    }

    /**
     * Play one game and report results.
     *
     * @param showTrace if true, then the method displays each card dealt
     *                  and identifies tricks as they are taken
     * @return map that associates each player with the number
     *         of tricks taken by that player
     */
    //Full game simulation below that returns the scoreboard
    public HashMap<ThreeCardRacePlayer, Integer> playGame(final boolean showTrace,HashMap<ThreeCardRacePlayer,Integer> playerScoreMap) {

        int matchCounter = 0;
        ArrayList<Card>tempCardList = new ArrayList<>(52);
        ArrayList<String>lastThreeCards = new ArrayList<>(52);
        ArrayList<String>cardColor = new ArrayList<>(52);
        Integer player1Score = 0;
        Integer player2Score = 0;
        Deck deck = new Deck();
        int deckSize = deck.size();
        int j=0;

        System.out.println("\n");
        deck.shuffle();
        for(int i = 0; i < deckSize; i ++){
            tempCardList.add(deck.deal());
            cardColor.add(tempCardList.get(i).suit().color());
        }
        if(showTrace == true) {
            for (int i = 0;i < deckSize; i++) {
                j++;
                lastThreeCards.add(tempCardList.get(i).suit().color());
                System.out.print(tempCardList.get(i)+":"+"\t");
                System.out.println(cardColor.get(i));
                wait(1);

                //CheckFor sequence match
                if (lastThreeCards.equals(seq1)) {
                    System.out.println("\n");
                    System.out.println("Trick taken by "+player1);
                    System.out.println("\n");
                    player1Score += 1;
                    playerScoreMap.replace(player1, player1Score);
                    lastThreeCards.clear();
                    j=0;
                    wait(2);
                }   else if (lastThreeCards.equals(seq2)) {
                    System.out.println("\n");
                    System.out.println("Trick taken by "+player2);
                    System.out.println("\n");
                    player2Score += 1;
                    playerScoreMap.replace(player2, player2Score);
                    lastThreeCards.clear();
                    j=0;
                    wait(2);
                }   else if (2<j){
                    lastThreeCards.remove(j-3);

                    j=2;
                }

            }
        }
        if(showTrace == false){
	for (int i = 0;i < deckSize; i++) {
		j++;
	        lastThreeCards.add(tempCardList.get(i).suit().color());
                System.out.print(tempCardList.get(i)+":"+"\t");
                System.out.println(cardColor.get(i));
		
                //CheckFor sequence match
                if (lastThreeCards.equals(seq1)) {
                    System.out.println("\n");
                    System.out.println("Trick taken by "+player1);
                    System.out.println("\n");
                    player1Score += 1;
                    playerScoreMap.replace(player1, player1Score);
		    lastThreeCards.clear();
		    j=0;
                }   else if (lastThreeCards.equals(seq2)) {
                    System.out.println("\n");
                    System.out.println("Trick taken by "+player2);
                    System.out.println("\n");
                    player2Score += 1;
                    playerScoreMap.replace(player2, player2Score);
                    lastThreeCards.clear();
		    j=0;
                }   else if (2<j){
			lastThreeCards.remove(j-3);
			
			j=2;
		}
		
            }
        }
        return playerScoreMap;
    }

    public static String setName(int n){
        String name;
        System.out.println("Player "+n+": Enter Your Name:");
        keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        return name;
    }

    public static boolean checkPlayerHuman(String answer){
        if (answer.equalsIgnoreCase("simulate") || answer.equalsIgnoreCase("sim")){
            return false;
        }
        else
       return true;
    }
    public static List<String> playerChooseSeq(ThreeCardRacePlayer player){
        keyboard = new Scanner(System.in);
	List<String> cardSeq = new ArrayList<String>(SEQUENCE_LENGTH);
        System.out.println(player+" please select your desired 3 card sequence from"+
                " either RED or BLACK, ensuring to press enter between selections");
        cardSeq.add(keyboard.nextLine().toUpperCase());
        cardSeq.add(keyboard.nextLine().toUpperCase());
        cardSeq.add(keyboard.nextLine().toUpperCase());
        System.out.println(player+", you chose "+cardSeq+", is this correct?(Y/N)");
        String answer = keyboard.nextLine();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes") ){
            return cardSeq;
        }else {
            System.out.println("Sorry! Let’s try again, ");
            playerChooseSeq(player);
            return cardSeq;
        }
    }

    public static boolean ensureDifferentSequences(List<String> seq1, List<String> seq2){
        if (seq1.equals(seq2)){
            System.out.println("!!Players cannot choose the same sequence!!");
            return false;
        }
        else{
            return true;
        }
    }
    public void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep((seconds));
        } catch (Exception e) {
            e.getCause();
        }
    }
    public ThreeCardRacePlayer determineWinner(HashMap<ThreeCardRacePlayer,Integer>playerScore){
        if(playerScore.get(player1) > playerScore.get(player2)){
            return player1;
        }
        return player2;
    }

    public boolean determineTie(HashMap<ThreeCardRacePlayer,Integer>playerScore){
        if(playerScore.get(player1).equals(playerScore.get(player2))){
            System.out.println("A TIE OCCURED!!!");
            return true;
        }
        else return false;
    }
    /**
     * Sample driver for Three-Card Race game.
     * Replace as desired.
     * @param args currently ignored
     *Please remember this is all pre-refactoring*/

    public static void main(final String[] args) {
        //Game Setup
        Deck deck = new Deck();

        System.out.println("Three-Card Race [Version: " + version("$Revision: 470 $") + "]");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to simulate the game or play the game?");
        isHuman = checkPlayerHuman(keyboard.nextLine());
	String player1Name = "Computer 1";
	String player2Name = "Computer 2";
	if (isHuman == false){
			System.out.println ("Computer 1 //vs// Computer 2");
			player1 = new ThreeCardRacePlayer("Computer1",isHuman);
			player2 = new ThreeCardRacePlayer("Computer2",isHuman);
			seq1=playerChooseSeq(player1);
			seq2=playerChooseSeq(player2);
			boolean  checkSeq=ensureDifferentSequences(seq1,seq2);
			if(!checkSeq){
				//one player reselects if they have the same sequence
				System.out.println("Choose a different sequence not equal to your first sequence.");
				seq2 = playerChooseSeq(player2);
			
			}System.out.println("You chose "+seq1+" and "+seq2);
		}
         else if (isHuman == true){
	    player1Name = setName(NUM_PLAYERS-1);
            player2Name = setName(NUM_PLAYERS);
            player1 = new ThreeCardRacePlayer(player1Name,isHuman);
            player2 = new ThreeCardRacePlayer(player2Name,isHuman);
            System.out.println("Player 1 : "+player1+" /// "+ "Player 2 : "+player2);
            seq1=playerChooseSeq(player1);
            seq2=playerChooseSeq(player2);
            boolean  checkSeq=ensureDifferentSequences(seq1,seq2);
            if(!checkSeq){
                //one player reselects if they have the same sequence
                System.out.println("Choose a different sequence not equal to the other players sequence.");
                seq2 = playerChooseSeq(player2);
            }
            System.out.println(player1+" chose: "+seq1);
            System.out.println(player2+" chose: "+seq2);
            //Below this line will be code related to actually playing the game
        }

        ThreeCardRace tcrGame = new ThreeCardRace(new ThreeCardRacePlayer(player1Name,isHuman),new ThreeCardRacePlayer(player2Name,isHuman));
        HashMap<ThreeCardRacePlayer,Integer> playerScoreMap = new HashMap<ThreeCardRacePlayer,Integer>();
        playerScoreMap.put(player1,0);
        playerScoreMap.put(player2,0);
        tcrGame.playGame(isHuman,playerScoreMap);
        System.out.println("Player 1: "+playerScoreMap.get(player1)+" Player 2: "+playerScoreMap.get(player2));
        if(tcrGame.determineTie(playerScoreMap) == false) {
            System.out.println("The winner is " + tcrGame.determineWinner(playerScoreMap)
                    + " with a score of " + playerScoreMap.get(tcrGame.determineWinner(playerScoreMap)));
        }
    }
}