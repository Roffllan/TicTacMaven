package Test;
import java.io.IOException;
import main.TicTacToeMaven;
import main.TicTacToeMaven.GameXO.Players;
import org.junit.Assert;
import org.junit.Test;

public class TicTacToeMavenTest {
    public TicTacToeMavenTest() {
    }

    @Test
    public void testAddTic() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharX(0, 0);
        addChar.addCharX(0, 1);
        addChar.addCharX(0, 2);
        Assert.assertEquals(Players.X, addChar.getState(0, 0));
        Assert.assertEquals(Players.X, addChar.getState(0, 1));
        Assert.assertEquals(Players.X, addChar.getState(0, 2));
        Assert.assertEquals(Players.emp, addChar.getState(1, 1));
    }

    @Test
    public void testAddTac() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharO(2, 0);
        addChar.addCharO(2, 1);
        addChar.addCharO(2, 2);
        Assert.assertEquals(Players.O, addChar.getState(2, 0));
        Assert.assertEquals(Players.O, addChar.getState(2, 1));
        Assert.assertEquals(Players.O, addChar.getState(2, 2));
        Assert.assertEquals(Players.emp, addChar.getState(1, 2));
    }

    @Test
    public void testRemove() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharX(2, 0);
        addChar.addCharO(2, 1);
        addChar.addCharX(2, 2);
        Assert.assertEquals(Players.emp, addChar.cleaner(2, 0));
        Assert.assertEquals(Players.emp, addChar.cleaner(2, 1));
        Assert.assertEquals(Players.emp, addChar.cleaner(2, 2));
    }

    @Test
    public void longestDiagonalTic() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharX(0, 0);
        addChar.addCharX(0, 2);
        addChar.addCharO(0, 1);
        addChar.addCharO(1, 2);
        addChar.addCharO(1, 0);
        addChar.addCharX(1, 1);
        Assert.assertEquals(2L, (long)addChar.maxXDiag());
    }

    @Test
    public void longestSequenceTic() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharX(0, 0);
        addChar.addCharX(0, 1);
        addChar.addCharX(1, 2);
        addChar.addCharO(2, 1);
        addChar.addCharO(2, 2);
        Assert.assertEquals(2L, (long)addChar.maxX());
    }

    @Test
    public void longestSequenceTac() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharO(0, 0);
        addChar.addCharX(0, 1);
        addChar.addCharX(1, 2);
        addChar.addCharO(1, 0);
        addChar.addCharO(2, 0);
        addChar.addCharO(2, 2);
        Assert.assertEquals(3L, (long)addChar.maxO());
    }

    @Test
    public void longestDiagonalTac() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addCharX(0, 0);
        addChar.addCharX(1, 0);
        addChar.addCharO(2, 0);
        addChar.addCharO(1, 1);
        addChar.addCharO(0, 2);
        addChar.addCharX(2, 1);
        Assert.assertEquals(3L, (long)addChar.maxODiag());
    }
}
