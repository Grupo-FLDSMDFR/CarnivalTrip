package com.example.carnivaltrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main_poi.*
import java.io.IOException

class MainPoi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_poi)
        initRecycler()
    }

    private fun initRecycler(){
        val poi = procces_list_poi()
        Log.d("RES", poi[0].toString())
        r_list_poi.layoutManager = LinearLayoutManager(this)
        val adapter = PoiAdapter(poi)
        r_list_poi.adapter=adapter
    }

    private fun procces_list_poi(): List<ListPoi> {
        val fileData = getListPoi()
        val gson = GsonBuilder().create()

        return gson.fromJson(fileData, Array<ListPoi>::class.java).toList()
    }

    private fun getListPoi(): String? {
        var gListPoi: String? = null
        try {
            val inputStream = assets.open("list_poi.json")
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