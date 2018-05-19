package com.blecua84.palindromeapp.services;

import com.blecua84.palindromeapp.models.internal.Palindrome;

import java.util.List;

public interface PalindromeService {

    List<Palindrome> getThreeLongestPalindromesFromAWord(String word);
}
