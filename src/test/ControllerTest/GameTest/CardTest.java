package test.ControllerTest.GameTest;

import Controller.Game.*;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void testCardCreation() {
        Card card = new Card(136, "s");
        Assert.assertEquals("As", card.toString());
    }


}
