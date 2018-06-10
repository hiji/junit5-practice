package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class NestedTests {

    private Stack<Object> stack;

    @BeforeEach
    void init() {
        // どのテストケースでも最初に実行される前処理
        stack = new Stack<>();
        stack.push("an element");
    }

    @Test
    void isOneElement() {
        assertEquals(stack.size(), 1);
    }

    @Nested
    class WhenEmpty {

        @BeforeEach
        void clearStack() {
            // WhenEmptyのテストで追加で実行される前処理
            stack.pop();
        }

        @Test
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        void throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, () -> stack.pop());
        }

        @Test
        void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, () -> stack.peek());
        }

        @Nested
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                // AfterPushingのテストで追加で実行される前処理
                stack.push(anElement);
            }

            @Test
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
