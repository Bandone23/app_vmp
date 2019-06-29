package com.example.personal.MenuOne;

public interface Menuone {
    interface Vista {


        boolean isvalidTcuarto();

        boolean isvalidEquipos();

        void handlePartido();

        void onPartido();

        void onError(String error);

        void vshowResult(String resultado); //View

        void resultFireb(String dato);
        void errorFirebase(String error);
        void onSucessSave();

    }

    interface Presentador {

        void onDestroy(); // sera para borrar una vista y liberar memoria

        void toPartido(String tcuarto, String tpartido, String equipos); // recibe los parametros del partido

        void escuchoPartidosP();

        void pshowResult(String resultado); //View

        void presultFireb(String dato);

        void perrorFirebase(String error);

        void ponSucessSave ();

    }

    interface Modelo {

        void doPartido(String tcuarto, String tpartido, String equipos);

        void escuchoPartidos();

    }

    interface TaskListener {
        void onSucess();

        void onError(String error);


    }
}
