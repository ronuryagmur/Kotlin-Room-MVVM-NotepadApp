package com.example.kotlin_livedata_room_recyclerview.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_livedata_room_recyclerview.R
import com.example.kotlin_livedata_room_recyclerview.adapters.NotesAdapter
import com.example.kotlin_livedata_room_recyclerview.models.Note
import com.example.kotlin_livedata_room_recyclerview.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    companion object {
        val ADD_NOTE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        note_recyclerView.layoutManager = LinearLayoutManager(this)
        note_recyclerView.setHasFixedSize(true)

        val adapter = NotesAdapter()

        note_recyclerView.adapter = adapter

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.getAllNotes().observe(this, Observer<List<Note>> {
            adapter.setNoteList(it)
            adapter.notifyDataSetChanged()
        })

        btn_addNote.setOnClickListener {
            startActivityForResult(Intent(this, AddNoteActivity::class.java), ADD_NOTE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            val newNote = Note(
                data!!.getStringExtra(AddNoteActivity.EXTRA_TITLE),
                data.getStringExtra(AddNoteActivity.EXTRA_DESC)
            )
            mainViewModel.insert(newNote)
            Toast.makeText(this,"Note has been saved!",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Note couldn't be saved!", Toast.LENGTH_LONG).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
