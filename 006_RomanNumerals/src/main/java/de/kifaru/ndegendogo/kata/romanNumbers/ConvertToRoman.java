package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    private StringBuilder roman;
    private Integer arabicNumber;

    ConvertToRoman(String arabicString) {
        roman = new StringBuilder();
        arabicNumber = new Integer(arabicString);
    }

    String arabToRoman(String arabicString) {
        convert();
        final String result = roman.toString();
        return result;
    }

    void convert() {
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
        ConvertToRoman converter = new ConvertToRoman(arabic);
        String roman = converter.arabToRoman(arabic);
        System.out.println(roman);
    }

}
