package com.sangeeth

import com.mongodb.kotlin.client.coroutine.MongoClient

suspend fun mongoDBClient() {

    val connectionUri =
        "mongodb+srv://zansangeeth17_db_user:RaKstl55lOJuzReR@portfolio.mivfbnl.mongodb.net/?appName=portfolio"
    val mongoDBClient = MongoClient.create(connectionUri)
    val database = mongoDBClient.getDatabase("koltin-notes-cli-app")
    val notesCollections = database.listCollectionNames().collect { println(it) }


}

suspend fun main() {
    mongoDBClient()
}