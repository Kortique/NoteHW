package com.example.notehw.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notehw.common.di.CompositionRoot;
import com.example.notehw.ui.CustomApplication;

public class BaseFragment extends Fragment {
    private CompositionRoot compositionRoot;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        compositionRoot = ((CustomApplication) requireActivity().getApplication()).getCompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}