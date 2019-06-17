package com.example.personal.login;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginModelo implements Login.Modelo {

    private Login.TaskListener taskListener;
    private FirebaseAuth auth;

    public LoginModelo(Login.TaskListener taskListener) {
        this.taskListener = taskListener;
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void doLogin(String email, String password) {
        //************** firrebase ****************

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    taskListener.onSucess();
                }else{
                    if (task.getException()!=null)
                    taskListener.onError(task.getException().getMessage());
                }


            }
        });


    }
}
