package com.example.notehw.ui.dialogs.notedialog;

public class NoteDialogEvent {

    public enum Button {
        POSITIVE, NEGATIVE
    }

    private final Button clickedButton;

    public NoteDialogEvent(Button clickedButton) {
        this.clickedButton = clickedButton;
    }

    public Button getClickedButton() {
        return clickedButton;
    }
}