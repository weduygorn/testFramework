package helpers;

import core.properties.PropertyConfig;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ivanchik on 18.07.2016.
 */
public class FileDownloadHelper {

    private static final String USER_NAME= "admin";
    private static final String PASSWORD = "beautifullORangry";

    public static final int timeout = 0;
    

    /**
     * Download coupon as byte
     *
     * @param downloadUrl
     * @return
     */
    public static byte[] downloadFileAsbyte(String downloadUrl) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("_username", USER_NAME);
        requestData.put("_password", PASSWORD);

        Connection.Response response = new JsoupTransport().sendRequest(PropertyConfig.getProperty("admin.host") + "/login", requestData, Connection.Method.POST);

        Map<String, String> cookieMap = response.cookies();

        System.out.println("------------Cookies and headers------------");
        System.out.println("cookies="+cookieMap);
        System.out.println("-------------------------------------------");

        Connection.Response resultDownloadResponse = null;

        try {
            resultDownloadResponse = Jsoup.connect(URLDecoder.decode(downloadUrl))
                    .cookies(cookieMap)
                    .timeout(timeout)
                    .validateTLSCertificates(false)
                    .userAgent("jsoup")
                    .ignoreContentType(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultDownloadResponse.bodyAsBytes();
    }


    public static File byteArrayToFile(byte[] fileByteArray, String pathForFile) {
        File file = new File(pathForFile);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(fileByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return file;
    }

}
