package com.sangeeth

import org.bson.Document
import java.time.LocalDate
import java.util.UUID

val notesDBInstance = NotesDB()


//val createNote: NoteInterface
suspend fun addNewNote() {
    print("please enter new note : ")
    scanner = readln()
    val noteId = UUID.randomUUID().toString()
    val newNote = createNote(
        noteId = noteId,
        noteText = scanner.toString(),
        getTime = LocalDate.now().toString(),
    )
    notesDBInstance.notesDB.getOrPut(noteId) { mutableListOf() }.add(newNote)
    run {
        val document = Document()
            .append("id", newNote.getNoteId)
            .append("note", newNote.getNote)
            .append("time", newNote.getTime)
        mongoDBClient().insertOne(document).also {
            println("note added with id ${it.insertedId}")
        }
    }

    println("you entered : ${newNote.getNote + newNote.getTime}")
    println("here is the new note from class ${newNote.getNote}")
    cliInit()

}
