package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    private StringBuilder roman;
    private int arabicNumber;

    private ConvertToRoman(int arabicNumber) {
        roman = new StringBuilder();
        this.arabicNumber = arabicNumber;
    }

    static String convert(int arabicNumber) {
        ConvertToRoman converter = new ConvertToRoman(arabicNumber);
        converter.convert();
        final String result = converter.roman.toString();
        return result;
    }

    private void convert() {
        appendDigits(1000, "M");
        appendDigits(900, "CM");
        appendDigits(500, "D");
        appendDigits(400, "CD");
        appendDigits(100, "C");
        appendDigits(90, "XC");
        appendDigits(50, "L");
        appendDigits(40, "XL");
        appendDigits(10, "X");
        appendDigits(9, "IX");
        appendDigits(5, "V");
        appendDigits(4, "IV");
        appendDigits(1, "I");
    }

    private void appendDigits(final int value, final String digit) {
        while (arabicNumber >= value) {
            arabicNumber -=value;
            roman.append(digit);
        }
    }

    public static void main(String[] args) {
        String arabicString = args[0];
        int arabicNumber = Integer.parseInt(arabicString);
        String roman = ConvertToRoman.convert(arabicNumber);
        System.out.println(roman);
    }

}
