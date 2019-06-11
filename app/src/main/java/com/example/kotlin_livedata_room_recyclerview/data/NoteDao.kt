package com.example.kotlin_livedata_room_recyclerview.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlin_livedata_room_recyclerview.models.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE from note_table")
    fun deleteAll()

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getAllNotes() : LiveData<List<Note>>

}