package com.blecua84.palindromeapp.converters;

import com.blecua84.palindromeapp.models.exchange.PalindromeVO;
import com.blecua84.palindromeapp.models.internal.Palindrome;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PalindromeToPalindromeVOConverterTest {

    private PalindromeToPalindromeVOConverter converter;

    @Before
    public void init() {
        this.converter = new PalindromeToPalindromeVOConverter();
    }

    @Test
    public void converter_receiveANullObject_shouldReturnNull() {
        assertEquals(null, converter.convert(null));
    }

    @Test
    public void converter_receiveAValidObject_shouldReturnTheSameValuesContainedInTheOriginalObject() {
        Palindrome mockPalindrome = mock(Palindrome.class);
        when(mockPalindrome.getText()).thenReturn("hijkllkjih");
        when(mockPalindrome.getIndex()).thenReturn(0);
        when(mockPalindrome.getLength()).thenReturn(10);

        PalindromeVO palindromeVO = converter.convert(mockPalindrome);

        assertEquals("hijkllkjih", palindromeVO.getText());
        assertEquals(0, palindromeVO.getIndex());
        assertEquals(10, palindromeVO.getLength());
    }
}
