package utils;

import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by plotnikvk.
 */

public class Stash {
    private static Map<String, Object> stash = new HashMap<>();

    public static void put(String key, Object value){
        stash.put(key, value);
    }

    public static WebDriver getDriver(){
        return (WebDriver) stash.get("driver");
    }
}
