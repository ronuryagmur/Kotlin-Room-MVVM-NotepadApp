package com.example.kotlin_livedata_room_recyclerview.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlin_livedata_room_recyclerview.data.NoteRepository
import com.example.kotlin_livedata_room_recyclerview.models.Note

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NoteRepository = NoteRepository(application)

    fun insert(note: Note){
        repository.insert(note)
    }

    fun update(note: Note){
        repository.update(note)
    }

    fun delete(note: Note){
        repository.delete(note)
    }

    fun deleteAll(){
        repository.deleteAll()
    }

    fun getAllNotes():LiveData<List<Note>>{
        return repository.getAllNotes()
    }

}