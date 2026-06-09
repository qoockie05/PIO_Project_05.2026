package src;

import org.junit.jupiter.api.Test;
import src.Menu;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @Test
    public void poprawnyWyborGraj() {
        Menu menu = new Menu();
        assertEquals(1, menu.parseChoice("1"));
    }

    @Test
    public void poprawnyWyborZarzadzanieSlowami() {
        Menu menu = new Menu();
        assertEquals(2, menu.parseChoice("2"));
    }

    @Test
    public void poprawnyWyborWyjscie() {
        Menu menu = new Menu();
        assertEquals(3, menu.parseChoice("3"));
    }

    @Test
    public void blednyWyborLitera() {
        Menu menu = new Menu();
        assertEquals(-1, menu.parseChoice("X"));
    }

    @Test
    public void blednyWyborPozaZakresem() {
        Menu menu = new Menu();
        assertEquals(-1, menu.parseChoice("5"));
    }

    @Test
    public void blednyWyborPustePole() {
        Menu menu = new Menu();
        assertEquals(-1, menu.parseChoice(""));
    }
}
