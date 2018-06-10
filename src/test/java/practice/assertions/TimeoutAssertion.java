package practice.assertions;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class TimeoutAssertion {

    @Test
    void timeoutNotExceeded() {
        // タイムアウトしないことを検証する
        assertTimeout(Duration.ofMinutes(2), () -> {
            // 2分未満で終われば成功
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        // タイムアウトしないことを検証し、その実行結果も受け取って検証する
        String actualResult = assertTimeout(Duration.ofMinutes(2), () -> "a result");
        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        // タイムアウトしないことを検証するコードを、ラムダ式ではなく、メソッド参照で指定する。
        String actualGreeting = assertTimeout(Duration.ofMinutes(2), TimeoutAssertion::greeting);
        assertEquals("Hello, World!", actualGreeting);
    }

    @Test
    void timeoutExceeded() {
        // コードを実行後、10msを超えていたらタイムアウトとして検証が失敗する
        assertTimeout(Duration.ofMillis(10), () -> {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("出力される");
        });
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {
        // 10msを超えた時点で、強制的にタイムアウトとして検証を失敗させる
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("強制終了のため出力されない");
        });
    }

    private static String greeting() {
        return "Hello, World!";
    }
}
