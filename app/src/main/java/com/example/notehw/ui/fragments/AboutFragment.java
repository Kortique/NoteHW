package com.example.notehw.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.notehw.BuildConfig;
import com.example.notehw.R;

public class AboutFragment extends BaseFragment {
    public static final String ABOUT_FRAGMENT_TAG = "ABOUT_FRAGMENT_TAG";

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String versionString = getString(R.string.version) + " " + BuildConfig.VERSION_NAME;
        TextView aboutVersion = view.findViewById(R.id.about_version);
        aboutVersion.setText(versionString);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem actionSort = menu.findItem(R.id.action_sort);
        actionSort.setVisible(false);

        MenuItem actionSearch = menu.findItem(R.id.action_search);
        actionSearch.setVisible(false);

        MenuItem actionAdd = menu.findItem(R.id.action_add);
        actionAdd.setVisible(false);
    }
}