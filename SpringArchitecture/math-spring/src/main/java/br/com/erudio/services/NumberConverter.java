package br.com.erudio.services;

public class NumberConverter {
    /*
     * Converter uma String em um valor do tipo Double
     * @param PathVariable de um numero
     * @param PathVariable de um numero
     * @return A soma de dois números
     * */
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumber(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumber(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
