package helpers;

import com.google.gson.Gson;

public class GsonUtils {

    private static Gson gson;

    public static Gson get() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

}
