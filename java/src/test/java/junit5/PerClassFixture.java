//package junit5;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class PerClassFixture {
//
//    PerClassFixture() {
//        System.out.println("Consturucctor ");
//    }
//
//    @BeforeAll
//    public void setup() {
//        System.out.println("Before All");
//    }
//
//    @BeforeEach
//    public void beforEach() {
//        System.out.println("beforeEach");
//    }
//
//    @Test
//    public void test() {
//        System.out.println("test");
//    }
//
//    @Test
//    public void test1() {
//        System.out.println("test1");
//    }
//}
