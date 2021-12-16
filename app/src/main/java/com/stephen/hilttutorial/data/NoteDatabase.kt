package com.stephen.hilttutorial.data

import androidx.room.Database

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase {
    abstract fun noteDao(): NoteDAO

    companion object {
        const val DATABASE_NAME = "noteDatabase"
    }
}