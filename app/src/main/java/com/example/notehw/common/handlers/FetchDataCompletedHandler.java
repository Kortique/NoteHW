package com.example.notehw.common.handlers;

import com.example.notehw.common.datasources.NotesSource;

@FunctionalInterface
public interface FetchDataCompletedHandler {
    void fetchDataCompleted(NotesSource notesSource);
}