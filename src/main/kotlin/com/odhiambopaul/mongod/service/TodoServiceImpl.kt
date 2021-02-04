package com.odhiambopaul.mongod.service

import com.odhiambopaul.mongod.domain.Todo
import com.odhiambopaul.mongod.repository.TodoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoServiceImpl(val todoRepository: TodoRepository) : TodoService {
    override fun saveTodo(todo: Todo) {
        todoRepository.save(todo)
    }

    override fun getTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    override fun getTodoById(id: String): Todo {
        val todoQueried: Optional<Todo> = todoRepository.findById(id)
        if (todoQueried.isPresent) {
            return todoQueried.get()
        } else {
            throw IllegalStateException("Todo with id $id not found")
        }
    }

    override fun deleteTodo(id: String) {
        todoRepository.deleteById(id)
    }

    override fun updateTodo(todo: Todo) {
        val todoQueried: Optional<Todo> = todoRepository.findById(todo.id)
        if (todoQueried.isPresent) {
            val _todo = todoQueried.get()
            _todo.description = todo.description
            _todo.isCompleted = todo.isCompleted
            _todo.title = todo.title
            todoRepository.save(_todo)
        } else {
            throw IllegalStateException("Todo with id ${todo.id} is not found")
        }
    }
}