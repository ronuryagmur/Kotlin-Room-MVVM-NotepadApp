package com.example.kotlin_livedata_room_recyclerview.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.kotlin_livedata_room_recyclerview.models.Note

class NoteRepository(application: Application) {

    private val noteDatabase : NoteDatabase = NoteDatabase.getInstance(application)
    private val noteDao : NoteDao

    init {
        noteDao = noteDatabase.noteDao()
    }

    fun insert(note: Note){
        InsertAsync(noteDao).execute(note)
    }

    fun update(note: Note){
        UpdateAsync(noteDao).execute(note)
    }

    fun delete(note: Note){
        DeleteAsync(noteDao).execute(note)
    }

    fun deleteAll(){
        DeleteAllAsync(noteDao).execute()
    }

    fun getAllNotes() : LiveData<List<Note>>{
        return noteDao.getAllNotes()
    }

    class InsertAsync(noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {

        private val noteDao : NoteDao = noteDao

        override fun doInBackground(vararg params: Note?) {
            noteDao.insert(params[0]!!)
        }
    }

    class UpdateAsync(noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {

        private val noteDao : NoteDao = noteDao

        override fun doInBackground(vararg params: Note?) {
            noteDao.update(params[0]!!)
        }
    }

    class DeleteAsync(noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {

        private val noteDao : NoteDao = noteDao

        override fun doInBackground(vararg params: Note?) {
            noteDao.delete(params[0]!!)
        }
    }

    class DeleteAllAsync(noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {

        private val noteDao : NoteDao = noteDao

        override fun doInBackground(vararg params: Unit?) {
            noteDao.deleteAll()
        }
    }
}