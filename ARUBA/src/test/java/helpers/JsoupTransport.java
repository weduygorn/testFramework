package helpers;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsoupTransport {
    static final int REQ_TIMEOUT = 60000;
    public Connection.Response response = null;


    @Step
    public Connection.Response sendRequest(String url, Map<String, String> requestData, Connection.Method method) {

        return sendRequest(url, requestData, new HashMap<>(), method);
    }

    @Step
    public Connection.Response sendRequest(String url, Map<String, String> requestData, Map<String, String> cookies, Connection.Method method) {
        Connection.Response getResponse = null;
        try {
            getResponse = Jsoup.connect(url)
                    .timeout(REQ_TIMEOUT)
                    .userAgent("jsoup")
                    .cookies(cookies)
                    .data(requestData)
                    .followRedirects(true)
                    .method(method)
                    .validateTLSCertificates(false)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            attachPageHtml(getResponse);
        response = getResponse;
        }
        return response;
    }

    public Map<String, String> getCookies() {
        return response.cookies();
    }



    @Attachment(type = "text/html")
    public String attachPageHtml(Connection.Response response){
        return response.body();
    }

    @Step
    public Connection.Response loginToAdmAndGetCookies(String app_url) {
        Map<String, String> requestData = new HashMap<>();
        requestData.put("_username", "admin");
        requestData.put("_password", "beautifullORangry");
        return sendRequest(app_url + "/login", requestData, new HashMap<>(), Connection.Method.POST);

    }

    @Step
    public Connection.Response log_Out(String endpoint) {
        return sendRequest(endpoint + "ru/logout",
                new HashMap<>(), response.cookies(), Connection.Method.GET);
    }

}
