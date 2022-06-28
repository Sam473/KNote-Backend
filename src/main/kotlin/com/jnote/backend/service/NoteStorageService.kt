package com.jnote.backend.service;

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.storage.PersistentNoteStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
//TODO: Could make this StorageService<INote> if I end up with multiple StorageServices
class NoteStorageService(@Autowired val noteStore: PersistentNoteStore) {

    fun saveNote(note: INote): INote {
        return noteStore.saveNote(note)
    }

    fun getNotes(): List<INote> {
        return Collections.unmodifiableList(noteStore.getNotes());
    }
}
