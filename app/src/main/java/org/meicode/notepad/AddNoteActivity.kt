package org.meicode.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.databinding.ActivityAddNoteBinding
import org.meicode.notepad.repository.DbRepository
import org.meicode.notepad.viewModel.addNoteViewModel.AddNoteViewModel
import javax.inject.Inject

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding

    @Inject
    lateinit var noteEntity : NoteEntity

    val viewModel: AddNoteViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if(title.isNotEmpty() || desc.isNotEmpty()){
                    noteEntity = NoteEntity(0, title, desc)
                    viewModel.insertNote(noteEntity)
                    finish()
                } else{
                    Toast.makeText(this@AddNoteActivity, "Title and Desc Must be filled",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}