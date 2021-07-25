package com.example.notehw;

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
                        new Date(1623312000000L),
                        Priority.NORMAL
                )
        );

        notes.add(
                new Note(
                        "Изучить паттерны проектирования",
                        "Зайти на сайт https://refactoring.guru/ru",
                        new Date(1623398400000L),
                        Priority.NORMAL
                )
        );

        notes.add(
                new Note(
                        "Навести порядок в комнате",
                        "Расставить вещи в комнате по местам, провести уборку",
                        new Date(1623486600000L),
                        Priority.HIGH
                )
        );

        notes.add(
                new Note(
                        "Сходить в спортзал",
                        "Занятия во вторник, пятницу и воскресенье",
                        new Date(1623761025000L),
                        Priority.NORMAL
                )
        );

        return notes;
    }
}
