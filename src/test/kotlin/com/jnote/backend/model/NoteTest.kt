package com.jnote.backend.model

import com.jnote.backend.model.Note.Builder
import com.jnote.backend.model.interfaces.INote
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class NoteTest {

    private val title = "title"
    private val body = "body"

    @Test
    fun builderCreatesCorrectObject() {
        val testNote: INote = Builder()
            .withTitle(title)
            .withBody(body)
            .build()

        assertThat(testNote.title).isEqualTo(title)
        assertThat(testNote.body).isEqualTo(body)
    }
}