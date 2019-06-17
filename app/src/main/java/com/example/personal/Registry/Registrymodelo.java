package com.example.personal.Registry;

import android.support.annotation.NonNull;

import com.example.personal.login.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Registrymodelo implements Registry.Modelo {


    private Registry.TaskListener taskListener;
    private FirebaseAuth auth;

    public Registrymodelo(Registry.TaskListener taskListener) {
        this.taskListener = taskListener;
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void doRegistry(final String name, String email, String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .build();
                    FirebaseUser user = auth.getCurrentUser();
                    if (user!=null){
                        user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if ( task.isSuccessful()){
                                    taskListener.onSucess();
                                }else if (task.getException()!=null){
                                    taskListener.onError(task.getException().getMessage());
                                }
                            }
                        });
                    }else if (task.getException()!=null) {
                        taskListener.onError(task.getException().getMessage());
                    }
                }

            }
        });

    }
}
