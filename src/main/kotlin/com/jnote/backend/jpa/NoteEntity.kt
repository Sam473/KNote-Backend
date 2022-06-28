package com.jnote.backend.jpa

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "NOTE")
class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // TODO: 28/06/2022 Can we make this a bit nicer?
    val id: Long = 0
    lateinit var title: String
    lateinit var body: String
    lateinit var dateCreated: LocalDateTime
    lateinit var dateLastModified: LocalDateTime

    constructor(title: String, body: String, dateCreated: LocalDateTime, dateLastModified: LocalDateTime) {
        this.title = title
        this.body = body
        this.dateCreated = dateCreated
        this.dateLastModified = dateLastModified
    }

    private constructor() {}
}