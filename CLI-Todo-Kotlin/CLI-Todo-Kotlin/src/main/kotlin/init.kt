package com.sangeeth

import kotlin.system.exitProcess
var scanner: Any? = null
suspend fun cliInit(){

    println("***************CLI-Todo-App*****************")

    println("welcome to notes app")
    println("press 1 or 2 only")
    println("1 - New Note")
    println("2 - View Notes")
    println("3 - Modify Notes")
    println("4 - Exit")

    try {
        scanner = readln().toInt()
        do {
            when (scanner) {
                1 -> addNewNote()
                2 -> viewNotes()
                3 -> modifyNotes()
                4 -> exitProcess(0)
                else -> println("you should be select either 1 or 2\n ${cliInit()}")
            }
        } while (scanner == 1 or(2))
    } catch (e: Exception) {
        println("you should be select either 1 or 2")
        cliInit()
    }
}