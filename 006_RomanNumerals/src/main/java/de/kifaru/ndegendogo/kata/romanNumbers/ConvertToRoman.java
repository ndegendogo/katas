package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    private StringBuilder roman;

    ConvertToRoman() {
        roman = new StringBuilder();
    }

    String arabToRoman(String arabicString) {
        Integer arabicNumber = new Integer(arabicString);
        convert(arabicNumber);
        final String result = roman.toString();
        return result;
    }

    void convert(Integer arabicNumber) {
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
