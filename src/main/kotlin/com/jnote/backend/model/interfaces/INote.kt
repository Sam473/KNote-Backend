package com.jnote.backend.model.interfaces

import com.jnote.backend.model.Note
import java.time.LocalDateTime

interface INote {

    val title: String
    val body: String
    val dateCreated: LocalDateTime
    val dateLastModified: LocalDateTime


    fun builder(): INoteBuilder {
        return Note.NoteBuilder()
    }
}