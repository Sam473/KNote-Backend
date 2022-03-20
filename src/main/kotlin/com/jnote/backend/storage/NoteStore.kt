package com.jnote.backend.storage

import com.jnote.backend.model.interfaces.INote

interface NoteStore {
    val notes: List<INote>

    fun saveNote(note: INote): INote
}