import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WisielecTest {
    @Test
    public void pelnyWisielec0Zyc() {
        Wisielec wisielec = new Wisielec();
        String result = wisielec.rysujWisielca(0);
        assertTrue(result.contains("O"));
        assertTrue(result.contains("/|\\"));
        assertTrue(result.contains("/ \\"));
    }
    @Test
    public void pustyWisielec9Zyc(){
        Wisielec wisielec = new Wisielec();
        String result = wisielec.rysujWisielca(9);
        assertTrue(result.contains("|"));
        assertFalse(result.contains("O"));
        assertFalse(result.contains("/|\\"));
        assertFalse(result.contains("/ \\"));
    }
    @Test
    public void nieprawidlowaWartoscZyc(){
        Wisielec wisielec = new Wisielec();
        String result = wisielec.rysujWisielca(-1);
        assertFalse(result.contains("|"));
        assertFalse(result.contains("O"));
        assertFalse(result.contains("/|\\"));
        assertFalse(result.contains("/ \\"));
    }
    @Test
    public void wisielec8Zyc() {
        Wisielec wisielec = new Wisielec();
        String wynik = wisielec.rysujWisielca(8);
        assertTrue(wynik.contains("O"));
        assertFalse(wynik.contains("|  |"));
    }
}
