package com.example.personal.MenuOne;

public interface Menuone {
    interface Vista {


        boolean isvalidTcuarto();

        boolean isvalidTpartido();

        boolean isvalidEquipos();

        void handlePartido();

        void onPartido();

        void onError(String error);

        void vshowResult(String resultado); //View

    }

    interface Presentador {

        void onDestroy(); // sera para borrar una vista y liberar memoria

        void toPartido(String tcuarto,String tpartido, String equipos); // recibe los parametros del partido

        void pshowResult(String resultado); //View

    }
    interface  Modelo {

        void doPartido(String tcuarto,String tpartido, String equipos);

    }

    interface  TaskListener{
        void onSucess();

        void onError(String error);



    }
}
