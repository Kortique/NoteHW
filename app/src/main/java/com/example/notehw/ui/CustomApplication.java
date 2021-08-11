package com.example.notehw.ui;

import android.app.Application;

import com.example.notehw.common.di.CompositionRoot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class CustomApplication extends Application {

    private CompositionRoot compositionRoot;

    @Override
    public void onCreate(){
        super.onCreate();
            FirebaseApp.initializeApp(this);

        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}