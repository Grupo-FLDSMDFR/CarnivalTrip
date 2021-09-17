package com.example.carnivaltrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

    val poi = listOf(
        ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
        ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
        ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
        ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg"),
        ListPoi("Melbourne", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur accumsan ipsum sit amet nisl ultricies maximus. Morbi finibus urna a neque maximus, ac sagittis orci faucibus. Nunc congue lorem nunc.", "10ptos", "https://gostudyaus.es/wp-content/uploads/2018/10/MEL_header_2-1.jpg")
    )

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}