package com.jnote.backend.storage

import com.jnote.backend.model.interfaces.INote
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class InMemoryNoteStoreTest {

    private lateinit var inMemoryStore: InMemoryNoteStore

    @Mock
    private lateinit var notes: MutableList<INote>

    @BeforeEach
    fun beforeEach() {
        inMemoryStore = InMemoryNoteStore(notes)
    }

    @Test
    fun getNotesWillReturnAllNotes() {
        assertEquals(inMemoryStore.notes, notes)
    }

    @Test
    fun saveNoteWillSave(@Mock note: INote) {
        assertEquals(inMemoryStore.saveNote(note), note)
    }
}