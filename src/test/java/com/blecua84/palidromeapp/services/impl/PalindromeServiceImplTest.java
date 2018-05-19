package com.blecua84.palidromeapp.services.impl;

import com.blecua84.palidromeapp.models.Palindrome;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeServiceImplTest {

    @InjectMocks
    private PalindromeServiceImpl wordServiceImpl;

    @Test
    public void getPalindromes_receiveANullInputString_shouldReturnAnEmptyListOfWords() {
        List<Palindrome> palindromes = wordServiceImpl.getThreeLongestPalindromesFromAWord(null);

        assertEquals(0, palindromes.size());
    }

    @Test
    public void getPalindromes_receiveAnEmptyInputString_shouldReturnAnEmptyListOfWords() {
        List<Palindrome> palindromes = wordServiceImpl.getThreeLongestPalindromesFromAWord(null);

        assertEquals(0, palindromes.size());
    }

    @Test
    public void getPalindromes_receiveAWordWithOnePalindrome_shouldReturnAListWithThePalindrome() {
        List<Palindrome> palindromes = wordServiceImpl.getThreeLongestPalindromesFromAWord("hijkllkjih");

        assertEquals(1, palindromes.size());
        assertEquals("Text: hijkllkjih, Index: 0, Length: 10", palindromes.get(0).toString());
    }

    @Test
    public void getPalindromes_receiveAWordWithTwoPalindromes_shouldReturnAListWithTheTwoPalindromes() {
        List<Palindrome> palindromes = wordServiceImpl.getThreeLongestPalindromesFromAWord("hijkllkjihikjnlkndfttfd");

        assertEquals(2, palindromes.size());
        assertEquals("Text: hijkllkjih, Index: 0, Length: 10", palindromes.get(0).toString());
        assertEquals("Text: dfttfd, Index: 17, Length: 6", palindromes.get(1).toString());
    }

    @Test
    public void getPalindromes_receiveAWordWithSeveralPalindromes_shouldReturnAListWithTheLongestThreePalindromes() {
        List<Palindrome> palindromes = wordServiceImpl.getThreeLongestPalindromesFromAWord("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");

        assertEquals(3, palindromes.size());
        assertEquals("Text: hijkllkjih, Index: 23, Length: 10", palindromes.get(0).toString());
        assertEquals("Text: defggfed, Index: 13, Length: 8", palindromes.get(1).toString());
        assertEquals("Text: abccba, Index: 5, Length: 6", palindromes.get(2).toString());
    }

    @Test
    public void getPalindromes_receiveAnValidInputStringWithNoPalindromes_shouldReturnAnEmptyListOfWords() {
        List<Palindrome> palindromes = wordServiceImpl.getThreeLongestPalindromesFromAWord("wordwithoutanypalindromes");

        assertEquals(0, palindromes.size());
    }
}
