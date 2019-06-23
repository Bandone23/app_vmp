package com.example.personal.MenuOne;

public class MenuoneModelo implements Menuone.Modelo {


    private Menuone.Presentador presentador ;

    String result ="";



    public MenuoneModelo(Menuone.Presentador presentador) {
        this.presentador = presentador;
    }

    @Override
    public void  doPartido(String tcuarto,String tpartido, String equipos) {





        int num = Integer.parseInt(tcuarto);
        int tpart = (num * 4);
        result = String.valueOf(tpart);

                presentador.pshowResult(result);





        //int num = Integer.parseInt(txt_tcuarto.getText().toString());
        //txt_tpartido.setText(String.valueOf(num * 4)+" Min");

    }
}
