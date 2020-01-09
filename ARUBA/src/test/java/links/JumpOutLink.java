package links;

import helpers.AllureAssert;
import helpers.URLDecoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class JumpOutLink extends BasePage {

    private String URL;
    private String LANGUAGE= "en";
    private Map<String, String> map = new HashMap<String, String>();

    /**
     * Constructor
     *
     * @param driver
     */
    public JumpOutLink(WebDriver driver) {
        super(driver);
    }

    public String getJumpOutLinkUrl() {
        return URLDecoder.decode(driver.getCurrentUrl());
    }

    private Map<String, String> jumpOutMap() {
        try{
            URL = getJumpOutLinkUrl().split("\\?")[1];
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
        } catch (Exception e) {
            AllureAssert.fail(getJumpOutLinkUrl() + " not valid!");
        }
       return null;
    }

    public JSONObject getConnection()  {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(URLDecoder.decode(jumpOutMap().get("connection")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return null;
    }
}
