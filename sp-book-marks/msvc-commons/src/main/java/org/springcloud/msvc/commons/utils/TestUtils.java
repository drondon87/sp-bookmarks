package org.springcloud.msvc.commons.utils;

public class TestUtils {

    public static String transformDataObject(String data) {
        int commaLocation = 0;

        if (data.indexOf("}") < 0) {
            commaLocation = data.indexOf(",");
            return data.substring(0, commaLocation);
        }

        if (data.indexOf("},") < 0) {
            commaLocation = data.indexOf("}}");
            return data.substring(0, commaLocation);
        }

        commaLocation = data.indexOf("},");
        return data.substring(0, commaLocation);
    }

    public static String transformDataObjectSingleObject(String data) {
        int commaLocation = 0;

        if (data.indexOf("}") < 0) {
            commaLocation = data.indexOf(",");
            return data.substring(0, commaLocation);
        }

        if (data.indexOf("},") < 0) {
            commaLocation = data.indexOf("}");
            return data.substring(0, commaLocation);
        }

        commaLocation = data.indexOf("},");
        return data.substring(0, commaLocation);
    }
}
