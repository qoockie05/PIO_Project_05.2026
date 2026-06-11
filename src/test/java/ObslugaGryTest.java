
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ObslugaGryTest {
    @BeforeEach
    public void reset() {
        Gra.resetWonNumber();
    }
    @BeforeEach
    public void print() {
        System.out.println();
    }
    @Test
    public void nowaGraMa9ZyC(){
        Gra gra = new Gra("cos");
        assertEquals(9,gra.getLives());
        gra.koniec();
    }
    @Test
    public void blednaLiteraZabieraZycie(){
        Gra gra = new Gra("cos");
        gra.guessLetter('p');
        assertEquals(8,gra.getLives());
        gra.koniec();
    }
    @Test
    public void poprawnaLiteraZaaktualizujeStan(){
        Gra gra = new Gra("cos");
        gra.guessLetter('c');
        assertEquals(9, gra.getLives());
        gra.koniec();
    }
    @Test
    public void duplikatNiePowinienOdjacZycia(){
        Gra gra = new Gra("cos");
        gra.guessLetter('P');
        gra.guessLetter('P');
        assertEquals(8,gra.getLives());
        gra.koniec();
    }
    @Test
    public void wygranaPoOdgadnieciuWszystkichLiter(){
        Gra game = new Gra("AB");
        game.guessLetter('A');
        game.guessLetter('B');
        assertTrue(game.isWon());
        game.koniec();
    }
    @Test
    public void przegranaPoWyczerpaniuZyc() {
        Gra game = new Gra("cks");
        for (char c : "qwertyuio".toCharArray()) game.guessLetter(c);
        assertTrue(game.isLost());
        game.koniec();
    }
    @Test
    public void odgadniecieHasla(){
        Gra game = new Gra("cks");
        assertTrue(game.enterWord("cks"));
        assertTrue(game.isWon());
        game.koniec();
    }
    @Test
    public void iloscWygranychGierWynosi2(){
        Gra game1 = new Gra("cks");
        game1.enterWord("cks");
        game1.updateWinCount();
        Gra game2 = new Gra("ol");
        game2.enterWord("ol");
        game2.updateWinCount();
        assertEquals(2, Gra.getWonNumber());
        game1.koniec();
        game2.koniec();
    }
    @Test
    public void poczatkowyStanSamePodkreslenia() {
        Gra gra = new Gra("kot");
        char[] stan = gra.getGuessedState();
        assertArrayEquals(new char[]{'_', '_', '_'}, stan);
        gra.koniec();
    }

    @Test
    public void stanAktualizujeSiePoPoprawnejLiterze() {
        Gra gra = new Gra("kot");
        gra.guessLetter('k');
        assertEquals('K', gra.getGuessedState()[0]);
        assertEquals('_', gra.getGuessedState()[1]);
        gra.koniec();
    }

    @Test
    public void stanNieZmieniasiePoBlednejLiterze() {
        Gra gra = new Gra("kot");
        gra.guessLetter('z');
        assertArrayEquals(new char[]{'_', '_', '_'}, gra.getGuessedState());
        gra.koniec();
    }
    //jeden test dla poakz bilans w celu sprawdzenia czy sie wypisuje
    @Test
    public void wypisanieBilansu(){
        Gra gra = new Gra("kot");
        gra.guessLetter('k');
        gra.pokazBilans();
        gra.koniec();
    }
    @Test
    public void koniecIZwiekszenieLicznikaPrzyWygranej() {
        int poprzedni = Gra.getWonNumber();
        Gra gra = new Gra("ab");
        gra.guessLetter('a');
        gra.guessLetter('b');
        gra.koniec();
        assertEquals(poprzedni + 1, Gra.getWonNumber());
    }

    @Test
    public void koniecINieZwiekszenieLicznikaPrzyWygranej() {
        int poprzedni = Gra.getWonNumber();
        Gra gra = new Gra("ab");
        for (char c : "cdefghijk".toCharArray()) gra.guessLetter(c);
        gra.koniec();
        assertEquals(poprzedni, Gra.getWonNumber());
    }

    @Test

    public void wpisanieDanegoPostepuWZgadywance(){
        Gra gra = new Gra("koteczek");
        gra.guessLetter('e');
        gra.printCurrentStateForWord();
        gra.koniec();
    }
}
