package guru.qa;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("###\n\n @BerforeAll\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("### @AfterAll\n\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###      @BerforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("###      @AfterEach\n");
    }


    @Test
    void firstTest() {
        System.out.println("###           @Test firstTest");
        Assertions.assertTrue( 2 * 2 == 4);
    }
    @Test
    void secondTest() {
            System.out.println("###           @Test secondTest");
            Assertions.assertTrue( 2 / 2 == 1);
    }
}
