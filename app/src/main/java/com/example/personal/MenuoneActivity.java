package com.example.personal;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personal.Adapters.ListviewAdapPartidos;
import com.example.personal.MenuOne.Menuone;
import com.example.personal.MenuOne.MenuonePresentador;
import com.example.personal.entidades.ListaPartidos;

import java.util.ArrayList;

public class MenuoneActivity extends AppCompatActivity  implements Menuone.Vista {

    private EditText txt_tcuarto,txt_equipo1,txt_equipo2;
    private TextView txt_tpartido;
    private Button btn_tcuarto;
    private ListView listView;
    private ListviewAdapPartidos adapPartidos;
    private Menuone.Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuone);
        setView();

            adapPartidos = new ListviewAdapPartidos(this,TraerListaArray());
            listView.setAdapter(adapPartidos);

        
        btn_tcuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handlePartido();

            }
        });
    }

    private void setView() {
        presentador = new MenuonePresentador(this);
        txt_tcuarto = findViewById(R.id.etxt_tcuarto);
        txt_tpartido = findViewById(R.id.etxt_tpartido);
        txt_equipo1 = findViewById(R.id.etxt_equipo1);
        txt_equipo2 = findViewById(R.id.etxt_equipo2);
        btn_tcuarto = findViewById(R.id.btn_tcuarto);
        listView = findViewById(R.id.listviewpartidos);
    }




    private ArrayList<ListaPartidos> TraerListaArray(){
        ArrayList<ListaPartidos> listaPartidos = new ArrayList<>();
        listaPartidos.add(new ListaPartidos("Sippa vs Chivenkano","2019-07-22","25 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Pepelera vs Chivenkano","2019-08-22","30 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Scuola vs Chivenkano","2019-09-22","32 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Sippa vs Pepelera","2019-10-22","25 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Sippa vs Pepelera","2019-10-22","25 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Sippa vs Pepelera","2019-10-22","25 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Sippa vs Pepelera","2019-10-22","25 minutos",R.drawable.ball));
        listaPartidos.add(new ListaPartidos("Sippa vs Pepelera","2019-10-22","25 minutos",R.drawable.ball));

        return listaPartidos;
    }







    @Override
    public void handlePartido() {
        // *****************************************************************************************

        if (isvalidTcuarto()  && isvalidEquipos()){

            presentador.toPartido(txt_tcuarto.getText().toString().trim(),"00",txt_equipo1.getText().toString().trim() +
                    " vs " + txt_equipo2.getText().toString().trim());


            Toast.makeText(this, "Se a Guardado el Partido Correctamente:"+ txt_equipo1.getText().toString().trim() +
                    " vs " + txt_equipo2.getText().toString().trim(), Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Complete los campos Por favor ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPartido() {
        Toast.makeText(this, "Se a Guardado el Partido Correctamente:"+ txt_equipo1.getText().toString().trim() +
                " vs " + txt_equipo2.getText().toString().trim(), Toast.LENGTH_SHORT).show();

    }


   // ************************* VALIDACIONES ****************************


    @Override
    public boolean isvalidTcuarto() {
        if (txt_tcuarto.getText().toString().trim().equalsIgnoreCase("")){

            Toast.makeText(this, "Por favor complete el tiempo por cuarto para comenzar ", Toast.LENGTH_SHORT).show();
            return  false ;
        } else  {

            return   true ;
        }


    }



    @Override
    public boolean isvalidEquipos() {
        if ( txt_equipo1.getText().toString().trim().equalsIgnoreCase("") && txt_equipo2.getText().toString().trim().equalsIgnoreCase("")){
            return false;
        }else
            return true ;
    }


    @Override
    public void onError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void vshowResult(String resultado) {
        txt_tpartido.setText(resultado + " : min");

    }

    @Override
    public void resultFireb(String dato) {
        Toast.makeText(this, "Se guardo correctamente el partido :"+ dato, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void errorFirebase(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSucessSave() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presentador.onDestroy();
    }



}
