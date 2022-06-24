import org.junit.jupiter.api.Test;
import validators.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordTest {

    @Test
    void testNumberRequirement() {
        Validator validator = new Validator.Builder()
                .mustIncludeNumber().build();

        assertTrue(validator.validate("asdf1"));
        assertFalse(validator.validate("asdf"));
    }

    @Test
    void testUpperCaseRequirement() {
        Validator validator = new Validator.Builder()
                .mustIncludeUpperCaseLetter().build();

        assertTrue(validator.validate("asdF"));
        assertFalse(validator.validate("asdf"));
    }

    @Test
    void testLowerCaseRequirement() {
        Validator validator = new Validator.Builder()
                .mustIncludeLowerCaseLetter().build();

        assertTrue(validator.validate("ASDf"));
        assertFalse(validator.validate("ASDF"));
    }

    @Test
    void testLengthRequirement() {
        Validator validator = new Validator.Builder()
                .characterLimit(8).build();

        assertTrue(validator.validate("asdfasdf"));
        assertTrue(validator.validate("asdfasdfi"));
        assertFalse(validator.validate("asdfasd"));
        assertFalse(validator.validate("asdf"));
    }

    @Test
    void testSpecialCharacterRequirement() {
        Validator validator = new Validator.Builder()
                .mustIncludeSpecialCharacter().build();

        assertTrue(validator.validate("asdf?"));
        assertTrue(validator.validate("asdf_"));
        assertFalse(validator.validate("asdf"));
    }
}
