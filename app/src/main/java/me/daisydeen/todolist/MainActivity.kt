package me.daisydeen.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var todoAdaptor: TodoAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdaptor = TodoAdaptor(mutableListOf())

        val rvTodoItems: RecyclerView = findViewById(R.id.rvTodoItems)
        rvTodoItems.adapter = todoAdaptor
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        val etTodoTitle: EditText = findViewById(R.id.etTodoTitle)
        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdaptor.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        val btnDeleteDoneTodos: Button = findViewById(R.id.btnDeleteTodo)
        btnDeleteDoneTodos.setOnClickListener {
            todoAdaptor.deleteDoneTodos()
        }
    }
}