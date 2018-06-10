package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class FailingTest {

    @Test
    void failingTest() {
        fail();
    }

    @Test
    void failingTestWithMessage() {
        fail("a failing test");
    }

    @Test
    void failingTestWithCauseException() {
        try {
            throw new IllegalStateException("例外だよ");
        } catch (Exception e) {
            // 失敗させる時に、原因となる例外を渡せる
            fail("a failing test", e);
        }
    }
}
