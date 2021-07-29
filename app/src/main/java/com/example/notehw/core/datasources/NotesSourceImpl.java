package com.example.notehw.core.datasources;

import com.example.notehw.core.entities.Note;
import com.example.notehw.core.utils.Utils;

import java.util.List;

public class NotesSourceImpl implements NotesSource {
    private final List<Note> notes;

    public NotesSourceImpl() {
        notes = Utils.getListOfNotes();
    }

    @Override
    public Note getNote(int position) {
        return notes.get(position);
    }

    @Override
    public int getSize() {
        return notes.size();
    }
}