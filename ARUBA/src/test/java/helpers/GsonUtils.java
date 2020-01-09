package helpers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonUtils {

    private static Gson gson;
    private static String LANGUAGE_JSON_MAP_PATH = System.getProperty("user.dir") + "//src//test//java//testData//translationProvider.json";

    public static Gson get()  {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static String getText(String param, String language)  {
        JsonObject jsonObject = null;
        try {
            jsonObject = GsonUtils.get().fromJson(new FileReader(LANGUAGE_JSON_MAP_PATH), JsonObject.class).getAsJsonObject(param);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObject.get(language).getAsString();
    }
}
