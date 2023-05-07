package com.example.modul6_cardview_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul6_cardview_sqlite.DBAdapter
import com.example.modul6_cardview_sqlite.DBHelper
import com.example.modul6_cardview_sqlite.DBModel
import com.example.modul6_cardview_sqlite.R


class RvDbActivity : AppCompatActivity() {
    private lateinit var rv_tampilanku: RecyclerView
    lateinit var userDBHelper: DBHelper
    private  var list: ArrayList<DBModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_db)
        rv_tampilanku = findViewById(R.id.rv_tampilkan)
        rv_tampilanku.setHasFixedSize(true)
        userDBHelper = DBHelper(this)
        list.addAll(userDBHelper.fullData())
        rv_tampilanku.layoutManager = LinearLayoutManager(this)
        var cardData = DBAdapter(list)
        rv_tampilanku.adapter = cardData
    }
}