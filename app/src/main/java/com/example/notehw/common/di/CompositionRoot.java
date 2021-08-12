package com.example.notehw.common.di;

import com.example.notehw.common.StateStore;
import com.example.notehw.common.datasources.NotesFirebaseImpl;
import com.example.notehw.common.datasources.NotesSource;
import com.example.notehw.ui.dialogs.DialogsEventBus;

public class CompositionRoot {

    private NotesSource dataSource;
    private StateStore stateStore;
    private DialogsEventBus dialogsEventBus;

    public NotesSource getDataSource() {
        if (dataSource == null) {
            dataSource = new NotesFirebaseImpl();
        }

        return dataSource;
    }

    public StateStore getStateStore() {
        if (stateStore == null) {
            stateStore = new StateStore();
        }
        return stateStore;
    }

    public DialogsEventBus getDialogsEventBus() {
        if (dialogsEventBus == null) {
            dialogsEventBus = new DialogsEventBus();
        }

        return dialogsEventBus;
    }
}