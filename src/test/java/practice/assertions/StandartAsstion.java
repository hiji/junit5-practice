package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StandartAsstion {

    @Test
    void standardAssertions() {
        assertEquals(2, 2);

        assertEquals(4, 4, "検証失敗時のメッセージ");

        assertTrue('a' < 'b', () -> "検証失敗時に評価される（遅延評価）エラーメッセージ");
    }
}
