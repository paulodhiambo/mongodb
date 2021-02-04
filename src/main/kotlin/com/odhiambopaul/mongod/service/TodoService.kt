package com.odhiambopaul.mongod.service

import com.odhiambopaul.mongod.domain.Todo

interface TodoService {
    fun saveTodo(todo: Todo)

    fun getTodos(): List<Todo>

    fun getTodoById(id: String): Todo

    fun deleteTodo(id: String)

    fun updateTodo(todo: Todo)
}