package src.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Gra {
    public String secretWord;
    private int lives;
    private char[] guessedState;
    private Set<Character> usedLetters;
    private int wonNumber;

    public Gra(String word){
        this.secretWord = word.toUpperCase();
        this.lives =9;
        this.guessedState = new char[word.length()];
        Arrays.fill(guessedState,'_');
        this.usedLetters = new HashSet<>();
    }
    public boolean guessLetter(char letter){
        letter = Character.toUpperCase(letter);
        if(usedLetters.contains(letter)){
            System.out.println("Litera zostala juz podana, sprobuj jeszcze raz.");
            return false;
        }
        usedLetters.add(letter);
        boolean isFound = false;
        for(int i=0;i<secretWord.length();i++){
            if(secretWord.charAt(i) == letter){
                guessedState[i] = letter;
                isFound = true;
                break;
            }
        }
        if(!isFound) lives--;
        return isFound;
    }
    public boolean isWon(){
        if(!usedLetters.contains('_')) return true;
        return false;
    }

    public int getLives(){
        return this.lives;
    }
}
