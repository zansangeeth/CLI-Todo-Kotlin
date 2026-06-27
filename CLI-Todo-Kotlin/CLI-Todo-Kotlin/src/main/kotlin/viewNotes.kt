package com.sangeeth

import com.mongodb.kotlin.client.coroutine.MongoClient
import kotlinx.coroutines.flow.toList
import org.bson.Document
import kotlin.io.println


suspend fun vewNotes() {

//    val db = notesDBInstance.notesDB
    val connectionUri =
        "mongodb+srv://zansangeeth17_db_user:RaKstl55lOJuzReR@portfolio.mivfbnl.mongodb.net/?appName=portfolio"
    val mongoDBClient = MongoClient.create(connectionUri)
    var database = mongoDBClient.getDatabase("koltin-notes-cli-app")
    val notesCollections = database.getCollection<Document>(collectionName = "notes")
    val db = notesCollections.find().toList()
    println(db.size)
//    db.collect { println(it) }



    val idMaxWidth = 30
    val noteWidth = 40
    val dateMaxWidth = 40
//
    println("| %-${idMaxWidth}s | %-${noteWidth}s | %-${dateMaxWidth}s |".format("ID", "Note", "Time"))
//
        db.forEachIndexed { index, document ->
            println("| ${(index+1)} | ${document.getString("note")} | ${document.getString("time")} |")
        }


    cliInit()
}
