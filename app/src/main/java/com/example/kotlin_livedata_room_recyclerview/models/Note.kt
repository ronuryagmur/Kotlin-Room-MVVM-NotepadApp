package com.example.kotlin_livedata_room_recyclerview.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note (

    var title: String,

    var description: String

){

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}