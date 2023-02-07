package org.meicode.notepad.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.meicode.notepad.database.NoteDatabase
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.utils.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context : Context) = Room.databaseBuilder(
        context, NoteDatabase::class.java, Constants.NOTE_DATABASE
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db : NoteDatabase) = db.noteDAO()

    @Provides
    fun provideEntity() = NoteEntity()
}