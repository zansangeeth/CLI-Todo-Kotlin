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



    val idMaxWidth = maxOf(4, db.maxOfOrNull { (it.getString("id") ?: "").length }?.coerceIn(20, 50) ?: 20)
    val noteWidth = maxOf(20, db.maxOfOrNull { (it.getString("note") ?: "").length }?.coerceIn(20, 50) ?: 20)
    val dateMaxWidth = maxOf(12, db.maxOfOrNull { (it.getString("time") ?: "").length }?.coerceIn(20, 50) ?: 12)
//

    println("| %-${idMaxWidth}s | %-${noteWidth}s | %-${dateMaxWidth}s |".format("ID", "Note", "Time"))
//
        db.forEachIndexed { index, document ->
            println("| ${document.getString("id").take(idMaxWidth).padEnd(idMaxWidth)} | ${document.getString("note").take(noteWidth).padEnd(noteWidth)} | ${document.getString("time").take(dateMaxWidth).padEnd(dateMaxWidth)} |")
        }


    cliInit()
}
