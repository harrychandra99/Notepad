package org.meicode.notepad.viewModel.addNoteViewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.repository.DbRepository
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(val dbRepository : DbRepository): ViewModel() {
    fun insertNote(note: NoteEntity) = dbRepository.saveNote(note)

}