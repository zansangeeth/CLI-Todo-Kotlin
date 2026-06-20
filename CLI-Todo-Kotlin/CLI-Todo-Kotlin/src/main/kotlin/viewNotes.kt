package com.sangeeth

import kotlin.io.println


fun vewNotes() {
    notesDBInstance.notesDB.forEach { (id, notes) ->
        println("ID: $id")
        notes.forEach { note ->
            println("  Note: ${note.getNote}")
            println("  Date: ${note.getTime}")
            println()
        }
    }
    cliInit()
}
