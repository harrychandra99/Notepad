package org.meicode.notepad.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.meicode.notepad.UpdateNoteActivity
import org.meicode.notepad.database.NoteEntity
import org.meicode.notepad.databinding.ItemNoteBinding
import org.meicode.notepad.utils.Constants.BUNDLE_NOTE_ID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteAdapter @Inject constructor(): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private lateinit var binding: ItemNoteBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemNoteBinding.inflate(inflater,parent,false)
        context = parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() : Int = differ.currentList.size

    inner class ViewHolder: RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteEntity){
            binding.apply {
                tvTitle.text = item.noteTitle
                tvDesc.text = item.noteDesc
                root.setOnClickListener {
                    val intent = Intent(context, UpdateNoteActivity::class.java)
                    intent.putExtra(BUNDLE_NOTE_ID, item.noteId)
                    context.startActivity(intent)
                }
            }
        }
    }

    private val diferCallback = object :
        DiffUtil.ItemCallback<NoteEntity>(){
        override fun areItemsTheSame(oldItem : NoteEntity, newItem : NoteEntity) : Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem : NoteEntity, newItem : NoteEntity) : Boolean {
            return oldItem==newItem
        }
    }

    val differ = AsyncListDiffer(this, diferCallback)
}