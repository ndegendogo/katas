package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    private StringBuilder roman;
    private Integer arabicNumber;

    ConvertToRoman(String arabicString) {
        roman = new StringBuilder();
        arabicNumber = new Integer(arabicString);
    }

    String arabToRoman() {
        convert();
        final String result = roman.toString();
        return result;
    }

    private void convert() {
        {
            final int value = 5;
            final String digit = "V";
            while (arabicNumber >= value) {
                arabicNumber -=value;
                roman.append(digit);
            }
        }
        {
            final int value = 1;
            final String digit = "I";
            while (arabicNumber >= value) {
                arabicNumber -=value;
                roman.append(digit);
            }
        }
    }

    public static void main(String[] args) {
        String arabic = args[0];
        ConvertToRoman converter = new ConvertToRoman(arabic);
        String roman = converter.arabToRoman();
        System.out.println(roman);
    }

}
