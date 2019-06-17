package com.example.personal.login;

import android.view.View;

public interface Login {

    // ***************  VISTA HACE LO VISUAL *********************
    interface Vista {

        void disableImputs();

        void enableImputs();

        void showProgress();

        void hideProgress();

        boolean isvalidEmail();

        boolean isvalidPassword();

        void handleLogin();

        void onLogin();

        void onError(String error);



    }

    // *********** PRESENTADOR ENVIA A MODELO ***************
    interface Presentador {

        void onDestroy(); // sera para borrar una vista y liberar memoria

        void toLogin(String email, String password); // recibe parametros de Handlelogin
    }

    // ***************** MODELO *********************
    interface Modelo {

        void doLogin(String email, String password); // recibe parametros de tologin
    }

    //*********** SIEMPRE ESTA ESCUCHANDO QUE PASA ************************
    interface TaskListener {
        void onSucess();

        void onError(String error);


    }


}
