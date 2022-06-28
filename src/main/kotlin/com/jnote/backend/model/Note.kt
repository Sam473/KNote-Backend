package com.jnote.backend.model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder
import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.model.interfaces.INoteBuilder
import java.io.Serializable
import java.time.LocalDateTime

@JsonDeserialize(builder = Note.Builder::class)
class Note private constructor(builder: Builder) : INote, Serializable {
    override val title: String
    override val body: String
    override val dateCreated: LocalDateTime
    override val dateLastModified: LocalDateTime

    init {
        title = builder.title
        body = builder.body
        dateCreated = builder.dateCreated
        dateLastModified = builder.dateLastModified
    }

    override fun builder(): Builder {
        return Builder()
    }

    @JsonPOJOBuilder
    class Builder : INoteBuilder {
        lateinit var title: String
        lateinit var body: String
        var dateCreated: LocalDateTime = LocalDateTime.now()
        var dateLastModified: LocalDateTime = LocalDateTime.now()

        override fun withBody(body: String) = apply { this.body = body }

        override fun withTitle(title: String) = apply { this.title = title }

        override fun withDateCreated(dateCreated: LocalDateTime) = apply { this.dateCreated = dateCreated }

        override fun withDateLastModified(dateLastModified: LocalDateTime) =
            apply { this.dateLastModified = dateLastModified }

        override fun build(): Note {
            return Note(this)
        }
    }
}