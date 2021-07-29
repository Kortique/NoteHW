package com.example.notehw.core.listeners;

import com.example.notehw.core.entities.Note;

@FunctionalInterface
public interface OnItemSelectedListener {
    void onItemSelected(Note note);
}