
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void addition() {
        System.out.println("Running addition test...");
        assertEquals(2, 1 + 1);
        System.out.println("Addition test passed: 1 + 1 = 2");
    }

    @Test
    void subtraction() {
        System.out.println("Running subtraction test...");
        assertEquals(0, 1 - 1);
        System.out.println("Subtraction test passed: 1 - 1 = 0");
    }

}
