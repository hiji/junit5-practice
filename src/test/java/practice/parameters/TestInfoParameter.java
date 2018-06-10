package practice.parameters;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestInfo Parameter")
public class TestInfoParameter {

    public TestInfoParameter(TestInfo testInfo) {
        // コンストラクタでテストに関する情報を取得できる
        // 環境情報やクラス単位のテスト情報を取得したりできそうだが、使いどころが難しそう
        assertEquals("TestInfo Parameter", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        // テスト前後処理で、実行対象のテスト情報を取得できる
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        // テスト実行時に、テスト情報を取得できる
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
        assertTrue(true);
    }
}
