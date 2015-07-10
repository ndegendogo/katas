package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(int arabic) {
        return "I";
    }

    public static void main(String[] args) {
        String arabicString = args[0];
        int arabic = Integer.parseInt(arabicString);
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
