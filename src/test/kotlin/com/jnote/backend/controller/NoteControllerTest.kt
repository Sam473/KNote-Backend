package com.jnote.backend.controller

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.service.NoteStorageService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class NoteControllerTest {

    @Mock
    private lateinit var storageService: NoteStorageService

    private lateinit var noteController: NoteController

    @BeforeEach
    fun beforeEach() {
        noteController = NoteController(storageService);
    }

    @Test
    fun saveNoteShouldReturnNote(@Mock note: INote) {
        given(storageService.saveNote(note)).willReturn(note)
        assertThat(noteController.saveNote(note)).isEqualTo(note)
    }

}