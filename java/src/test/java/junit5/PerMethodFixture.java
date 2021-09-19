//package junit5;
//
//
//import org.junit.jupiter.api.*;
//
//
////@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//public class PerMethodFixture {
//
//
//    public PerMethodFixture() {
//
//        System.out.println("Inside Constructor");
//    }
//
//    @BeforeAll
//    public  static void setupForClass() {
//        System.out.println("Before ALL");
//    }
//
//    @AfterAll
//    public static void setupForAfterClass() {
//        System.out.println("After ALL");
//    }
//
//    @BeforeEach
//    public void setupPerMethod() {
//        System.out.println("Before Each");
//    }
//
//
//    @Test
//    public void test1() {
//        System.out.println("Test");
//    }
//
//    @Test
//    public void test2() {
//        System.out.println("Test2");
//    }
//
//
//}
