package org.meicode.notepad.viewModel.mainViewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.repository.DbRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dbRepository : DbRepository): ViewModel() {
    fun getAllNotes() = dbRepository.getAllNotes()
}