package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    private StringBuilder roman;
    private Integer arabicNumber;

    ConvertToRoman(String arabicString) {
    }

    static String getRoman(String arabicString) {
        ConvertToRoman converter = new ConvertToRoman(arabicString);
        converter.roman = new StringBuilder();
        converter.arabicNumber = new Integer(arabicString);
        converter.convert();
        final String result = converter.roman.toString();
        return result;
    }

    private void convert() {
        makeSequence(1000, "M");
        makeSequence(900, "CM");
        makeSequence(500, "D");
        makeSequence(400, "CD");
        makeSequence(100, "C");
        makeSequence(90, "XC");
        makeSequence(50, "L");
        makeSequence(40, "XL");
        makeSequence(10, "X");
        makeSequence(9, "IX");
        makeSequence(5, "V");
        makeSequence(4, "IV");
        makeSequence(1, "I");
    }

    private void makeSequence(final int value, final String digit) {
        while (arabicNumber >= value) {
            arabicNumber -=value;
            roman.append(digit);
        }
    }

    public static void main(String[] args) {
        String arabic = args[0];
        ConvertToRoman converter = new ConvertToRoman(arabic);
        String roman = ConvertToRoman.getRoman(arabic);
        System.out.println(roman);
    }

}
