package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    private StringBuilder roman;
    private Integer arabicNumber;

    ConvertToRoman(String arabicString) {
        roman = new StringBuilder();
        arabicNumber = new Integer(arabicString);
        convert();
    }

    String getRoman() {
        final String result = roman.toString();
        return result;
    }

    private void convert() {
        makeSequence(1000, "M");
        makeSequence(500, "D");
        makeSequence(400, "CD");
        makeSequence(100, "C");
        makeSequence(50, "L");
        makeSequence(40, "XL");
        makeSequence(10, "X");
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
        String roman = converter.getRoman();
        System.out.println(roman);
    }

}
