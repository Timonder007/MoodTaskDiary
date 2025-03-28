package com.example.moodtaskdiary

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatisticsActivity : AppCompatActivity() {

    private lateinit var tvStatistics: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        tvStatistics = findViewById(R.id.tv_statistics)
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        displayStatistics()
    }

    private fun displayStatistics() {
        val mood = sharedPreferences.getString("mood", "Нет данных") ?: "Нет данных"
        val tasks = sharedPreferences.getStringSet("tasks", HashSet()) ?: HashSet()

        val statisticsText = StringBuilder()
        statisticsText.append("Настроение: ").append(mood).append("\n")
        statisticsText.append("Задачи:\n")

        if (tasks.isEmpty()) {
            statisticsText.append("Нет задач.\n")
        } else {
            for (task in tasks) {
                statisticsText.append("- ").append(task).append("\n")
            }
        }

        tvStatistics.text = statisticsText.toString()
    }
}