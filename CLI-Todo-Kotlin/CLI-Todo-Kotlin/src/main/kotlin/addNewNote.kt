package com.sangeeth

import kotlinx.coroutines.runBlocking
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
    runBlocking {
        mongoDBClient(newNote)
    }

    println("you entered : ${newNote.getNote + newNote.getTime}")
    println("here is the new note from class ${newNote.getNote}")
    cliInit()

}
