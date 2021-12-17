package com.stephen.hilttutorial.di

import android.content.Context
import androidx.room.Room
import com.stephen.hilttutorial.data.NoteDAO
import com.stephen.hilttutorial.data.NoteDatabase
import com.stephen.hilttutorial.data.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDAO =
        noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideRepository(noteDAO: NoteDAO): NoteRepository =
        NoteRepository(noteDAO)
}