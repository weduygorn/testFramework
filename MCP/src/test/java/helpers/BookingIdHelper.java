package helpers;

public class BookingIdHelper {
    public static String getBookingIdwithoutPrefix(String baseId, String prefix) {

        if (baseId.contains(prefix)) {
            return baseId.replaceAll(prefix, "");
        } else {
            System.out.println("booking id is not contains prefix '" + prefix + "'");
            return baseId;
        }
    }
}
