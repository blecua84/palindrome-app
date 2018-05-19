package com.blecua84.palidromeapp.models;

public class Palindrome {

    private String text;
    private int index;
    private int length;

    private Palindrome(String text, int index, int length) {
        this.text = text;
        this.index = index;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public static Palindrome createFromData(String text, int index, int length) {
        return new Palindrome(text, index, length);
    }

    @Override
    public String toString() {
        return String.format("Text: %s, Index: %s, Length: %s", this.text, this.index, this.length);
    }
}
