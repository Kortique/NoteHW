package com.example.notehw.common.datasources;

import com.example.notehw.common.entities.Note;
import com.example.notehw.common.utils.Utils;

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

    @Override
    public void deleteNote(int position) {
        notes.remove(position);
    }

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public void updateNote(int position, Note note) {
        notes.set(position, note);
    }

    @Override
    public void deleteAll() {
        notes.clear();
    }
}