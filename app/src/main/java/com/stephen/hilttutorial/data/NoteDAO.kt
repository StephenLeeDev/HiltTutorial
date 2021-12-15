package com.stephen.hilttutorial.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDAO {

    @Query("SELECT * FROM Notes")
    fun getNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note): Long
}
