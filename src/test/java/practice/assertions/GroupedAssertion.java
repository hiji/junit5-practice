package practice.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupedAssertion {

    @Test
    void groupedAssertions() {
        // 通常は検証が失敗した時点でテスト失敗になるが、
        // グループにすると、そのグループ内の検証は全て実行される。
        Person person = new Person("John", "Doe");
        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName())
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
