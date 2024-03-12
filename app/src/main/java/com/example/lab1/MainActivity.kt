package com.example.lab1

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val clearButton: Button = findViewById(R.id.clearButton)
        val listView: ListView = findViewById(R.id.listView)

        val list: ArrayList<String> = ArrayList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        listView.adapter = adapter

        val buttonClickListener = View.OnClickListener { view ->
            if (view is Button) {
                list.add(view.text.toString())
                adapter.notifyDataSetChanged()
            }
        }

        button1.setOnClickListener(buttonClickListener)
        button2.setOnClickListener(buttonClickListener)
        button3.setOnClickListener(buttonClickListener)

        val clearButtonClickListener = View.OnClickListener { view ->
            if (view is Button) {
                list.clear()
                adapter.notifyDataSetChanged()
            }
        }

        clearButton.setOnClickListener(clearButtonClickListener)

    }
}