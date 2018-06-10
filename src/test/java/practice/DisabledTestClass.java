package practice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class DisabledTestClass {

    // IDE等で直接テストクラスを実行した場合はスキップされないので注意

    @Test
    void testWillBeSkipped() {
        //　テストクラスが無効になっているので、テストは全てスキップされる
        assertEquals(1, 2);
    }
}
