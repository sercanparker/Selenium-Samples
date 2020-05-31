package concrete;

/**
 * @author sercansensulun on 31.05.2020.
 */
public class IntegerUtils {

    public static Integer parseTLString(String input){
        String splitFromTL = input.split(" TL")[0];
        return Integer.valueOf(splitFromTL
                .replace(".", "")
                .replace(",",""));
    }

}
