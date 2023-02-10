package org.meicode.notepad.viewModel.updateNodeViewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.repository.DbRepository
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModel @Inject constructor(val dbRepository:DbRepository): ViewModel() {
    fun getNote(noteId: Int) = dbRepository.getNote(noteId)
    fun deleteNote(note : NoteEntity) = dbRepository.deleteNote(note)
    fun updateNote(note:NoteEntity) = dbRepository.updateNote(note)
}