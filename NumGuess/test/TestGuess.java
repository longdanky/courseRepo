import junit.framework.Assert;
import org.junit.Test;

public class TestGuess {
    @Test
    public void should_return_4a0b_given_all_digits_is_correct(){
        GameLogical gameLogical = new GameLogical("1234");
        Assert.assertEquals("4A0B",gameLogical.getResult("1234"));
    }

    @Test
    public void should_return_3a0b_given_partial_digits_are_correct(){
        GameLogical gameLogical = new GameLogical("1234");
        Assert.assertEquals("3A0B",gameLogical.getResult("1235"));
    }
    @Test
    public void should_return_2a1b_given_partial_digits_are_correct(){
        GameLogical gameLogical = new GameLogical("1234");
        Assert.assertEquals("2A1B",gameLogical.getResult("1246"));
    }

    @Test
    public void should_return_0a3b_given_partial_digits_are_correct(){
        GameLogical gameLogical = new GameLogical("1234");
        Assert.assertEquals("0A3B",gameLogical.getResult("2346"));
    }
}
