package com.blecua84.palindromeapp.converters;

import com.blecua84.palindromeapp.models.exchange.PalindromeVO;
import com.blecua84.palindromeapp.models.internal.Palindrome;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PalindromeToPalindromeVOConverter implements Converter<Palindrome, PalindromeVO> {

    @Override
    public PalindromeVO convert(Palindrome source) {
        PalindromeVO target = null;

        if(source != null) {
            target = new PalindromeVO();

            target.setText(source.getText());
            target.setIndex(source.getIndex());
            target.setLength(source.getLength());
        }

        return target;
    }
}
