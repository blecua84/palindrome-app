package com.blecua84.palidromeapp.services.impl;

import com.blecua84.palidromeapp.models.Palindrome;
import com.blecua84.palidromeapp.services.PalindromeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    private static final int MAX_NUMBER_OF_PALINDROMES = 3;

    public List<Palindrome> getThreeLongestPalindromesFromAWord(String word) {
        List<Palindrome> resultList = new ArrayList<>();

        if (word != null && !word.isEmpty()) {
            resultList = getAllPalindromesFromAWord(word);

            resultList = resultList.stream()
                    .sorted(Comparator.comparing(Palindrome::getLength).reversed())
                    .limit(MAX_NUMBER_OF_PALINDROMES)
                    .collect(Collectors.toList());
        }

        return resultList;
    }

    private List<Palindrome> getAllPalindromesFromAWord(String word) {
        List<Palindrome> resultList = new LinkedList<>();
        String originalWord = word;

        int indexInitNewWord;
        int indexEndNewWord;
        String newWord;

        while (!word.isEmpty()) {
            indexInitNewWord = 0;
            indexEndNewWord = word.indexOf(word.charAt(0), indexInitNewWord + 1);
            newWord = word.substring(indexInitNewWord, ++indexEndNewWord);

            if (!newWord.isEmpty() && isPalindrome(newWord)) {
                resultList.add(Palindrome.createFromData(newWord, originalWord.indexOf(word), newWord.length()));
                indexInitNewWord = newWord.length();
            } else {
                indexInitNewWord++;
            }

            word = word.substring(indexInitNewWord);
        }
        return resultList;
    }

    private static boolean isPalindrome(String word) {
        return word.equals(new StringBuffer(word).reverse().toString());
    }
}
