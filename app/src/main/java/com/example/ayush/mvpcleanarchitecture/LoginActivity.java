package com.example.ayush.mvpcleanarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.activity_login_edittext_email)
    EditText emailEditText;

    @Bind(R.id.activity_login_edittext_password)
    EditText passwordEditText;

    @Bind(R.id.activity_login_button_signin)
    Button signinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }
}
