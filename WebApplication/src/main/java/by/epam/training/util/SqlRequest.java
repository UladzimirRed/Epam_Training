package by.epam.training.util;

public class SqlRequest {
    public static final String CHECK_USER_MATCHES =
            "SELECT login, password FROM profiles WHERE login =? AND password = ?";  //AND state_id=1";
    public static final String FIND_USER_BY_LOGIN =
            "SELECT id, login, password, role\n" +
                    "FROM profiles\n" +
                    "WHERE login = ?";
}
