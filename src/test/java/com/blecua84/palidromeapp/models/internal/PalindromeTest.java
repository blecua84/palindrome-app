package com.blecua84.palidromeapp.models.internal;

import com.blecua84.palidromeapp.models.internal.Palindrome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    private static final int LENGTH = 10;
    private static final int INDEX = 23;
    private static final String TEXT = "hijkllkjih";

    @Test
    public void getLength_shouldReturnThePalindromeLength() {
        Palindrome word = Palindrome.createFromData(TEXT, INDEX, LENGTH);

        assertEquals(LENGTH, word.getLength());
    }

    @Test
    public void toString_shouldReturnTheDataInTheCorrectFormat() {
        Palindrome word = Palindrome.createFromData(TEXT, INDEX, LENGTH);

        assertEquals("Text: hijkllkjih, Index: 23, Length: 10", word.toString());
    }
}
