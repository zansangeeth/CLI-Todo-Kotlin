package com.sangeeth

val notesDBInstance = NotesDB()


//val createNote: NoteInterface
fun addNewNote() {
    print("please enter new note : ")
    scanner = readln()
    val newNote = createNote(scanner.toString())
    notesDBInstance.notesDB.add(newNote.getNote)
    println("you entered : ${scanner.toString()}")
    println("here is the new note from class ${newNote.getNote}")
    cliInit()

}
