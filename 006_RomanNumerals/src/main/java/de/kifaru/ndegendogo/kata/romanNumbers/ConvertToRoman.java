package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(String arabicString) {
        Integer arabicNumber = new Integer(arabicString);
        StringBuilder roman = new StringBuilder();
        while (arabicNumber > 0) {
            roman.append("I");
            arabicNumber -=1;
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        String arabic = args[0];
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
