package com.example.notehw.common.di;

import com.example.notehw.common.datasources.NotesSource;
import com.example.notehw.common.datasources.NotesSourceImpl;
import com.example.notehw.navigator.ScreenNavigator;

public class CompositionRoot {

    private NotesSource dataSource;
    private ScreenNavigator screenNavigator;

    public NotesSource getDataSource() {
        if (dataSource == null) {
            dataSource = new NotesSourceImpl();
        }

        return dataSource;
    }

    public ScreenNavigator getScreenNavigator() {
        if (screenNavigator == null) {
            screenNavigator = new ScreenNavigator();
        }

        return screenNavigator;
    }
}