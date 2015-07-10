package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(int arabic) {
        return "I";
    }

    public static void main(String[] args) {
        int arabic = Integer.parseInt(args[0]);
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
