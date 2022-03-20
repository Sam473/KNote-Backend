package com.jnote.backend.model

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.model.interfaces.INoteBuilder
import java.io.Serializable
import java.time.LocalDateTime

class Note : INote, Serializable {
    override val title: String
    override val body: String
    override val dateCreated: LocalDateTime
    override val dateLastModified: LocalDateTime

    private constructor(builder: NoteBuilder) {
        title = builder.title
        body = builder.body
        dateCreated = builder.dateCreated
        dateLastModified = builder.dateLastModified
    }

    constructor(title: String, body: String) {
        this.title = title
        this.body = body
        dateCreated = LocalDateTime.now()
        dateLastModified = LocalDateTime.now()
    }

    override fun builder(): NoteBuilder {
        return NoteBuilder()
    }

    class NoteBuilder : INoteBuilder {
        lateinit var title: String
        lateinit var body: String
        var dateCreated: LocalDateTime
        var dateLastModified: LocalDateTime

        override fun withBody(body: String): NoteBuilder {
            this.body = body
            return this
        }

        override fun withTitle(title: String): NoteBuilder {
            this.title = title
            return this
        }

        override fun withDateCreated(dateCreated: LocalDateTime): NoteBuilder {
            this.dateCreated = dateCreated
            return this
        }

        override fun withDateLastModified(dateLastModified: LocalDateTime): NoteBuilder {
            this.dateLastModified = dateLastModified
            return this
        }

        override fun build(): Note {
            return Note(this)
        }

        init {
            this.dateCreated = LocalDateTime.now()
            this.dateLastModified = LocalDateTime.now()
        }
    }
}