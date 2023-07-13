package test.ControllerTest.GameTest;

import Controller.Game.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void testGerarMao() {
        // Test case 1: Testing when cartas length is not 2
        String[] cartas1 = {"A", "T", "5"};
        Player player1 = new Player(0, 0, null, cartas1, 20);
        assertEquals("", player1.gerarMao(cartas1));
    
        // Test case 2: Testing when cartas are of the same value
        String[] cartas2 = {"Th", "Tc"};
        Player player2 = new Player(0, 0, null, cartas2,20);
        assertEquals("TT", player2.gerarMao(cartas2));
    
        // Test case 3: Testing when cartas have the same suit
        String[] cartas3 = {"Jd", "Qd"};
        Player player3 = new Player(0, 0, null, cartas3,20);
        assertEquals("JQs", player3.gerarMao(cartas3));
    
        // Test case 4: Testing when cartas have different values and suits
        String[] cartas4 = {"5s", "9c"};
        Player player4 = new Player(0, 0, null, cartas4,20);
        assertEquals("59o", player4.gerarMao(cartas4));
    }
    

}
