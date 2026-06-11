package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @Test
    public void poprawnyWyborGraj() {
        Menu menu = new Menu();
        assertEquals(1, menu.przetworzWybor("1"));
    }

    @Test
    public void poprawnyWyborZarzadzanieSlowami() {
        Menu menu = new Menu();
        assertEquals(2, menu.przetworzWybor("2"));
    }

    @Test
    public void poprawnyWyborWyjscie() {
        Menu menu = new Menu();
        assertEquals(3, menu.przetworzWybor("3"));
    }

    @Test
    public void blednyWyborLitera() {
        Menu menu = new Menu();
        assertEquals(-1, menu.przetworzWybor("X"));
    }

    @Test
    public void blednyWyborPozaZakresem() {
        Menu menu = new Menu();
        assertEquals(-1, menu.przetworzWybor("5"));
    }

    @Test
    public void blednyWyborPustePole() {
        Menu menu = new Menu();
        assertEquals(-1, menu.przetworzWybor(""));
    }
}
