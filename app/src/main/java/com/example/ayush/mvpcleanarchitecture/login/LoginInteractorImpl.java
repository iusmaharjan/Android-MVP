package com.example.ayush.mvpcleanarchitecture.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor{

    @Override
    public void login(final String email, final String password, final OnLoginFinishedListener listener) {

        // Creating handler to delay the login process
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;

                // Email should not be empty
                if(TextUtils.isEmpty(email)) {
                    listener.onUsernameError();
                    error = true;
                }

                // Password should not be empty
                if(TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                }

                // If there is no error, login is successful and onSuccess() is called
                if(!error) {
                    listener.onSuccess();
                }
            }
        }, 0);
    }
}
