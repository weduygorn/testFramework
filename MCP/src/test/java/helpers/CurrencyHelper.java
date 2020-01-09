package helpers;

public class CurrencyHelper {

    public static Double toDouble(String value) {
        return Double.parseDouble(value.replaceAll(",", "."));
    }
}
