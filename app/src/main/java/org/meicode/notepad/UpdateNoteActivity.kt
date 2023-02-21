package org.meicode.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.databinding.ActivityUpdateBinding
import org.meicode.notepad.utils.Constants.BUNDLE_NOTE_ID
import org.meicode.notepad.viewModel.updateNodeViewModel.UpdateNoteViewModel
import javax.inject.Inject

@AndroidEntryPoint
class UpdateNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateBinding

    @Inject
    lateinit var noteEntity : NoteEntity

    val viewModel: UpdateNoteViewModel by viewModels()

    private var noteId:Int = 0
    private var defaultTitle: String = ""
    private var defaultDesc: String = ""

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            noteId = it.getInt(BUNDLE_NOTE_ID)
        }

        binding.apply {
            defaultTitle = viewModel.getNote(noteId).noteTitle
            defaultDesc = viewModel.getNote(noteId).noteDesc

            edtTitle.setText(defaultTitle)
            edtDesc.setText(defaultDesc)

            btnDelete.setOnClickListener {
                noteEntity = NoteEntity(noteId, defaultTitle, defaultDesc)
                viewModel.deleteNote(noteEntity)
                finish()
            }

            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if(title.isNotEmpty() || desc.isNotEmpty()){
                    noteEntity = NoteEntity(noteId, title, desc)
                    viewModel.updateNote(noteEntity)
                    finish()
                } else{
                    Toast.makeText(this@UpdateNoteActivity, "Title and desc cant be null",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}