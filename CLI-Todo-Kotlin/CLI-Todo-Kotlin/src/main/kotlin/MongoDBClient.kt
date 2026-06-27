package com.sangeeth

import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.flow.first
import org.bson.Document
import java.util.Objects

suspend fun mongoDBClient(data: NoteInterface) {

    val connectionUri =
        "mongodb+srv://zansangeeth17_db_user:RaKstl55lOJuzReR@portfolio.mivfbnl.mongodb.net/?appName=portfolio"
    val mongoDBClient = MongoClient.create(connectionUri)
    var database = mongoDBClient.getDatabase("koltin-notes-cli-app")
    val notesCollections = database.getCollection<Document>(collectionName = "notes")
    notesCollections.find().first()

    val document = Document()
        .append("id", data.getNoteId)
        .append("note", data.getNote)
        .append("time", data.getTime)
    notesCollections.insertOne(document).also {
        println("note added with id ${it.insertedId}")
    }


}
