package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
class DisplayNames {

    @Test
    @DisplayName("Custom test name containing spaces")
    void スペースを含んだテストケース名() {

    }

    @Test
    @DisplayName("╯°□°）╯")
    void 特殊文字を含んだテストケース名() {

    }

    @Test
    @DisplayName("\uD83D\uDE31")
    void 絵文字を含んだテストケース名() {

    }
}
