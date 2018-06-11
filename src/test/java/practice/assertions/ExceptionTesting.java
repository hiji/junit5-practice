package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTesting {

    @Test
    void exceptionTesting() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("例外だよ");
        });
    }

    @Test
    void exceptionTestingWithProperty() {
        // 例外を取得して、詳細な検証をすることができる
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("例外だよ");
        });
        assertEquals("例外だよ", exception.getMessage());
    }

    @Test
    void notThrowTesting() {
        // どんな例外も投げられないことを検証する
        assertDoesNotThrow(() -> {
            assertEquals(1, 1);
        });
    }
}
