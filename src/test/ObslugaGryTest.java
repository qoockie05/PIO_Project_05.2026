package src.test;

import org.junit.Test;
import src.main.Gra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObslugaGryTest {
    @Test
    public void nowaGraMa9ZyC(){
        Gra gra = new Gra("cos");
        assertEquals(9,gra.getLives());
    }
    @Test
    public void blednaLiteraZabieraZycie(){
        Gra gra = new Gra("cos");
        gra.guessLetter('p');
        assertEquals(8,gra.getLives());
    }
    @Test
    public void poprawnaLiteraZaaktualizujeStan(){
        Gra gra = new Gra("cos");
        gra.guessLetter('c');
        assertEquals(9, gra.getLives());
    }
    @Test
    public void duplikatNiePowinienOdjacZycia(){
        Gra gra = new Gra("cos");
        gra.guessLetter('P');
        gra.guessLetter('P');
        assertEquals(8,gra.getLives());
    }
    @Test
    public void wygranaPoOdgadnieciuWszystkichLiter(){
        Gra game = new Gra("AB");
        game.guessLetter('A');
        game.guessLetter('B');
        assertTrue(game.isWon());
    }
    @Test
    public void przegranaPoWyczerpaniuZyc() {
        Gra game = new Gra("cks");
        for (char c : "qwertyuio".toCharArray()) game.guessLetter(c);
        assertTrue(game.isLost());
    }
    @Test
    public void odgadniecieHasla(){
        Gra game = new Gra("cks");
        assertTrue(game.enterWord("cks"));
        assertTrue(game.isWon());
    }

}
