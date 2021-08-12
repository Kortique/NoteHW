package com.example.notehw.ui.dialogs;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.notehw.common.di.ControllerCompositionRoot;
import com.example.notehw.ui.activities.MainActivity;

public class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {

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