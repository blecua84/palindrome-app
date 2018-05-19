package com.blecua84.palidromeapp.services;

import com.blecua84.palidromeapp.models.Palindrome;

import java.util.List;

public interface PalindromeService {

    List<Palindrome> getThreeLongestPalindromesFromAWord(String word);
}
