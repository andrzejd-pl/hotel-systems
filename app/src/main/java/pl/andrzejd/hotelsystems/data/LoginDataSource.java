package pl.andrzejd.hotelsystems.data;

import pl.andrzejd.hotelsystems.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin1";

    public Result<LoggedInUser> login(String username, String password) {
        if (LOGIN.equals(username) && PASSWORD.equals(password)) {
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            username);
            return new Result.Success<>(fakeUser);
        }
        return new Result.Error(new IOException("Error logging in"));
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
