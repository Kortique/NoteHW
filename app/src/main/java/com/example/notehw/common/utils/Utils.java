package com.example.notehw.common.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.notehw.common.entities.Note;
import com.example.notehw.common.entities.Priority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

    public static List<Note> getListOfNotes() {
        List<Note> notes = new ArrayList<>();

        notes.add(
                new Note(
                        "Купить продукты для окрошки",
                        "Необходимо купить: огурцы, квас, хлеб и т.д.",
                        new Date(1626999400000L),
                        Priority.NORMAL
                )
        );

        notes.add(
                new Note(
                        "Изучить паттерны проектирования",
                        "Зайти на сайт https://refactoring.guru/ru",
                        new Date(1626398400000L),
                        Priority.NORMAL
                )
        );

        notes.add(
                new Note(
                        "Навести порядок в комнате",
                        "Расставить вещи в комнате по местам, провести уборку",
                        new Date(1626486600000L),
                        Priority.HIGH
                )
        );

        notes.add(
                new Note(
                        "Сходить в спортзал",
                        "Занятия во вторник, пятницу и воскресенье",
                        new Date(1626761025000L),
                        Priority.NORMAL
                )
        );

        return notes;
    }

    public static void showToastShort(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String message, int toastLength) {
        Toast.makeText(context, message, toastLength).show();
    }
}
