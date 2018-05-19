package com.blecua84.palidromeapp.controllers;

import com.blecua84.palidromeapp.converters.PalindromeToPalindromeVOConverter;
import com.blecua84.palidromeapp.models.exchange.PalindromeVO;
import com.blecua84.palidromeapp.models.internal.Palindrome;
import com.blecua84.palidromeapp.services.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PalindromeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeController.class);

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private PalindromeToPalindromeVOConverter converter;

    @GetMapping()
    public List getPalindromes(String word) {
        LOGGER.info("Init request for the word: {}", word);
        List<PalindromeVO> palindromeVOS = new ArrayList<>();

        List<Palindrome> palindromes = this.palindromeService.getThreeLongestPalindromesFromAWord(word);

        if (palindromes != null && !palindromes.isEmpty()) {
            for (Palindrome palindrome: palindromes) {
                palindromeVOS.add(this.converter.convert(palindrome));
            }
        }

        LOGGER.info("Number of palindromes found: {}", palindromeVOS.size());
        LOGGER.info("End request for the word: {}", word);
        return palindromeVOS;
    }

}
