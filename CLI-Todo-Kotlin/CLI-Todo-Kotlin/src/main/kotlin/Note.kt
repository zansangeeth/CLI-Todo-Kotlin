package com.sangeeth

private class Note(override val getNote: String) : NoteInterface
fun createNote(noteText: String): NoteInterface = Note(noteText)