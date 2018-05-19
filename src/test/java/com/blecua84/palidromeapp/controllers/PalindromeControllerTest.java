package com.blecua84.palidromeapp.controllers;

import com.blecua84.palidromeapp.converters.PalindromeToPalindromeVOConverter;
import com.blecua84.palidromeapp.models.exchange.PalindromeVO;
import com.blecua84.palidromeapp.models.internal.Palindrome;
import com.blecua84.palidromeapp.services.PalindromeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeControllerTest {

    @Mock
    private PalindromeService palindromeService;

    @Mock
    private PalindromeToPalindromeVOConverter converter;

    @InjectMocks
    private PalindromeController controller;

    @Test
    public void home_receiveAWordWithPalindromes_shouldReturnAListOfExchangeObject() {
        List<Palindrome> mockListPalindrome = new LinkedList<>();
        mockListPalindrome.add(mock(Palindrome.class));
        when(palindromeService.getThreeLongestPalindromesFromAWord(anyString())).thenReturn(mockListPalindrome);
        when(converter.convert(any())).thenReturn(mock(PalindromeVO.class));

        List<PalindromeVO> resultList = controller.getPalindromes("sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop");

        assertEquals(1, resultList.size());
        verify(palindromeService).getThreeLongestPalindromesFromAWord(any());
        verify(converter).convert(any());
    }

    @Test
    public void home_receiveAWordWithoutParameters_shouldReturnAnEmptyList() {
        List<Palindrome> mockListPalindrome = mock(List.class);
        when(mockListPalindrome.isEmpty()).thenReturn(true);
        when(palindromeService.getThreeLongestPalindromesFromAWord(anyString())).thenReturn(mockListPalindrome);

        List<PalindromeVO> resultList = controller.getPalindromes("nopalindromes");

        assertEquals(0, resultList.size());
        verify(palindromeService).getThreeLongestPalindromesFromAWord(any());
        verify(converter, times(0)).convert(any());
    }
}
