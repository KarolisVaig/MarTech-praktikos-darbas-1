package com.example.projektas3

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val colors = listOf(Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW)
    private var currentColorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val textView: TextView = findViewById(R.id.textView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button3.setOnClickListener {
            textView.text = "Naujas tekstas!"
        }

        button4.setOnClickListener {
            // Change the text color to the next color in the list
            textView.setTextColor(colors[currentColorIndex])

            // Update the index for the next color
            currentColorIndex = (currentColorIndex + 1) % colors.size
        }
    }
}
