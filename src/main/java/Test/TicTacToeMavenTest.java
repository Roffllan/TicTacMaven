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
        addChar.addChar(0, 0, Players.X);
        addChar.addChar(0, 1, Players.X);
        addChar.addChar(0, 2, Players.X);
        Assert.assertEquals(Players.X, addChar.getState(0, 0));
        Assert.assertEquals(Players.X, addChar.getState(0, 1));
        Assert.assertEquals(Players.X, addChar.getState(0, 2));
        Assert.assertEquals(Players.emp, addChar.getState(1, 1));
    }

    @Test
    public void testAddTac() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addChar(2, 0, Players.O);
        addChar.addChar(2, 1, Players.O);
        addChar.addChar(2, 2, Players.O);
        Assert.assertEquals(Players.O, addChar.getState(2, 0));
        Assert.assertEquals(Players.O, addChar.getState(2, 1));
        Assert.assertEquals(Players.O, addChar.getState(2, 2));
        Assert.assertEquals(Players.emp, addChar.getState(1, 2));
    }

    @Test
    public void testRemove() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addChar(2, 0, Players.X);
        addChar.addChar(2, 1, Players.O);
        addChar.addChar(2, 2, Players.X);
        Assert.assertEquals(Players.emp, addChar.cleaner(2, 0));
        Assert.assertEquals(Players.emp, addChar.cleaner(2, 1));
        Assert.assertEquals(Players.emp, addChar.cleaner(2, 2));
    }

    @Test
    public void longestDiagonalTic() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addChar(0, 0, Players.X);
        addChar.addChar(2, 2, Players.X);
        addChar.addChar(0, 1, Players.O);
        addChar.addChar(1, 2, Players.O);
        addChar.addChar(1, 0, Players.O);
        addChar.addChar(1, 1, Players.X);
        Assert.assertEquals(3, addChar.maxDiag(Players.X));
    }

    @Test
    public void longestSequenceTic() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addChar(0, 0, Players.X);
        addChar.addChar(0, 1, Players.X);
        addChar.addChar(1, 2, Players.X);
        addChar.addChar(2, 1, Players.O);
        addChar.addChar(2, 2, Players.O);
        Assert.assertEquals(2, addChar.maxLenght(Players.X));
    }

    @Test
    public void longestSequenceTac() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addChar(0, 0, Players.O);
        addChar.addChar(0, 1, Players.X);
        addChar.addChar(1, 2, Players.X);
        addChar.addChar(1, 0, Players.O);
        addChar.addChar(2, 0, Players.O);
        addChar.addChar(2, 2, Players.O);
        Assert.assertEquals(3, addChar.maxLenght(Players.O));
    }

    @Test
    public void longestDiagonalTac() throws IOException {
        TicTacToeMaven.GameXO addChar = new TicTacToeMaven.GameXO(3);
        addChar.addChar(0, 0, Players.X);
        addChar.addChar(1, 0, Players.X);
        addChar.addChar(2, 0, Players.O);
        addChar.addChar(1, 1, Players.O);
        addChar.addChar(0, 2, Players.O);
        addChar.addChar(2, 1, Players.X);
        Assert.assertEquals(3, addChar.maxDiag(Players.O));
    }
}
