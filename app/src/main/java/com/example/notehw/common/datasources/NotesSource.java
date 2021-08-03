package com.example.notehw.common.datasources;

import com.example.notehw.common.entities.Note;

public interface NotesSource {
    Note getNote(int position);

    int getSize();

    void deleteNote(int position);

    void addNote(Note note);

    void updateNote(int position, Note note);

    void deleteAll();
}