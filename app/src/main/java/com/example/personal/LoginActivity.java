package com.example.personal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personal.login.Login;
import com.example.personal.login.LoginPresentador;

public class LoginActivity extends AppCompatActivity implements Login.Vista {

    //*** declaracion de varibles  ****

    private EditText txt_email, txt_password;
    private Button btn_singin;
    private TextView btn_registrar_L;
    private ProgressBar progress_bar;
    private Login.Presentador presentador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        btn_singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handleLogin();

            }
        });
    }

    private void setView() {
        presentador = new LoginPresentador(this);
        txt_email = findViewById(R.id.etxt_email);
        txt_password = findViewById(R.id.etxt_password);
        btn_singin = findViewById(R.id.btn_login);
        btn_registrar_L = findViewById(R.id.btn_registrar_L);
        progress_bar = findViewById(R.id.progressBar);


    }

    private void setImputs(boolean enable) {

        txt_email.setEnabled(enable);
        txt_password.setEnabled(enable);
        btn_singin.setEnabled(enable);
        btn_registrar_L.setEnabled(enable);
    }

    @Override
    public void disableImputs() {

        setImputs(false);

    }

    @Override
    public void enableImputs() {

        setImputs(true);

    }

    @Override
    public void showProgress() {
        progress_bar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progress_bar.setVisibility(View.GONE);

    }


    @Override
    public void handleLogin() {

        if (!isvalidEmail()) {
            Toast.makeText(this, "No es un correo Valido", Toast.LENGTH_SHORT).show();
        } else if (!isvalidPassword()) {
            Toast.makeText(this, "No es un password Valido", Toast.LENGTH_SHORT).show();
        }else {
            presentador.toLogin(txt_email.getText().toString().trim(),txt_password.getText().toString().trim());
        }

    }

    @Override
    public boolean isvalidEmail() {
        return Patterns.EMAIL_ADDRESS.matcher(txt_email.getText().toString()).matches();
    }

    @Override
    public boolean isvalidPassword() {
        if (TextUtils.isEmpty(txt_password.getText().toString()) && txt_password.getText().toString().length() < 4) {
            Toast.makeText(this, "No es una contraseña correcta", Toast.LENGTH_SHORT).show();

            txt_password.setError("No es una contraseña Valida");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onLogin() {
        Toast.makeText(this, "Has hecho login correctamente", Toast.LENGTH_SHORT).show();
        startActivity( new Intent(this,MenuoneActivity.class));

    }

    @Override
    public void onError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }


    public void otherActivity(View view) {

            startActivity( new Intent(this,RegistryActivity.class));

            }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentador.onDestroy();
    }
}
