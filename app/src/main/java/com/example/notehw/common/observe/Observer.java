package com.example.notehw.common.observe;

import com.example.notehw.common.entities.Note;

public interface Observer {
    void updateNote(Note note);
}