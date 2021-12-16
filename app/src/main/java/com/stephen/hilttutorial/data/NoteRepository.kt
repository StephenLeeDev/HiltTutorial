package com.stephen.hilttutorial.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(private val noteDAO: NoteDAO) {
    suspend fun getNote(): Note =
        withContext(Dispatchers.IO) {
            noteDAO.getNotes()[0]
        }

    suspend fun saveNote(note: Note) {
        withContext(Dispatchers.IO) {
            noteDAO.insert(note)
        }
    }
}