package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop;

    public ConfigReader() {
        readConfig();
    }

    private void readConfig() {
        try {
            File src = new File("./configuration.properties");
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Error reading configuration file  " + e.getMessage());
        }
    }

    public String getUrl() {
        return prop.getProperty("geoVisionUrl");
    }
    public String getUrlDashborad(){
        return prop.getProperty("geoVisionDashboard");
    }
    public String getPathForCity(){
        return prop.getProperty("filePathForCityFile");
    }
    public String getUsername() {
        return prop.getProperty("geoVisionUsername");
    }
    public String getPassword() {
        return prop.getProperty("geoVisionPassword");
    }
}
