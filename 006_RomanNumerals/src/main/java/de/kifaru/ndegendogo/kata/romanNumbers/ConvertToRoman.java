package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(String arabic) {
        return "I";
    }

    public static void main(String[] args) {
        String arabic = args[0];
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
