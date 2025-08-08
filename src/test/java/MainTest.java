import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class MainTest {

    @Test
    void additionTest() {
        System.out.println("Running test 1...");
        assertEquals(2, 1 + 1);
    }

    @Test
    void subtractionTest() {
        System.out.println("Running test 2...");
        assertEquals(1, 2 - 1);
    }
}
