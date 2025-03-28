package com.example.moodtaskdiary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTasks: Button = findViewById(R.id.btn_tasks)
        val btnMood: Button = findViewById(R.id.btn_mood)
        val btnStatistics: Button = findViewById(R.id.btn_statistics)

        btnTasks.setOnClickListener {
            val intent = Intent(this, TasksActivity::class.java)
            startActivity(intent)
        }

        btnMood.setOnClickListener {
            val intent = Intent(this, MoodActivity::class.java)
            startActivity(intent)
        }

        btnStatistics.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }
    }
}