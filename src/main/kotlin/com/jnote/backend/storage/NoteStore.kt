package com.jnote.backend.storage

import com.jnote.backend.model.interfaces.INote

interface NoteStore {
    fun saveNote(note: INote): INote

    fun getNotes(): List<INote>
}