package de.kifaru.ndegendogo.kata.romanNumbers;

public class ConvertToRoman {

    static String arabToRoman(int arabic) {
        StringBuilder roman = new StringBuilder();
        roman.append("I");
        if (arabic > 1) {
            roman.append("I");
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        int arabic = Integer.parseInt(args[0]);
        String roman = arabToRoman(arabic);
        System.out.println(roman);
    }

}
