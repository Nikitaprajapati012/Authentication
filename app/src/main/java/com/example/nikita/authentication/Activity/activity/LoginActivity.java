package com.example.nikita.authentication.Activity.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikita.authentication.Activity.presenter.LoginPresenter;
import com.example.nikita.authentication.Activity.presenter.LoginPresenterImpl;
import com.example.nikita.authentication.Activity.view.LoginView;
import com.example.nikita.authentication.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    public EditText edEmail, edPassword;
    public TextView txtSubmit;
    public String strEmail, strPassword;
    public LoginPresenter presenter;
    public LoginView activityView;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewId();
        init();
        getValues();
    }

    // TODO: 24/8/17 get data which empty by user.
    private void getValues() {
        strEmail = edEmail.getText().toString().trim();
        strPassword = edPassword.getText().toString().trim();
    }

    // TODO: 24/8/17 initilization
    private void init() {
        presenter = new LoginPresenterImpl(this);
        txtSubmit.setOnClickListener(this);
    }

    // TODO: 24/8/17 bind the widget
    private void findViewId() {
        edEmail = (EditText) findViewById(R.id.activity_login_edemail);
        edPassword = (EditText) findViewById(R.id.activity_login_edpassword);
        txtSubmit = (TextView) findViewById(R.id.activity_login_txtsubmit);
        progressBar = (ProgressBar) findViewById(R.id.activity_login_progressbar);
    }

    @Override
    public void onShowToast(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchHomeActivity() {
        Log.d("launchHomeActivity", "@@--Enter--");
        onShowToast(getApplicationContext().getResources().getString(R.string.loginsucess));
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        edEmail.setError(getApplicationContext().getResources().getString(R.string.emailempty));
    }

    @Override
    public void setWrongUsernameError() {
        edEmail.setError(getApplicationContext().getResources().getString(R.string.invalidemail));
    }

    @Override
    public void setPasswordError() {
        edPassword.setError(getApplicationContext().getResources().getString(R.string.pwdempty));
    }

    @Override
    public void setWrongPasswordError() {
        edPassword.setError(getApplicationContext().getResources().getString(R.string.validpwd));
    }

    @Override
    public Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(strEmail, strPassword);
    }
}
