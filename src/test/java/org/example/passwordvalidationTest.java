package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class passwordvalidationTest {

    @Test
    void main() {
    }
    @Test
    void checkLength_whenLengthIsAtLeast8_thenReturnTrue() {
        //GIVEN
        String password = "tellllest1";
        //WHEN
        boolean actual = passwordvalidation.checkLength(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void checkForDigits_whenContainsDigits_thenReturnTrue() {
        //GIVEN
        String password = "te4stTest";
        //WHEN
        boolean actual = passwordvalidation.checkForDigits(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void checkForUpperAndLowerCase_whenUsesUpperAndLowercase_thenReturnTrue() {
        //GIVEN
        String password = "tesDtdest1";
        //WHEN
        boolean actual = passwordvalidation.checkForUpperAndLowerCase(password);
        //THEN
        assertTrue(actual);
    }
    @Test
    void checkForCommonlyUsed_whenNotCommonlyUsed_thenReturnTrue() {
        //GIVEN
        String password = "password";
        //WHEN
        boolean actual = passwordvalidation.checkForCommonlyUsed(password);
        //THEN
        assertFalse(actual);
    }
}