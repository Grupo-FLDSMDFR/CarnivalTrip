package com.example.carnivaltrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_poi.*

val poi = listOf(
    ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
    ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
    ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
    ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
    ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg")
)

class MainPoi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_poi)
        initRecycler()
    }

    fun initRecycler(){
        r_list_poi.layoutManager = LinearLayoutManager(this)
        val adapter = PoiAdapter(poi)
        r_list_poi.adapter=adapter
    }
}