package awesomecucumber.utils;

import awesomecucumber.constants.EnvType;

import java.io.File;
import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader configLoader;
    private final Properties properties;

    public ConfigLoader() {
        String env = System.getProperty("env") == null ? String.valueOf(EnvType.STG) : System.getProperty("env");
        switch (EnvType.valueOf(env)) {
            case STG ->
//                    properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + "/src/test/resources/stg_config.properties");
            properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "stg_config.properties");
            case PRD ->
                    properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + "/src/test/resources/prd_config.properties");
            default -> throw new IllegalStateException("INVALID ENVIRONMENT : " + env);
        }
//        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + "/src/test/resources/stg_config.properties");
    }

    public static ConfigLoader getInstance(){
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (properties != null) {
            return prop;
        }
        else throw new RuntimeException("Property baseUrl is not specified in stg_config.properties file");
    }

    public String getProp(String key){
        return properties.getProperty(key);
    }

}
