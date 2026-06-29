package com.sangeeth

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoCollection
import kotlinx.coroutines.flow.first
import org.bson.Document

fun mongoDBClient() : MongoCollection<Document> {

    val connectionUri =
        "mongodb+srv://zansangeeth17_db_user:RaKstl55lOJuzReR@portfolio.mivfbnl.mongodb.net/?appName=portfolio"
    val mongoDBClient = MongoClient.create(connectionUri)
    var database = mongoDBClient.getDatabase("koltin-notes-cli-app")
    val notesCollections = database.getCollection<Document>(collectionName = "notes")
    return notesCollections

}
