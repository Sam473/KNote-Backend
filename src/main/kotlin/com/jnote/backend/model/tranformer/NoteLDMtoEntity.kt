package com.jnote.backend.model.tranformer

import com.jnote.backend.jpa.NoteEntity
import com.jnote.backend.model.interfaces.INote
import org.springframework.stereotype.Component

@Component
class NoteLDMtoEntity : OneToOneTransformer<INote, NoteEntity> {

    override fun transform(ldm: INote): NoteEntity {
        return NoteEntity(ldm.title, ldm.body, ldm.dateCreated, ldm.dateLastModified)
    }

}