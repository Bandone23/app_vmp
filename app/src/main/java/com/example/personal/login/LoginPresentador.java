package com.example.personal.login;

import com.example.personal.LoginActivity;
import com.example.personal.login.Login;

public class LoginPresentador implements Login.Presentador ,Login.TaskListener{

    private Login.Vista vista;
    private Login.Modelo modelo;

    public LoginPresentador(Login.Vista vista) {
        this.vista = vista;
        modelo = new LoginModelo(this);
    }

    @Override
    public void onDestroy() {
        vista = null;

    }

    @Override
    public void toLogin(String email, String password) {
        if (vista!=null){
            vista.disableImputs();
            vista.showProgress();

        }
        modelo.doLogin(email, password);

    }

    @Override
    public void onSucess() {
        if (vista!=null){
            vista.enableImputs();
           vista.hideProgress();
            vista.onLogin();
        }

    }

    @Override
    public void onError(String error) {
        if (vista!=null){
            vista.enableImputs();
           vista.hideProgress();
            vista.onError(error);
        }

    }
}
