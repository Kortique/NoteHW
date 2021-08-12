package com.example.notehw.ui.controllers;

import androidx.fragment.app.Fragment;

import com.example.notehw.common.di.ControllerCompositionRoot;
import com.example.notehw.ui.activities.MainActivity;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot controllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (controllerCompositionRoot == null) {
            controllerCompositionRoot = new ControllerCompositionRoot(
                    ((MainActivity) requireActivity()).getActivityCompositionRoot()
            );
        }

        return controllerCompositionRoot;
    }
}