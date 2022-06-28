package com.jnote.backend.model.tranformer

import com.jnote.backend.jpa.NoteEntity
import com.jnote.backend.model.Note
import com.jnote.backend.model.interfaces.INote
import org.springframework.stereotype.Component

@Component
class NoteEntityToLDM : OneToOneTransformer<NoteEntity, INote> {

    override fun transform(entity: NoteEntity): INote {
        return Note.Builder()
            .withTitle(entity.title)
            .withBody(entity.body)
            .withDateCreated(entity.dateCreated)
            .withDateLastModified(entity.dateLastModified)
            .build()
    }

}