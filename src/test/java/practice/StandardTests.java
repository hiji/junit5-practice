package practice;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

class StandardTests {

    @BeforeAll
    static void initAll() {

    }

    @BeforeEach
    void init() {
        
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skipTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }
}
