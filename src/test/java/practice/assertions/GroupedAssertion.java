package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupedAssertion {

    @Test
    void groupedAssertions() {
        Person person = new Person("John", "Doe");
        // 通常は検証が失敗した時点でテスト失敗になるが、
        // グループにすると、そのグループ内の検証は全て実行される。
        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        Person person = new Person(null, null);
        // グループの要素として渡すラムダ式の中で、さらに複数の検証もできる。
        // その中では通常と同じで、assertAllを使わなければ先に失敗すると後続の検証は実行されない。
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();

                    // この検証が失敗すると、後続のassertAllは実行されじ、このブロックでの検証は終了する。
                    // ただ、propertiesグループの検証としては継続され、次の検証に移る。
                    assertNotNull(firstName);

                    //
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("n"))
                    );
                },
                () -> {
                    String lastName = person.getLastName();

                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    static class Person {

        private final String firstName;
        private final String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }
    }
}
