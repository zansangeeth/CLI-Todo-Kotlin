package com.sangeeth

private class Note(override val getNote: String, override val getTime: String, override val getNoteId: String) : NoteInterface
fun createNote(noteId: String, noteText: String, getTime: String): NoteInterface = Note(getNoteId = noteId, getNote = noteText, getTime = getTime)
fun updateNote(noteId: String, noteText: String, getTime: String): NoteInterface = Note(getNoteId = noteId, getNote = noteText, getTime = getTime)