import org.example.Calculator;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
    public int result = 0;
    
    @BeforeAll
    public void initialize() {
        System.out.println("Before All is called");
    }
    
    @BeforeEach
    public void setup() {
        System.out.println("Before each is called");
    }
    
    @AfterEach
    public void methodCleanup() {
        System.out.println("After each is called");
    }
    
    @AfterAll
    public void classCleanup() {
        System.out.println("After all is called");
    }

    @Test
    public void testTambah10() {
        int angka = 10;
        Calculator calculator = new Calculator(result, angka);
        result = calculator.tambah();

        //Assertions.assertEquals(10, result);
        System.out.println("Test method 1");
    }

    @Test
    public void testKali10() {
        int kali = 10;
        Calculator calculator = new Calculator(result, kali);
        result = calculator.kali();

        //Assertions.assertEquals(100, result);
        System.out.println("Test method 2");
    }
}
