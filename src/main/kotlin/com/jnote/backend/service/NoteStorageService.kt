package com.jnote.backend.service;

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.storage.InMemoryNoteStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class NoteStorageService(@Autowired val inMemoryNoteStore: InMemoryNoteStore) {

    fun saveNote(note: INote): INote {
        return inMemoryNoteStore.saveNote(note)
    }

    fun getNotes(): List<INote> {
        return Collections.unmodifiableList(inMemoryNoteStore.notes);
    }
}
