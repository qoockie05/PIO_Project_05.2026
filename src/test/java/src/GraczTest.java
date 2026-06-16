package src;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraczTest {

    @Test
    void powinnoWczytacPoprawnyNick() {
        String dane = "Alicja\n";
        System.setIn(new ByteArrayInputStream(dane.getBytes()));
        Gracz gracz = new Gracz();
        gracz.wczytajNick();
        assertEquals("Alicja", gracz.getNick());
    }

    @Test
    void powinnoOdrzucicPustyNick() {
        String dane = "\nKasia\n";
        System.setIn(new ByteArrayInputStream(dane.getBytes()));
        Gracz gracz = new Gracz();
        gracz.wczytajNick();
        assertEquals("Kasia", gracz.getNick());
    }

    @Test
    void powinnoUsunacSpacjeZNicka() {
        String dane = "   Natalia   \n";
        System.setIn(new ByteArrayInputStream(dane.getBytes()));
        Gracz gracz = new Gracz();
        gracz.wczytajNick();
        assertEquals("Natalia", gracz.getNick());
    }
}