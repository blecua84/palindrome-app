package com.blecua84.palindromeapp.models.exchange;

public class PalindromeVO {

    private String text;
    private int index;
    private int length;

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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("Text: %s, Index: %s, Length: %s", this.text, this.index, this.length);
    }
}
