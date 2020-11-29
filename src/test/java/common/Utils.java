package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

//http://thecodersbreakfast.net/index.php?post/2008/02/25/26-de-la-bonne-implementation-du-singleton-en-java
//Structure singleton
//    /**
//     * Constructeur privé
//     */
//    private Utils() {
//    }
//
//    /**
//     * Holder
//     */
//    private static class SingletonHolder {
//        /**
//         * Instance unique non préinitialisée
//         */
//        private final static Utils instance = new Utils();
//    }
//
//    /**
//     * Point d'accès pour l'instance unique du singleton
//     */
//    public static Utils getInstance() {
//        return SingletonHolder.instance;
//    }

    public static Object getData(String file) {
        Object data = null;
        try {
            InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream("data" + File.separator + file);
            JSONParser jsonParser = new JSONParser();
            data = jsonParser.parse(new InputStreamReader(inputStream));
            logger.debug("json file" + data.toString());
        } catch (org.json.simple.parser.ParseException pe) {
            logger.debug("error parsing file" + file, pe);
        } catch (IOException ioe) {
            logger.error("error loading" + file, ioe);
        }
        return data;
    }
}
