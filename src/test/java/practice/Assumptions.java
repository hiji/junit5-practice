package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class Assumptions {

    @Test
    void testOnlyCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // "ENV"が"CI"なら、以降のコードが実行される
        // そうではない場合、テストは失敗ではなく「スキップ」扱いになる
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")), () -> {
            // ここは"ENV"が"CI"の時だけ実行される。それ以外の場合はスキップされる。
            assertEquals(2, 2);
        });

        // ここはどんな場合でも実行される
        assertEquals("a string", "a string");
    }
}
