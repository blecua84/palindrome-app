package com.blecua84.palindromeapp.services.impl;

import com.blecua84.palindromeapp.models.internal.Palindrome;
import com.blecua84.palindromeapp.services.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeServiceImpl.class);

    private static final int MAX_NUMBER_OF_PALINDROMES = 3;

    private static boolean isPalindrome(String word) {
        return word.equals(new StringBuffer(word).reverse().toString());
    }

    public List<Palindrome> getThreeLongestPalindromesFromAWord(String word) {
        LOGGER.info("Init getThreeLongestPalindromesFromAWord...");
        List<Palindrome> resultList = new LinkedList<>();

        if (word != null && !word.isEmpty()) {
            resultList = getAllPalindromesFromAWord(word);

            resultList = resultList.stream()
                    .sorted(Comparator.comparing(Palindrome::getLength).reversed())
                    .limit(MAX_NUMBER_OF_PALINDROMES)
                    .collect(Collectors.toList());
        } else {
            LOGGER.warn("The input word is null or empty...");
        }

        LOGGER.info("End getThreeLongestPalindromesFromAWord");
        return resultList;
    }

    private List<Palindrome> getAllPalindromesFromAWord(String word) {
        LOGGER.info("Init getAllPalindromesFromAWord...");
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

        LOGGER.info("Number of palindromes found: {}", resultList.size());
        LOGGER.info("End getAllPalindromesFromAWord!!");
        return resultList;
    }
}
