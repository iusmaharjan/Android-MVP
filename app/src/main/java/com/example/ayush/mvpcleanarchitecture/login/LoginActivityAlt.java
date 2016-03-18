package com.example.ayush.mvpcleanarchitecture.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ayush.mvpcleanarchitecture.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivityAlt extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    @Bind(R.id.activity_login_edittext_email)
    EditText emailEditText;

    @Bind(R.id.activity_login_edittext_password)
    EditText passwordEditText;

    @Bind(R.id.activity_login_button_signin)
    Button signinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alt);

        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    public void setUsernameError() {
        emailEditText.setError(getString(R.string.error_email));
    }

    @Override
    public void setPasswordError() {
        passwordEditText.setError(getString(R.string.error_password));
    }

    @Override
    public void loginUser() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.activity_login_button_signin)
    public void login() {
        presenter.validateCredentials(emailEditText.getText().toString(), passwordEditText.getText().toString());
    }

}
