package com.jnote.backend.model.tranformer

import com.jnote.backend.jpa.NoteEntity
import com.jnote.backend.model.Note
import com.jnote.backend.model.interfaces.INote
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

private val DATE_LAST_MODIFIED = LocalDateTime.of(2021, 2, 2, 2, 2, 3)
private val DATE_CREATED = LocalDateTime.of(2020, 2, 2, 2, 2, 2)
private const val TITLE = "title"
private const val BODY = "body"

internal class NoteEntityToLDMTest {

    @Test
    fun willReturnLDMWithCorrectProperties() {
        val noteEntityToLDM = NoteEntityToLDM()
        val noteEntity = NoteEntity(TITLE, BODY, DATE_CREATED, DATE_LAST_MODIFIED)
        val expected: INote = Note.Builder()
            .withTitle(TITLE)
            .withBody(BODY)
            .withDateCreated(DATE_CREATED)
            .withDateLastModified(DATE_LAST_MODIFIED)
            .build()

        assertThat(noteEntityToLDM.transform(noteEntity))
            .usingRecursiveComparison()
            .isEqualTo(expected)
    }
}