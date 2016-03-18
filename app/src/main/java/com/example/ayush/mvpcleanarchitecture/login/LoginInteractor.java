package com.example.ayush.mvpcleanarchitecture.login;

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    void login(String email, String password, OnLoginFinishedListener listener);
}
