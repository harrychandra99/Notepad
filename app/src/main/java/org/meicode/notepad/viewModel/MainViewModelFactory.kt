package org.meicode.notepad.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.meicode.notepad.repository.DbRepository
import javax.inject.Inject

class MainViewModelFactory@Inject constructor(private val dbRepository : DbRepository): ViewModelProvider.NewInstanceFactory() {

    val tag: String = "NoteViewModelFactory"
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            val constructor = modelClass.getDeclaredConstructor(MainViewModel::class.java)
            return constructor.newInstance(dbRepository)
        } catch (e: Exception) {
            Log.e(tag, "Depedencies are downloading"+e.message)
        }
        return super.create(modelClass)
    }
}