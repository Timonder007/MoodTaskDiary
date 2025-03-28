package com.example.moodtaskdiary

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.HashSet

class TasksActivity : AppCompatActivity() {

    private lateinit var etNewTask: EditText
    private lateinit var btnAddTask: Button
    private lateinit var lvTasks: ListView
    private lateinit var tasksList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        etNewTask = findViewById(R.id.et_new_task)
        btnAddTask = findViewById(R.id.btn_add_task)
        lvTasks = findViewById(R.id.lv_tasks)

        tasksList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasksList)
        lvTasks.adapter = adapter

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)


        loadTasks()

        btnAddTask.setOnClickListener {
            val newTask = etNewTask.text.toString().trim()
            if (newTask.isNotEmpty()) {
                tasksList.add(newTask)
                adapter.notifyDataSetChanged()
                etNewTask.setText("")
                saveTasks()
            }
        }

    }


    private fun saveTasks() {
        val editor = sharedPreferences.edit()
        val set = HashSet(tasksList)
        editor.putStringSet("tasks", set)
        editor.apply()
    }


    private fun loadTasks() {
        val set = sharedPreferences.getStringSet("tasks", HashSet()) ?: HashSet()
        tasksList.addAll(set)
        adapter.notifyDataSetChanged()
    }
}