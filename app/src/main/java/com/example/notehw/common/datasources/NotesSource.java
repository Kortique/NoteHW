package com.example.notehw.common.datasources;

import com.example.notehw.common.entities.Note;
import com.example.notehw.common.handlers.FetchDataCompletedHandler;

public interface NotesSource {
    void fetchData(FetchDataCompletedHandler fetchDataCompletedHandler);

    Note getNote(int position);

    int getSize();

    void deleteNote(int position);

    void addNote(Note note);

    void updateNote(int position, Note note);

    void deleteAll();
}