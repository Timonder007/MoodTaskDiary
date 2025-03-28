package com.example.moodtaskdiary

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MoodActivity : AppCompatActivity() {

    private lateinit var etMood: EditText
    private lateinit var btnSaveMood: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)

        etMood = findViewById(R.id.et_mood)
        btnSaveMood = findViewById(R.id.btn_save_mood)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        btnSaveMood.setOnClickListener {
            val mood = etMood.text.toString().trim()
            if (mood.isNotEmpty()) {
                saveMood(mood)
                Toast.makeText(this, "Настроение сохранено!", Toast.LENGTH_SHORT).show()
                etMood.setText("")
            } else {
                Toast.makeText(this, "Пожалуйста, опишите ваше настроение.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveMood(mood: String) {
        val editor = sharedPreferences.edit()
        editor.putString("mood", mood)
        editor.apply()
    }
}