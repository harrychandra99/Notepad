package org.meicode.notepad.repository

import org.meicode.notepad.database.NoteDao
import org.meicode.notepad.database.NoteEntity
import javax.inject.Inject

class DbRepository
    @Inject constructor(
    private val dao : NoteDao
) {
    fun saveNote(entity : NoteEntity) = dao.inserNote(entity)
    fun updateNote(entity : NoteEntity) = dao.updateNote(entity)
    fun deleteNote(entity : NoteEntity) = dao.deleteNote(entity)
    fun getNote(id : Int) = dao.getNote(id)
    fun getAllNotes() = dao.getAllNotes()
}