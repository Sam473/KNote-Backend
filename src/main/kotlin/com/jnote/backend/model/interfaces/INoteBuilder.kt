package com.jnote.backend.model.interfaces

import com.jnote.backend.model.Note
import com.jnote.backend.model.Note.NoteBuilder
import java.time.LocalDateTime

interface INoteBuilder {
    fun withTitle(title: String): NoteBuilder

    fun withBody(body: String): NoteBuilder

    fun withDateCreated(dateCreated: LocalDateTime): NoteBuilder

    fun withDateLastModified(dateLastModified: LocalDateTime): NoteBuilder

    fun build(): Note
}