package com.sangeeth

import kotlin.io.println


fun vewNotes() {

    val db = notesDBInstance.notesDB


    val idMaxWidth = maxOf("ID".length, db.keys.maxOfOrNull { it.length } ?: 0)
    val noteWidth = maxOf(
        "Note".length,
        db.values.flatten().maxOfOrNull { it.getNote.length } ?: 0
    )
    val dateMaxWidth = maxOf(
        "Note".length,
        db.values.flatten().maxOfOrNull { it.getNote.length } ?: 0
    )

    println("| %-${idMaxWidth}s | %-${noteWidth}s | %-${dateMaxWidth}s |".format("ID", "Note", "Time"))
    notesDBInstance.notesDB.forEach { (id, notes) ->

        notes.forEach { note ->
            println("| ${id.padEnd(idMaxWidth)} | ${note.getNote.padEnd(noteWidth)} | ${note.getTime.padEnd(dateMaxWidth)} |")
        }

    }
    cliInit()
}
