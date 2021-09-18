package com.example.carnivaltrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_list.*
import java.io.IOException

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initRecycler()
    }

    private fun initRecycler(){
        val poi = mockListPoi()
        Log.d("RES", poi[0].toString())
        r_list_poi.layoutManager = LinearLayoutManager(this)
        val adapter = CarnivalAdapter(poi)
        r_list_poi.adapter = adapter
    }

    private fun mockListPoi(): List<Carnival> {
        val fileData = getListPoi()
        val gson = GsonBuilder().create()

        return gson.fromJson(fileData, Array<Carnival>::class.java).toList()
    }

    private fun getListPoi(): String? {
        var gListPoi: String? = null
        try {
            val inputStream = assets.open("MockCarnival.JSON")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            gListPoi = String(buffer)
        }catch (e: IOException){
            e.printStackTrace()
        }
        return gListPoi
    }
}