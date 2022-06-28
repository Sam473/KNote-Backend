package com.jnote.backend.storage

import com.jnote.backend.model.interfaces.INote
import org.springframework.stereotype.Component

@Component
@kotlin.Deprecated("Please use the PersistentNoteStore")
class InMemoryNoteStore(private val notes: MutableList<INote>) : NoteStore {

    override fun saveNote(note: INote): INote {
        notes.add(note)
        return note
    }

    override fun getNotes(): List<INote> {
        return notes
    }
}