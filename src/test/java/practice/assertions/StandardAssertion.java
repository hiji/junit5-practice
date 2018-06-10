package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardAssertion {

    @Test
    void standardAssertions() {
        assertEquals(2, 2);

        // 検証失敗時のメッセージを設定することができる
        assertEquals(4, 4, "エラーメッセージ");

        // ラムダ式で検証失敗時のエラーメッセージを設定することができる。
        // そうすることで、検証失敗時まで評価を遅延させることができる。
        Message Message = new Message("エラーメッセージ");
        assertEquals(6, 6, Message::getMessage);
    }

    static class Message {
        private String message;

        Message(String message) {
            this.message = message;
        }

        String getMessage() {
            return message;
        }
    }
}
