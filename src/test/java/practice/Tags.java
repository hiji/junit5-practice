package practice;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
class Tags {

    @Test
    @Tag("feature-add")
    void testingAddition() {
    }

    @Test
    @Tag("feature-sub")
    void testingSubtraction() {
    }
}
