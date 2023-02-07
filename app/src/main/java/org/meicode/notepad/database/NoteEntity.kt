package org.meicode.notepad.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.meicode.notepad.utils.Constants

@Entity(tableName = Constants.NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    @ColumnInfo(name = "note_title")
    val noteTitle: String? = null,
    @ColumnInfo(name = "note_desc")
    val noteDesc: String? = null
) {
}