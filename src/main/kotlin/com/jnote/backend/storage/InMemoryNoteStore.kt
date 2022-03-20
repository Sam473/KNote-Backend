package com.jnote.backend.storage

import com.jnote.backend.model.interfaces.INote

open class InMemoryNoteStore(override val notes: MutableList<INote>) : NoteStore {

    override fun saveNote(note: INote): INote {
        notes.add(note)
        return note
    }
}