package com.example.notehw.ui.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.example.notehw.R;
import com.example.notehw.common.di.CompositionRoot;
import com.example.notehw.common.utils.Utils;
import com.example.notehw.ui.CustomApplication;
import com.example.notehw.ui.fragments.FragmentEnum;
import com.example.notehw.ui.navigator.ScreenNavigator;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {
    private static final String ACCOUNT_NAME = "ACCOUNT_NAME";
    private static final String ACCOUNT_EMAIL = "ACCOUNT_EMAIL";

    private ScreenNavigator screenNavigator;

    private DrawerLayout drawerLayout;

    private String accountName;
    private String accountEmail;

    public static Intent newInstance(Context packageContext, String accountName, String accountEmail) {
        Intent intent = new Intent(packageContext, MainActivity.class);

        intent.putExtra(ACCOUNT_NAME, accountName);
        intent.putExtra(ACCOUNT_EMAIL, accountEmail);

        return intent;
    }

    public static void startActivity(Context packageContext, String accountName, String accountEmail) {
        Intent intent = newInstance(packageContext, accountName, accountEmail);
        packageContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            accountName = extras.getString(ACCOUNT_NAME);
            accountEmail = extras.getString(ACCOUNT_EMAIL);
        }

        initView();

        CompositionRoot compositionRoot = ((CustomApplication) getApplication()).getCompositionRoot();

        screenNavigator = compositionRoot.getScreenNavigator();
        screenNavigator.setFragmentManager(this.getSupportFragmentManager());

        Configuration configuration = getResources().getConfiguration();
        screenNavigator.setLandscape(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE);

        screenNavigator.toListOfNotesScreen(true);
    }

    private void initView() {
        Toolbar toolbar = initAndGetToolbar();
        initDrawer(toolbar);
    }

    private Toolbar initAndGetToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        return toolbar;
    }

    private void initDrawer(Toolbar toolbar) {
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        configureNavigationView();
    }

    private void configureNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                item -> {
                    int itemId = item.getItemId();

                    if (processMenuSelection(itemId)) {
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }

                    return false;
                }
        );

        configureNavigationHeaderView(navigationView);
    }

    private void configureNavigationHeaderView(NavigationView navigationView) {
        View navHeaderView = navigationView.getHeaderView(0);

        TextView navHeaderUsername = navHeaderView.findViewById(R.id.nav_header_username);
        if (accountName != null) {
            navHeaderUsername.setText(accountName);
        }

        TextView navHeaderEmail = navHeaderView.findViewById(R.id.nav_header_email);
        if (accountEmail != null) {
            navHeaderEmail.setText(accountEmail);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchText = (SearchView) search.getActionView();

        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Utils.showToastShort(MainActivity.this, getString(R.string.not_implemented));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (processMenuSelection(itemId)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    private boolean processMenuSelection(int itemId) {
        switch (itemId) {
            case R.id.action_sort:
            case R.id.action_settings:
                Utils.showToastShort(MainActivity.this, getString(R.string.not_implemented));
                return true;

            case R.id.action_notes:
                screenNavigator.toListOfNotesScreen();
                screenNavigator.resetSelectedPosition();
                return true;

            case R.id.action_about:
                screenNavigator.toAboutScreen();
                return true;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (!screenNavigator.isLandscape() && screenNavigator.getCurrentFragmentEntry() == FragmentEnum.NOTE) {
            screenNavigator.toListOfNotesScreen();
            screenNavigator.resetSelectedPosition();
        } else {
            super.onBackPressed();
        }
    }
}