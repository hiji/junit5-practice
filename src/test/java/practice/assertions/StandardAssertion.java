package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardAssertion {

    @Test
    void standardAssertions() {
        assertEquals(2, 2);

        assertEquals(4, 4, "検証失敗時のメッセージ");

        Message Message = new Message("検証失敗時に評価（遅延評価）されるエラーメッセージ");
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
