package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
