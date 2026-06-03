package src.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Gra {
    public String secretWord;
    private int lives;
    private char[] guessedState;
    final private Set<Character> usedLetters;
    private static int wonNumber;

    public Gra(String word){
        this.secretWord = word.toUpperCase();
        this.lives =9;
        this.guessedState = new char[word.length()];
        Arrays.fill(guessedState,'_');
        this.usedLetters = new HashSet<>();
    }
    public void guessLetter(char letter){
        letter = Character.toUpperCase(letter);
        if(usedLetters.contains(letter)){
            System.out.println("Litera zostala juz podana, sprobuj jeszcze raz.");
            return;
        }
        usedLetters.add(letter);
        boolean isFound = false;
        for(int i=0;i<secretWord.length();i++){
            if(secretWord.charAt(i) == letter){
                guessedState[i] = letter;
                isFound = true;
            }
        }
        if(!isFound) lives--;
    }
    public boolean isWon(){
        if(!usedLetters.contains('_')){
            System.out.println("Wygrałeś partię, stan pozostalych wygranych: "+ Gra.getWonNumber());
            return true;
        }
        return false;
    }
    public boolean enterWord(String word){
        if(word.equalsIgnoreCase(secretWord)) {
            guessedState = word.toCharArray();
            return true;
        }
        return false;
    }
    public boolean isLost(){
        if(lives<=0){
            System.out.println("Gra skończona, przegrałeś");
            return true;
        }
        return false;
    }
    public int getLives(){
        return this.lives;
    }
    public void updateWinCount(){
        if (isWon()) {
            wonNumber++;
        }
    }
    public static int getWonNumber() {
        return wonNumber;
    }
}
