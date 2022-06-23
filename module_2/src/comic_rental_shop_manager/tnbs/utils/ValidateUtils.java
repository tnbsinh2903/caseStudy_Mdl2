package comic_rental_shop_manager.tnbs.utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String USER_REGEX = "^([a-z]+[0-9]*[ ]?)+$";
    public static final String PASSWORD_REGEX = "^([a-zA-Z0-9]{8,})";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{7,8}$";


    public static boolean isNameValidate(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }
    public static boolean isUserNameValid(String password){
        return Pattern.compile(USER_REGEX).matcher(password).matches();
    }
    public static boolean isPasswordValid(String password){
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public static boolean isPhoneValid(String number){
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }

}
