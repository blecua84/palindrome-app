package com.blecua84.palindromeapp.controllers;

import com.blecua84.palindromeapp.converters.PalindromeToPalindromeVOConverter;
import com.blecua84.palindromeapp.models.exchange.PalindromeVO;
import com.blecua84.palindromeapp.models.internal.Palindrome;
import com.blecua84.palindromeapp.services.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class PalindromeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeController.class);

    private List<PalindromeVO> palindromes;
    private boolean emptyResult;
    private String inputWord;

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private PalindromeToPalindromeVOConverter converter;

    public PalindromeController() {
        this.palindromes = null;
    }

    @PostMapping
    public String submit(String inputWord) {
        LOGGER.info("Init request for the word: {}", inputWord);
        this.palindromes = new LinkedList<>();
        this.emptyResult = false;
        this.inputWord = inputWord;

        List<Palindrome> palindromes = this.palindromeService.getThreeLongestPalindromesFromAWord(inputWord);

        if (palindromes != null && !palindromes.isEmpty()) {
            for (Palindrome palindrome : palindromes) {
                this.palindromes.add(this.converter.convert(palindrome));
            }
        } else {
            this.emptyResult = true;
        }

        LOGGER.info("Number of palindromes to show: {}", this.palindromes.size());
        LOGGER.info("End request for the word: {}", inputWord);
        return "redirect:/";
    }

    @GetMapping(value = "/")
    public String welcome(Map<String, Object> model) {
        model.put("palindromes", this.palindromes);
        model.put("emptyResult", this.emptyResult);
        model.put("inputWord", this.inputWord);
        return "home";
    }
}
