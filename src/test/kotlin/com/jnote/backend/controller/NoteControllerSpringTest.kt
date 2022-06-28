package com.jnote.backend.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.jnote.backend.model.Note
import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.service.NoteStorageService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension::class)
@ActiveProfiles("test")
internal class NoteControllerSpringTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var storageService: NoteStorageService

    @Autowired
    private lateinit var noteController: NoteController

    @Test
    fun saveNoteShouldReturnNote() {
        val note: INote = Note.Builder()
            .withTitle("Sandwich")
            .withBody("body")
            .build()
        given(storageService.saveNote(any())).willReturn(note)
        val noteJson = objectMapper.writeValueAsString(note)
        val result = mvc.perform(
            MockMvcRequestBuilders.post("/api/v1/note")
                .contentType(MediaType.APPLICATION_JSON)
                .content(noteJson)
        )
            .andExpect(MockMvcResultMatchers.status().isAccepted)
            .andReturn().response.contentAsString

        assertThat(result).isEqualTo(noteJson)
    }
}