package helpers;

import java.io.UnsupportedEncodingException;

public final class URLEncoder {

    public static String encode(String value) {
        try {
            return java.net.URLEncoder.encode(value, "Windows-1252").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
