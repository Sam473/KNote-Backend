package com.jnote.backend.service

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.storage.PersistentNoteStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class NoteStorageServiceTest {

    private lateinit var noteStorageService: NoteStorageService

    @Mock
    private lateinit var noteStore: PersistentNoteStore

    @BeforeEach
    fun beforeEach() {
        noteStorageService = NoteStorageService(noteStore)
    }

    @Test
    fun getNotesWillReturnAllNotes(@Mock note: INote) {
        val list = listOf(note)
        whenever(noteStore.getNotes()).thenReturn(list)
        assertEquals(noteStorageService.getNotes(), list)
    }

    @Test
    fun saveNoteWillAddToNotes(@Mock note: INote) {
        given(noteStore.saveNote(note)).willReturn(note)
        assertThat(noteStorageService.saveNote(note)).isEqualTo(note)
    }
}