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
    public String getUsername() {
        return prop.getProperty("geoVisionUsername");
    }
    public String getPassword() {
        return prop.getProperty("geoVisionPassword");
    }
    public String getDataSetAliasNameIL() {
        return prop.getProperty("dataSetAliasNameIL");
    }
    public String getDataSetDisplayNameIL() {
        return prop.getProperty("dataSetDisplayNameIL");
    }
    public String getDataSetIdIL() {
        return prop.getProperty("dataSetIdIL");
    }
    public String getDataPathIL() {
        return prop.getProperty("dataPathIL");
    }


    public String getDataSetAliasNameILCE() {
        return prop.getProperty("dataSetAliasNameILCE");
    }
    public String getDataSetDisplayNameILCE() {
        return prop.getProperty("dataSetDisplayNameILCE");
    }
    public String getDataSetIdILCE() {
        return prop.getProperty("dataSetIdILCE");
    }
    public String getParentColumnILCE() {
        return prop.getProperty("parentColumnILCE");
    }
    public String getDataPathILCE() {
        return prop.getProperty("dataPathILCE");
    }


    public String getDataSetAliasNameMah() {
        return prop.getProperty("dataSetAliasNameMah");
    }
    public String getDataSetDisplayNameMah() {
        return prop.getProperty("dataSetDisplayNameMah");
    }
    public String getDataSetIdMah() {
        return prop.getProperty("dataSetIdMah");
    }
    public String getParentColumnMah() {
        return prop.getProperty("parentColumnMah");
    }
    public String getDataPathMah() {
        return prop.getProperty("dataPathMah");
    }
}
