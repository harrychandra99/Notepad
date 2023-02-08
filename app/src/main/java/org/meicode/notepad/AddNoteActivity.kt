package org.meicode.notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.meicode.notepad.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }
}