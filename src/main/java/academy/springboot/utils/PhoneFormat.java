package academy.springboot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneFormat {

    public PhoneFormat() {}

    public static Boolean isHomePhone(String phoneNumber) {
        if(phoneNumber.equals(null)) return false;
        else {
            String newPhoneNumber = String.valueOf(phoneNumber.matches("[0-9]+"));
            return newPhoneNumber.replace("051", "").startsWith("3");
        }
    }

    //public static
}
