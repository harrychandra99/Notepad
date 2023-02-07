package org.meicode.notepad.viewModel

import androidx.lifecycle.ViewModel
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.repository.DbRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dbRepository : DbRepository): ViewModel() {

    fun insertNote(note: NoteEntity) = dbRepository.saveNote(note)
    fun updateNote(note:NoteEntity) = dbRepository.updateNote(note)
    fun deleteNote(note : NoteEntity) = dbRepository.deleteNote(note)
    fun getNoteId(id : Int) = dbRepository.getNote(id)
    fun getAllNotes() = dbRepository.getAllNotes()

}