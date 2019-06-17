package com.example.personal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.personal.Registry.Registry;
import com.example.personal.Registry.RegistryPresentador;

public class RegistryActivity extends AppCompatActivity  implements Registry.Vista {

    private EditText txt_nombre,txt_email,txt_password_r;
    private Button btn_registrar;
    private ProgressBar progressBar;
    private Registry.Presentador presentador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        setView();
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               handleRegistry();

            }
        });
    }


    private void setView() {
        presentador = new RegistryPresentador(this);
        txt_email = findViewById(R.id.etxt_emailr);
        txt_password_r = findViewById(R.id.etxt_pass);
        btn_registrar = findViewById(R.id.btn_registrar);
        progressBar = findViewById(R.id.progressBar2);
        txt_nombre= findViewById(R.id.etxt_nombre);

    }

    private void setImputs(boolean enable) {

        txt_email.setEnabled(enable);
        txt_password_r.setEnabled(enable);
        btn_registrar.setEnabled(enable);
        txt_nombre.setEnabled(enable);
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
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public boolean isvalidEmail() {
        return Patterns.EMAIL_ADDRESS.matcher(txt_email.getText().toString()).matches();
    }

    @Override
    public boolean isvalidPassword() {

        if (TextUtils.isEmpty(txt_password_r.getText().toString()) && txt_password_r.getText().toString().length() < 4) {
            Toast.makeText(this, "No es una contraseña correcta", Toast.LENGTH_SHORT).show();
            txt_password_r.setError("Debe contener almenos 4 caracteres");
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void handleRegistry() {


        if (!isvalidEmail()) {
            Toast.makeText(this, "No es un correo Valido", Toast.LENGTH_SHORT).show();
        } else if (!isvalidPassword()) {
            Toast.makeText(this, "No es un password Valido", Toast.LENGTH_SHORT).show();
        }else {
            presentador.toRegistry(txt_nombre.getText().toString().trim(),txt_email.getText().toString().trim(),txt_password_r.getText().toString().trim());
        }


    }

    @Override
    public void onRegistry() {
        Toast.makeText(this, "Te registraste correctamente", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentador.onDestroy();
    }
}
