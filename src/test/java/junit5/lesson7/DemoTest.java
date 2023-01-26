package junit5.lesson7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class DemoTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach");
    }

//    @BeforeAll
//    public static void beforeAll() {
//        System.out.println("BeforeAll");
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        System.out.println("AfterAll");
//    }

    @Test
    void demo() {
        System.out.println("Test");
        Assertions.assertTrue(3 < 2);
    }
}
