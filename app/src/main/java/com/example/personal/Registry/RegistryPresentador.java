package com.example.personal.Registry;

public class RegistryPresentador implements Registry.Presentador,Registry.TaskListener {


    private Registry.Vista vista;
    private Registry.Modelo modelo;

    public RegistryPresentador(Registry.Vista vista) {
        this.vista = vista;
        modelo = new Registrymodelo(this);
    }

    @Override
    public void onDestroy() {
        vista = null;

    }

    @Override
    public void toRegistry(String name,String email, String password) {
        if (vista!=null){
            vista.disableImputs();
            vista.showProgress();

        }
        modelo.doRegistry(name,email, password);


    }

    @Override
    public void onSucess() {
        if (vista!=null){
            vista.enableImputs();
            vista.hideProgress();
            vista.onRegistry();
            vista.previousActivity();
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
