package com.blecua84.palindromeapp.models.exchange;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeVOTest {

    private static final int LENGTH = 10;
    private static final int INDEX = 23;
    private static final String TEXT = "hijkllkjih";

    @Test
    public void getLength_shouldReturnThePalindromeLength() {
        PalindromeVO word = new PalindromeVO();
        word.setText(TEXT);
        word.setIndex(INDEX);
        word.setLength(LENGTH);

        assertEquals(LENGTH, word.getLength());
    }

    @Test
    public void toString_shouldReturnTheDataInTheCorrectFormat() {
        PalindromeVO word = new PalindromeVO();
        word.setText(TEXT);
        word.setIndex(INDEX);
        word.setLength(LENGTH);

        assertEquals("Text: hijkllkjih, Index: 23, Length: 10", word.toString());
    }
}
