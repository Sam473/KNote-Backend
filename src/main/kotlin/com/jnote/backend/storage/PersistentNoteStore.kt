package com.jnote.backend.storage

import com.functionaltools.functionalutils.Identity
import com.jnote.backend.jpa.NoteEntity
import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.model.tranformer.OneToOneTransformer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class PersistentNoteStore(
    val repository: JpaRepository<NoteEntity, Long>,
    val noteLDMToEntity: OneToOneTransformer<INote, NoteEntity>,
    val noteEntityToLDM: OneToOneTransformer<NoteEntity, INote>
) : NoteStore {

    override fun saveNote(note: INote): INote {
        return Identity.of(note)
            .map(noteLDMToEntity::transform)
            .map(repository::save)
            .fold(noteEntityToLDM::transform);
    }

    override fun getNotes(): List<INote> {
        return repository.findAll().stream()
            .map(noteEntityToLDM::transform)
            .collect(Collectors.toUnmodifiableList());
    }
}