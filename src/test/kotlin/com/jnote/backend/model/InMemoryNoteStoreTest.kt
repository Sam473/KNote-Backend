package com.jnote.backend.model

import com.jnote.backend.model.Note.NoteBuilder
import com.jnote.backend.model.interfaces.INote
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class InMemoryNoteStoreTest {

    private val title = "title"
    private val body = "body"

    @Test
    fun builderCreatesCorrectObject() {
        val testNote: INote = NoteBuilder()
            .withTitle(title)
            .withBody(body)
            .build()

        assertThat(testNote.title).isEqualTo(title)
        assertThat(testNote.body).isEqualTo(body)
    }
}