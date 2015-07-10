package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(int arabic) {
        if (arabic > 1) {
            return "II";
        }
        return "I";
    }

    public static void main(String[] args) {
        int arabic = Integer.parseInt(args[0]);
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
