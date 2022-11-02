package dpiqb;

import dpiqb.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    @Test
    public void testThat0InputHandledCorrectly(){
        long actual = new Factorial().calc(0);
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void testThat1HandledCorrectly(){
        Assertions.assertEquals(1, new Factorial().calc(1));
    }

    @Test
    public void testThat2HandledCorrectly(){
        Assertions.assertEquals(2, new Factorial().calc(2));
    }

    @Test
    public void testThat12HandledCorrectly(){
        Assertions.assertEquals(479001600, new Factorial().calc(12));
    }
    @Test
    public void testThat18HandledCorrectly(){
        Assertions.assertEquals(6402373705728000L, new Factorial().calc(18));
    }
    @Test
    public void testThatNegativeInputHandledCorrectly(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Factorial().calc(-1)
        );
    }
    @Test
    public void testThatTooBigInputHandledCorrectly(){
        int maxN = 20;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Factorial().calc(maxN + 1)
        );
    }
}
