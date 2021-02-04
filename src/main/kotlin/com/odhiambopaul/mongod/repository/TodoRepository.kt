package com.odhiambopaul.mongod.repository

import com.odhiambopaul.mongod.domain.Todo
import org.springframework.data.mongodb.repository.MongoRepository

interface TodoRepository : MongoRepository<Todo, String> {
}