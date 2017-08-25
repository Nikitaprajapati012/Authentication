package com.example.nikita.authentication.Activity.iteractor;

/*** Created by nikita on 24/8/17.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String pass = "";
    private boolean statusValidation = false;
    private int statusLogin = 0;

    @Override
    public void login(final String username,
                      final String password,
                      final OnLoginFinishedListener listener) {

        if (statusValidation = true) {
            // TODO: 25/8/17 validate the username/email
            if (username.equalsIgnoreCase("")) {
                listener.onUsernameError();
            } else {
                if (username.matches(emailPattern)) {
                    listener.onWrongUsernameError();
                } else {
                    listener.onSuccess();
                }
            }
            statusValidation = true;
        }
        if (statusValidation = true) {
            // TODO: 25/8/17 validate the password
            if (password.equalsIgnoreCase("")) {
                listener.onPasswordError();
            } else {
                //match with the right password
                if (password.matches(pass)) {
                    listener.onWrongPasswordError();
                } else {
                    listener.onSuccess();
                }
            }
            statusValidation = true;
        }
        if (statusValidation = false) {
            statusValidation = false;

        }
    }
}
