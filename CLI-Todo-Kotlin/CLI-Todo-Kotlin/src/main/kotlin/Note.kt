package com.sangeeth

private class Note(override val getNote: String, override val getTime: String) : NoteInterface
fun createNote(noteText: String, getTime: String): NoteInterface = Note(noteText, getTime)