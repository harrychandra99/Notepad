package org.meicode.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.meicode.notepad.adapter.NoteAdapter
import org.meicode.notepad.databinding.ActivityMainBinding
import org.meicode.notepad.repository.DbRepository
import org.meicode.notepad.viewModel.mainViewModel.MainViewModel
import javax.inject.Inject

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var  repository: DbRepository

    val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        checkItem()
    }

    fun checkItem(){
        if(repository.getAllNotes().isNotEmpty()){
            noteAdapter.differ.submitList(viewModel.getAllNotes())
            setUpRecycleView()
        }
    }

    fun setUpRecycleView(){
        binding.rvNoteList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }
    }
}