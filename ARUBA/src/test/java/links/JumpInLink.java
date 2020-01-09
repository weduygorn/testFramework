package links;

import core.properties.PropertyConfig;
import helpers.Logging;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.blocks.LoadingContainer;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import static helpers.URLDecoder.decode;

public class JumpInLink extends BasePage implements Logging {

    private String URL;
    public String LANGUAGE= null;
    private Map<String, String> map = new HashMap<String, String>();
    public LoadingContainer loadingContainer;


    /**
     * Constructor
     *
     * @param driver
     */
    public JumpInLink(WebDriver driver) {
        super(driver);
    }

    public String getJumpInLinkUrl() {
        return driver.getCurrentUrl();
    }

    private Map<String, String> jumpInMap() {

        URL = getJumpInLinkUrl().split("\\?")[1];
        char firstChar = URL.charAt(0);
        if(firstChar == '&'){
            URL = URL.substring(1);
        }

        String[] params = URL.split("&");
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    public String getLanguage() {
        try {
            URL url = new URL(getJumpInLinkUrl());
            LANGUAGE = url.getPath().replaceAll("[^a-zA-Z]", "");
            return LANGUAGE;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOriginUIC() {
        return jumpInMap().get("originUIC");
    }

    public String getOriginName(){
        return decode(jumpInMap().get("originName"));
    }

    public String getDestinationUIC() {
        return jumpInMap().get("destinationUIC");
    }

    public String getDestinationName() {
        return decode(jumpInMap().get("destinationName"));
    }

    public String getDateTime() {
        return jumpInMap().get("dateTime");
    }

    public String getSearchMode() {
        return jumpInMap().get("SM");
    }

    public String getLayoutMode() {
        return jumpInMap().get("LM");
    }

    public Float getCurrencyRate() {
        return Float.parseFloat(jumpInMap().get("CR"));
    }

    public String getBackURL() {
        return jumpInMap().get("backURL");
    }

    public String getShopURL() {
        return jumpInMap().get("shopURL");
    }

    public String getSecureToken() {
        return jumpInMap().get("SecureToken");
    }

    public int getJumpInMapSize() {
        return jumpInMap().size();
    }

    @Step("JumpInLink build [{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}]")
    public void build(String language, String originUIC, String originName, String destinationUIC, String destinationName, String dateTime, String sm, String lm, String cr, String backUrl, String shopUrl, String secureToken) {
        try {
            URIBuilder builder = new URIBuilder()
                    .setScheme("https")
                    .setHost(PropertyConfig.getProperty("cfd.host"))
                    .setPath("/"+language)
                    .addParameter("originUIC", originUIC)
                    .addParameter("originName", helpers.URLEncoder.encode(originName))
                    .addParameter("destinationUIC", destinationUIC)
                    .addParameter("destinationName", helpers.URLEncoder.encode(destinationName))
                    .addParameter("dateTime", dateTime)
                    .addParameter("SM", sm)
                    .addParameter("LM", lm)
                    .addParameter("CR", cr)
                    .addParameter("backURL", backUrl)
                    .addParameter("shopURL", shopUrl)
                    .addParameter("SecureToken", secureToken);
            URI uri = builder.build();
            LOG.info(originName + " -> " + destinationName + " : " + URLDecoder.decode(uri.toString(), "UTF-8"));
            attachText("JumpInLink", URLDecoder.decode(uri.toString(), "UTF-8"));
            driver.get(URLDecoder.decode(uri.toString(), "UTF-8"));
            LANGUAGE = language;
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        waitForElementInvisible(By.cssSelector(loadingContainer.GLOBAL_LOADING_ANIM_CSS), 60);
    }

    public String generateSecureToken(String originUIC, String originName, String destinationUIC, String destinationName, String dateTime,
    String sm, String lm, String cr, String backURL, String shopURL) {
        return DigestUtils.sha256Hex("originUIC="+originUIC+"&originName="+helpers.URLEncoder.encode(originName)+"&destinationUIC="+destinationUIC+"&destinationName="+helpers.URLEncoder.encode(destinationName)+
                "&dateTime="+dateTime+"&SM="+sm+"&LM="+lm+"&CR="+cr+"&backURL="+backURL+"&shopURL="+shopURL+ PropertyConfig.getProperty("token.key"));
    }

    public String replaceHost() {
        try {
            URL url = new URL(getJumpInLinkUrl());
            return url.getProtocol() + "://" + PropertyConfig.getProperty("cfd.host") + url.getPath()+ "?" + url.getQuery();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        return null;
    }

}
