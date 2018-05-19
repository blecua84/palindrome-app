package com.blecua84.palindromeapp.models.internal;

public class Palindrome {

    private String text;
    private int index;
    private int length;

    private Palindrome(String text, int index, int length) {
        this.text = text;
        this.index = index;
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLength(int length) {
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
