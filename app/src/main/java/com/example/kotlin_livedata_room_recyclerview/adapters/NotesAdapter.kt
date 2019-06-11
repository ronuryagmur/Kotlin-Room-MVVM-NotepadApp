package com.example.kotlin_livedata_room_recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.DialogTitle
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_livedata_room_recyclerview.R
import com.example.kotlin_livedata_room_recyclerview.models.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteHolder>(){

    var notes : List<Note> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.note_row_style,parent,false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.textTitle.text = notes[position].title
        holder.textDesc.text = notes[position].description
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNoteList(notes : List<Note>){
        this.notes = notes
    }


    class NoteHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        var textTitle: TextView = itemView.findViewById(R.id.text_note_title)
        var textDesc: TextView = itemView.findViewById(R.id.text_note_description)

    }

}