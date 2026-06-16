package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Gra {
    public String secretWord;
    private int lives;
    private char[] guessedState;
    final private Set<Character> usedLetters;
    private static int wonNumber;

    public Gra(String word) {
        this.secretWord = word.toUpperCase();
        this.lives = 9;
        this.guessedState = new char[word.length()];
        Arrays.fill(guessedState, '_');
        this.usedLetters = new HashSet<>();
    }
    public static void resetWonNumber() {
        wonNumber = 0;
    }
    public void guessLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (usedLetters.contains(letter)) {
            System.out.println("Litera " + letter+" zostala juz podana, sprobuj jeszcze raz.");
            return;
        }
        usedLetters.add(letter);
        boolean isFound = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedState[i] = letter;
                isFound = true;
            }
        }
        if (!isFound) lives--;
    }

    public boolean isWon() {
        for (char c : guessedState) {
            if (c == '_') return false;
        }
        System.out.println("Gratulacje! Odgadłeś hasło: " + secretWord.toLowerCase() +" Stan pozostałych wygranych: " +Gra.getWonNumber());
        return true;
    }

    public boolean enterWord(String word) {
        if (word.equalsIgnoreCase(secretWord)) {
            guessedState = word.toCharArray();
            return true;
        }
        return false;
    }

    public boolean isLost() {
        return lives <= 0;
    }

    public int getLives() {
        return this.lives;
    }

    public void updateWinCount() {
        if (isWon()) {
            wonNumber++;
        }
    }

    public char[] getGuessedState() {
        return this.guessedState;
    }

    public static int getWonNumber() {
        return wonNumber;
    }

    public void pokazBilans() {
        System.out.println("Bilans:");
        System.out.println("Wygrane gry: " + Gra.getWonNumber());
        System.out.println("Pozostałe życia: " + lives);
        System.out.println("Użyte litery: " + usedLetters);
    }
    public void printCurrentStateForWord(){
        System.out.println(guessedState);

    }

    public void koniec() {
        if (isWon()) {
            updateWinCount();
        } else if (isLost()) {
            System.out.println("Przegrałeś! Hasło to: " + secretWord);
        }
    }
}
