package utils.Commons;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {

    private static final int DEFAULT_WAIT = 5;
    private static String DEFAULT_BROWSER = "chrome";

        private static Properties defaultProperties = null;

        static {
            defaultProperties = new Properties();
            try {
                defaultProperties.load(new FileReader("src/test/java/config/system.properties"));
              } catch (IOException exception) {
                System.err.println("Error al Leer Properties");
            }

            if (!defaultProperties.isEmpty()) {
                for (Object key : defaultProperties.keySet()) {
                    if (System.getProperty((String)key) != null) {
                        defaultProperties.setProperty((String)key, System.getProperty((String)key));
                    }
                }
            }
        }


    /**
     * Gets the maximum wait time the application should wait until an element is present/visible/etc. This default
     * to 5, unless otherwise provided via cmd
     *
     * @return int - the maximum number of seconds to wait
     */
    public static int getDefaultWait() {
        if (System.getProperty("default.wait") != null) {
            try {
                return Integer.parseInt(System.getProperty("default.wait"));
            } catch (Exception e) {
                return DEFAULT_WAIT;
            }
        }
        return DEFAULT_WAIT;
    }

    /**
     * Gets browser. The default is Chrome
     * unless otherwise provided via cmd
     */
    public static String getDefaultBrowser() {
        String browser = getPropertyValue("browser");
        //String browser = System.getProperty("browser");
        if (browser != null) {
            try {
                switch (browser) {
                    case "firefox":
                        DEFAULT_BROWSER = "firefox";
                        break;
                    case "ie":
                        DEFAULT_BROWSER = "ie";
                        break;
                }
            } catch (Exception e) {
                return DEFAULT_BROWSER;
            }
        }
        return DEFAULT_BROWSER;
    }


    public static String getPropertyValue(String key) {
        return defaultProperties.getProperty(key);
    }

}
