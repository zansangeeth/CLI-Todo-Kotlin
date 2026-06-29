package com.sangeeth

import com.mongodb.client.model.Filters
import com.mongodb.client.model.UpdateOptions
import com.mongodb.client.model.Updates
import org.bson.Document
import java.time.LocalDate


suspend fun modifyNotes() {


    println("which note would you like to modify(give note ID)?")
    scanner = readln()
    val noteId = scanner
    if (noteId != null) {
        val filter = Filters.eq("id", noteId)
        if (filter != null) {
            println("Enter updated note")
            scanner = readln()
            val note = scanner
            val document = Document()
                .append("id", noteId.toString())
                .append("note", note.toString())
                .append("time", LocalDate.now().toString())
            if (document != null){
                val updates = Updates.set("note", note)
                val results = mongoDBClient().updateOne(filter, updates, UpdateOptions().upsert(true))
                println(results)
            }
        }
    }



}