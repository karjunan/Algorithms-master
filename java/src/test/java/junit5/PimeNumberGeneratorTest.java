//package junit5;
//
//import com.algorithms.arrayproblems.PrimeNumberGenerator;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class PimeNumberGeneratorTest {
//
//
//    @Test
//    @DisplayName("when input is one")
//    public void validate_prime_when_input_is_One() {
//        assertEquals(true,PrimeNumberGenerator.findPrime(1));
//    }
//
//
//    @Test
//    @DisplayName("when input is two")
//    public void validate_prime_when_input_is_two() {
//        assertEquals(true,PrimeNumberGenerator.findPrime(2));
//    }
//
//
//    @Test
//    @DisplayName("when input is three")
//    public void validate_prime_when_input_is_three() {
//        assertEquals(true,PrimeNumberGenerator.findPrime(3));
//    }
//
//
//    @Test
//    @DisplayName("when input is four")
//    public void validate_prime_when_input_is_four() {
//        assertEquals(false,PrimeNumberGenerator.findPrime(4));
//    }
//
//    @Test
//    @DisplayName("when input is five")
//    public void validate_prime_when_input_is_five() {
//        assertEquals(true,PrimeNumberGenerator.findPrime(5));
//    }
//}
