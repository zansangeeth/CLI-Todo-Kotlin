package com.sangeeth

import kotlin.system.exitProcess

val notesDBInstance = NotesDB()
val newNoteInstance = Note()
var scanner: Any? = null

fun main() {

    cliInit()

}

fun vewNotes() {
    println(notesDBInstance.notesDB)
    cliInit()
}

fun addNewNote() {
    print("please enter new note : ")
    scanner = readln()
    newNoteInstance.note = scanner.toString()
    notesDBInstance.notesDB.add(newNoteInstance.note)
    println("you entered : ${scanner.toString()}")
    println("here is the new note from class ${newNoteInstance.note}")
    cliInit()

}


fun cliInit(){

    println("***************CLI-Todo-App*****************")

    println("welcome to notes app")
    println("press 1 or 2 only")
    println("1 - New Note")
    println("2 - View Notes")
    println("3 - Exit")
    try {
        scanner = readln().toInt()
        do {
            when (scanner) {
                1 -> addNewNote()
                2 -> vewNotes()
                3 -> exitProcess(0)
                else -> println("you should be select either 1 or 2")
            }
        } while (scanner == 1 or(2))
    } catch (e: Exception) {
        println("you should be select either 1 or 2")
    }
}