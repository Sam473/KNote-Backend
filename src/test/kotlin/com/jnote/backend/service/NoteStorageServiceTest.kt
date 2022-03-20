package com.jnote.backend.service

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.storage.InMemoryNoteStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

@MockitoSettings
internal class NoteStorageServiceTest {

    private lateinit var noteStorageService: NoteStorageService
    private val inMemoryNoteStore: InMemoryNoteStore = mock()

    @BeforeEach
    fun beforeEach() {
        noteStorageService = NoteStorageService(inMemoryNoteStore)
    }

    @Test
    fun getNotesWillReturnAllNotes(@Mock note: INote) {
        val mutableList = mutableListOf<INote>()
        mutableList.add(note)
        whenever(inMemoryNoteStore.notes).thenReturn(mutableList)

        assertEquals(noteStorageService.getNotes(), Collections.unmodifiableList(mutableList))
        assertThat(noteStorageService.inMemoryNoteStore).isSameAs(Collections.unmodifiableList(mutableList))
    }

    @Test
    fun saveNoteWillAddToNotes(@Mock note: INote) {
        BDDMockito.given(inMemoryNoteStore.saveNote(note)).willReturn(note)
        assertThat(noteStorageService.saveNote(note)).isEqualTo(note)
    }
}