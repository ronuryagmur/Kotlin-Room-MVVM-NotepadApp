package com.example.kotlin_livedata_room_recyclerview.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlin_livedata_room_recyclerview.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TITLE : String = "com.example.kotlin_livedata_room_recyclerview.EXTRA_TITLE"
        const val EXTRA_DESC : String = "com.example.kotlin_livedata_room_recyclerview.EXTRA_DESC"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        title = "Save Note"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.save_icon -> {
                saveNote()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }

    }

    private fun saveNote(){
        val title = editText_title.text.toString()
        val desc = editText_desc.text.toString()

        if(title.trim().isEmpty() || desc.trim().isEmpty()){
            Toast.makeText(this,"Do not leave empty!",Toast.LENGTH_LONG).show()
            return
        }

        val intent = Intent()
        intent.putExtra(EXTRA_TITLE,title)
        intent.putExtra(EXTRA_DESC,desc)
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
