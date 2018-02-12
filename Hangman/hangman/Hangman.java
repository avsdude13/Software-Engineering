package hangman;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * This project runs the hangman game.
 * @author Matt Kline
 */
public class Hangman implements HangmanManager {
    /** dictionary takes a file to define the word choices. */
    private List<String> dictionary = new ArrayList<String>();

    /** words define all dictionary items that fit the length restriction. */
    private Set<String> words = new HashSet<String>();

    /** guesses to be used in tracking user guesses/. */
    private SortedSet<Character> guesses = new TreeSet<Character>();

    /** length of the word that is chosen. */
    private final int length;

    /** wrongGuessLimit is the amount of incorrect guesses allowed. */
    private final int wrongGuessLimit;

    /** incorrectGuessCounter is the counter for missed guesses. */
    private int incorrectGuessCounter;

    /**
     * Constructor.
     * @param dictionaryInput takes a file to define the word choices used.
     * @param lengthInput defines the length of the word to be chosen
     * @param wrongGuessLimitInput defines the number of incorrect guesses
     */
    public Hangman(final List<String> dictionaryInput,
                   final int lengthInput,
                   final int wrongGuessLimitInput) {
        this.dictionary = dictionaryInput;
        this.length = lengthInput;
        this.wrongGuessLimit = wrongGuessLimitInput;
        this.incorrectGuessCounter = 0;
    }

    /**
     * Access the set of candidate words;
     *     if size == 1, contents are the actual goal word.
     * @return the goal word or the candidate goal words
     */
    public Set<String> words() {
        for (int index = 0; index < dictionary.size(); index++) {
            if (dictionary.get(index).length() == this.length) {
                words.add(dictionary.get(index));
            }
        }
        return words;
    }

    /**
     * Access the limit on wrong guesses.
     * @return the number of wrong guesses that results in a player loss
     */
    public int wrongGuessLimit() {
        return this.wrongGuessLimit;
    }

    /**
     * Access the number of wrong guesses that result in a loss
     *     for the player given the current state of the game.
     * @return the number of wrong guesses that would result in a loss
     */
    public int guessesLeft() {
        return this.wrongGuessLimit - incorrectGuessCounter;
    }

    /**
     * Access the set of letters already guessed by the player.
     * @return the set of letters guessed by the player
     */
    public SortedSet<Character> guesses() {
        return guesses;
    }

    /**
     * Return the hangman-style display pattern of letters and dashes
     * (with interpolated spaces) appropriate to the current state
     * based on the letters already guessed and the goal.
     * PATTERN GENERATOR
     * @throws IllegalStateException if there is no goal word
     * @return the hangman-style pattern to be displayed to the user
     */
    public String pattern() {
        String word = words.iterator().next();
        String patternCreated = "";
        PatternCreater generatePattern = (pattern, symbol) ->
                                                  pattern + symbol + " ";

        for (int wordIndex = 0; wordIndex < this.length; wordIndex++) {
            if (guesses.contains(words.iterator().next().charAt(wordIndex))) {
                patternCreated = generatePattern
                              .pattern(patternCreated, word.charAt(wordIndex));
            } else {
                patternCreated = generatePattern.pattern(patternCreated, '-');
            }
        }
        return patternCreated;
    }

    /**
     * This is the interface for use with the lambdas for the pattern method
     */
    private interface PatternCreater {
        /**
         * Lambda for creating the pattern sequence.
         * @param pattern takes the existing pattern
         * @param symbol takes either the letter guessed correctly or dash
         * @return pattern for the word being guessed.
         */
        String pattern(String pattern, char symbol);
    }

    /**
     * Record state changes based on new letter guess.
     * @throws IllegalStateException if no guesses left or no goal word
     * @throws IllegalArgumentException if letter is already guessed
     * @param guess the letter being guessed
     *   [Precondition: guess must be lower-case letter]
     *   [Precondition: guess must not be among letters already guessed]
     * @return the number of occurrences of the guessed letter in the goal
     */
    public int record(final char guess) {
        int count = 0;
        String word = words.iterator().next();
        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) == guess) {
                count++;
            }
        }
        if (count == 0) {
            this.incorrectGuessCounter++;
        }
        guesses.add(guess);
        return count;
    }
}
