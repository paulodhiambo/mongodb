package com.odhiambopaul.mongod.controller

import com.odhiambopaul.mongod.domain.Todo
import com.odhiambopaul.mongod.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/todos/")
@CrossOrigin("*")
class TodoController(val todoService: TodoService) {
    //Get all todos in the database
    @GetMapping("")
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        return ResponseEntity(todoService.getTodos(), HttpStatus.OK)
    }

    //Get Todo from the datababse by id
    @GetMapping("/{id}")
    fun getTodoById(@PathVariable("id") id: String): ResponseEntity<Todo> {
        return ResponseEntity(todoService.getTodoById(id), HttpStatus.OK)
    }

    //save a todo into the database
    @PostMapping("")
    fun saveTodo(@RequestBody todo: Todo): ResponseEntity<Any> {
        return ResponseEntity(todoService.saveTodo(todo), HttpStatus.CREATED)
    }

    //update todo
    @PutMapping("")
    fun updateTodo(@RequestBody todo: Todo): ResponseEntity<Any> {
        return ResponseEntity(todoService.updateTodo(todo), HttpStatus.OK)
    }

    //delete todo
    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable("id") id: String): ResponseEntity<Any> {
        return ResponseEntity(todoService.deleteTodo(id), HttpStatus.NO_CONTENT)
    }

}