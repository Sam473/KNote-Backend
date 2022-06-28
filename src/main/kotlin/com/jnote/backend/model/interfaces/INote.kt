package com.jnote.backend.model.interfaces

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.jnote.backend.model.Note
import java.time.LocalDateTime

//TODO: Not a long term solution, fix this
@JsonDeserialize(`as` = Note::class)
interface INote {

    val title: String
    val body: String
    val dateCreated: LocalDateTime
    val dateLastModified: LocalDateTime

    fun builder(): INoteBuilder {
        return Note.Builder()
    }
}