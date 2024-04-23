package constants;

import java.io.File;

public class StringConstant {

        public StringConstant(){}

        public String APPLICATION_URL() {
            return "https://suniljindal.com/";
        }

    public String log4jFilePath() {
        return System.getProperty("user.dir") + File.separator + "config/log4j.properties";
    }
}
