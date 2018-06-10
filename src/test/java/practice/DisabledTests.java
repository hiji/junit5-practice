package practice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisabledTests {

    @Disabled
    @Test
    void testWillBeSkipped() {

    }

    @Test
    void testWillBeExecuted() {
    }
}
