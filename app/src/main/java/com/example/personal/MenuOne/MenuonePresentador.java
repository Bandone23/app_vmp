package com.example.personal.MenuOne;

public class MenuonePresentador  implements Menuone.Presentador,Menuone.TaskListener{

    private Menuone.Vista  vista ;
    private  Menuone.Modelo modelo ;

    public MenuonePresentador(Menuone.Vista vista) {
        this.vista = vista;
        modelo = new MenuoneModelo(this);

    }

    @Override
    public void onDestroy() {
        vista = null ;

    }

    @Override
    public void toPartido(String tcuarto,String tpartido, String equipos) {
        if (vista!= null){


        }
      modelo.doPartido(tcuarto,tpartido, equipos);


    }

    @Override
    public void onSucess() {
        if (vista!=null){

            vista.onPartido();
        }


    }

    @Override
    public void onError(String error) {
        if (vista!=null){

            vista.onError(error);
        }



    }

    @Override
    public void pshowResult(String resultado) {
        if (vista!=null){
            vista.vshowResult(resultado);
        }

    }

    @Override
    public void presultFireb(String dato) {
        if (vista != null){
            vista.resultFireb( dato);
        }

    }

    @Override
    public void perrorFirebase(String error) {
        if (vista != null){
            vista.errorFirebase("Error desde Firebase");
        }

    }

    @Override
    public void ponSucessSave() {
        if (vista != null){

        }

    }
}
