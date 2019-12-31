package com.example.project_six

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.example.project_six.database.AppDatabase
import com.example.project_six.entity.BookEntity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtName = findViewById<TextView>(R.id.txt_view)

        //Edit Text
        val editId = findViewById<EditText>(R.id.edit_one)
        val editName = findViewById<EditText>(R.id.edit_two)

        //Button
        val add = findViewById<Button>(R.id.btn_add)
        val select = findViewById<Button>(R.id.btn_select)

        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "BookDB").build()

        var bookEntity = BookEntity()

        add.setOnClickListener {
            var editId: Int = editId.text.toString().toInt()
            var editName: String = editName.text.toString()
            bookEntity.bookId = editId
            bookEntity.bookName = editName
            Thread {
                db.bookDao().saveBooks(bookEntity)
            }.start()
        }

        select.setOnClickListener {
          // var editName: String = editName.text.toString()
            //bookEntity.bookName = editName
            Thread {
                db.bookDao().getAllBooks().forEach()
                {
                    Log.i("Fetch Records", "Id::${it.bookId}")
                    Log.i("Fetch Records", "Name::${it.bookName}")
                    //txtName.text =it.bookName
                }
            }.start()
        }
    }
}
