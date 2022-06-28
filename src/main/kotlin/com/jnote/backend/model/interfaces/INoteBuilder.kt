package com.jnote.backend.model.interfaces

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder
import com.jnote.backend.model.Note
import com.jnote.backend.model.Note.Builder
import java.time.LocalDateTime

@JsonPOJOBuilder
interface INoteBuilder {
    fun withTitle(title: String): Builder

    fun withBody(body: String): Builder

    fun withDateCreated(dateCreated: LocalDateTime): Builder

    fun withDateLastModified(dateLastModified: LocalDateTime): Builder

    fun build(): Note
}