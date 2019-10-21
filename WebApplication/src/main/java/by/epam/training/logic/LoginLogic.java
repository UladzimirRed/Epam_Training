package by.epam.training.logic;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "123";
    public static boolean checkLogin(String enterLogin, String enterPassword){
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPassword);
    }
}
