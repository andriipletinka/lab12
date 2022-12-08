import chainofresponsibility.Handler20;
import chainofresponsibility.Handler5;
import chainofresponsibility.Handler50;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ATMTest {

    Handler50 handler50 = new Handler50();
    Handler20 handler20 = new Handler20();
    Handler5 handler5 = new Handler5();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setup() {
        handler50.setNext(handler20);
        handler20.setNext(handler5);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void IllegalArgumentTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {handler50.process(126);});
    }

    @Test
    public void Handler50Test() {
        handler50.process(100);
        Assertions.assertEquals("2 * 50", outContent.toString().strip());
    }

    @Test
    public void Handler20Test() {
        handler20.process(100);
        Assertions.assertEquals("5 * 20", outContent.toString().strip());
    }

    @Test
    public void Handler5Test() {
        handler5.process(100);
        Assertions.assertEquals("20 * 5", outContent.toString().strip());
    }
}
