package com.example.personal.MenuOne;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MenuoneModelo implements Menuone.Modelo {

    private String TAGLOG;
    private Menuone.Presentador presentador ;
    private FirebaseDatabase database;
    private DatabaseReference reference ;
    FirebaseUser user ;

    String result ="";



    public MenuoneModelo(Menuone.Presentador presentador) {

        this.presentador = presentador;
        database = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        // se declara la rama donde se guardaran los datos con el usuario que ingreso o se logeo

        reference = database.getReference("Partidos").child(user.getUid());
    }

    @Override
    public void  doPartido(String tcuarto, String tpartido, final String equipos) {

        //********** se calcula el tiempo de partido  ****************

        int num = Integer.parseInt(tcuarto);
        int tpart = (num * 4);
        result = String.valueOf(tpart);
        presentador.pshowResult(result);

        // *************************************************************


        Map<String, Object> datosPartido = new HashMap<>();

        datosPartido.put("equipos", equipos);
        datosPartido.put("Tiempodepartido",tpart);
        datosPartido.put("tiempoporcuarto",tcuarto);

        reference.child("Partidos").push().setValue(datosPartido).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    presentador.presultFireb(equipos);
                    escuchoPartidos();
                } else {
                    if (task.getException() != null)

                        presentador.perrorFirebase(task.getException().getMessage());
                }

            }
        });

    }

    @Override
    public void escuchoPartidos() {

        reference = database.getInstance().getReference().child("Partidos");
        ChildEventListener childEventListener= new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d(TAGLOG, "onChildAdded: {" + dataSnapshot.getKey() + ": " + dataSnapshot.getValue() + "}");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };



    }









/*
        reference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){

                    String equiposn =(String) dataSnapshot.child("Equipos").getValue();


                    presentador.presultFireb(equiposn);
                } else {
                    presentador.perrorFirebase( " no hay ningun partido guardado ");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                presentador.perrorFirebase(databaseError.getMessage());

            }
        });

        reference.child("Equipos").setValue(equipos).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    presentador.presultFireb(equipos);
                } else {
                    if (task.getException() != null)
                        presentador.perrorFirebase(task.getException().getMessage());
                }

            }
        });
*/

}
