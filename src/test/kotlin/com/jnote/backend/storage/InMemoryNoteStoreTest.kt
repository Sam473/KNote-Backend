package com.jnote.backend.storage

import com.jnote.backend.model.interfaces.INote
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.kotlin.mock

@MockitoSettings
internal class InMemoryNoteStoreTest {

    private lateinit var inMemoryStore: InMemoryNoteStore
    private val notes: MutableList<INote> = mock()

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