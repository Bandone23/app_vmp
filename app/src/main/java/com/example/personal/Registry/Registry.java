package com.example.personal.Registry;

public interface Registry {

    interface  Vista {

        void disableImputs();

        void enableImputs();

        void showProgress();

        void hideProgress();

        boolean isvalidEmail();

        boolean isvalidPassword();

        void handleRegistry();

        void onRegistry();

        void onError(String error);

    }

    interface  Presentador {

        void onDestroy(); // sera para borrar una vista y liberar memoria

        void toRegistry(String name ,String email, String password); // recibe parametros de Handlelogin

    }

    interface  Modelo {

        void doRegistry(String name ,String email,String password);

    }

    interface TaskListener {

        void onSucess();

        void onError(String error);

    }

}
