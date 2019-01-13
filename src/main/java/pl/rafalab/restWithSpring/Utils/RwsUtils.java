package pl.rafalab.restWithSpring.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RwsUtils {
    public static boolean checkEmailOrPassword(String pattern, String toMatch) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(toMatch);
        return matcher.matches();
    }
}
