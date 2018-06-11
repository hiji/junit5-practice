package practice.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValueSources {

    @ParameterizedTest
    @ValueSource(ints = { 2, 3, 4 })
    void testWithIntValueSource(int argument) {
        assertTrue(argument > 1 && argument < 5);
    }

    @ParameterizedTest
    @ValueSource(strings = { "John", "Jan", "Joker" })
    void testWithStringValueSource(String argument) {
        assertTrue(argument.startsWith("J"));
    }

    @ParameterizedTest
    @ValueSource(classes = {String.class, Integer.class})
    void testWithClassTypeSource(Class argument) {
        assertTrue(argument == String.class || argument == Integer.class);
    }
}
