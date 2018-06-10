package practice.parameters.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static practice.parameters.extensions.RandomParametersExtension.Random;

@ExtendWith(RandomParametersExtension.class)
class RandomParametersTest {

    @Test
    void injectsInteger(@Random int i, @Random int j) {
        assertNotEquals(i, j);
    }

    @Test
    void injectsDouble(@Random double d) {
        // 拡張とは直接関係ないが…
        // 第3引数(delta)は許容誤差を表すため、引数に入る値は全て許容範囲内になる
        assertEquals(0.0, d, 1.0);
    }
}
