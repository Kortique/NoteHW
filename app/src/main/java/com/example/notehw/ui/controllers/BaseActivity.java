package com.example.notehw.ui.controllers;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notehw.common.di.ActivityCompositionRoot;
import com.example.notehw.common.di.ControllerCompositionRoot;
import com.example.notehw.ui.CustomApplication;

public class BaseActivity extends AppCompatActivity {

    private ActivityCompositionRoot activityCompositionRoot;
    private ControllerCompositionRoot controllerCompositionRoot;

    public ActivityCompositionRoot getActivityCompositionRoot() {
        if (activityCompositionRoot == null) {
            activityCompositionRoot = new ActivityCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this);
        }

        return activityCompositionRoot;
    }

    protected ControllerCompositionRoot getCompositionRoot() {
        if (controllerCompositionRoot == null) {
            controllerCompositionRoot = new ControllerCompositionRoot(getActivityCompositionRoot());
        }

        return controllerCompositionRoot;
    }

}