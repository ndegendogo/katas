package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(String arabicString) {
        Integer arabicNumber = new Integer(arabicString);
        StringBuilder roman = new StringBuilder();
        convert(arabicNumber, roman);
        final String result = roman.toString();
        return result;
    }

    static void convert(Integer arabicNumber, StringBuilder roman) {
        while (arabicNumber >= 5) {
            arabicNumber -=5;
            roman.append("V");
        }
        while (arabicNumber > 0) {
            arabicNumber -=1;
            roman.append("I");
        }
    }

    public static void main(String[] args) {
        String arabic = args[0];
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
