package org.meicode.notepad.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 2)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDAO():NoteDao
}