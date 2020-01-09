package helpers;

import data.DBlink;
import ru.yandex.qatools.allure.annotations.Step;

public class DBlinkHelper {

    public static final String TOKEN_KEY = "Z0pDmg*s&4mDkfU4@afH";
    public String DB_LINK = null;

    @Step("Setup DB link")
    public String setupLink(DBlink dBlink) {
        DB_LINK = replaceDate(dBlink);
        DB_LINK = DB_LINK + secureToken(DB_LINK.replaceAll("/request/", ""));
        System.out.println(DB_LINK);
        return DB_LINK;
    }

    public String replaceDate(DBlink dBlink) {
        if (dBlink.getLink().contains("YYYYMMDDOUT") && dBlink.getLink().contains("YYYYMMDDIN")) {
            return DB_LINK = dBlink.getLink().replaceAll("YYYYMMDDOUT", dBlink.getOutwardDate()).replaceAll("YYYYMMDDIN", dBlink.getInwardDate());
        } else {
            return DB_LINK = dBlink.getLink().replaceAll("YYYYMMDDOUT", dBlink.getOutwardDate());
        }
    }


    public static String secureToken(String url) {
        return "&SECURE_TOKEN=" + org.apache.commons.codec.digest.DigestUtils.sha256Hex(url + TOKEN_KEY);
    }


}
