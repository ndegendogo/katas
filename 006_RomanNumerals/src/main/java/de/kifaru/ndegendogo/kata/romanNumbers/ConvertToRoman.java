package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    String arabToRoman(String arabicString) {
        Integer arabicNumber = new Integer(arabicString);
        StringBuilder roman = new StringBuilder();
        convert(arabicNumber, roman);
        final String result = roman.toString();
        return result;
    }

    void convert(Integer arabicNumber, StringBuilder roman) {
        while (arabicNumber >= 5) {
            arabicNumber -=5;
            roman.append("V");
        }
        while (arabicNumber >= 1) {
            arabicNumber -=1;
            roman.append("I");
        }
    }

    public static void main(String[] args) {
        String arabic = args[0];
        ConvertToRoman converter = new ConvertToRoman();
        String roman = converter.arabToRoman(arabic);
        System.out.println(roman);
    }

}
