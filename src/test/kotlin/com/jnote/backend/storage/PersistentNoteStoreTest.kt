package com.jnote.backend.storage

import com.jnote.backend.jpa.NoteEntity
import com.jnote.backend.model.Note
import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.model.tranformer.OneToOneTransformer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.jpa.repository.JpaRepository
import java.util.List

@ExtendWith(MockitoExtension::class)
internal class PersistentNoteStoreTest {
    lateinit var persistentNoteStore: PersistentNoteStore

    @Mock
    lateinit var repository: JpaRepository<NoteEntity, Long>

    @Mock
    lateinit var noteLDMToEntity: OneToOneTransformer<INote, NoteEntity>

    @Mock
    lateinit var noteEntityToLDM: OneToOneTransformer<NoteEntity, INote>

    @BeforeEach
    fun beforeEach() {
        persistentNoteStore = PersistentNoteStore(repository, noteLDMToEntity, noteEntityToLDM)
    }

    @Test
    fun getNotesWillReturnAllNotes(@Mock noteEntity: NoteEntity, @Mock note: Note) {
        val noteEntities = listOf(noteEntity)
        given(repository.findAll()).willReturn(noteEntities)
        given(noteEntityToLDM.transform(noteEntity)).willReturn(note)
        assertThat(persistentNoteStore.getNotes()).isEqualTo(List.of(note))
    }

    @Test
    fun saveNoteWillSave(@Mock note: INote, @Mock noteEntity: NoteEntity) {
        given(noteLDMToEntity.transform(note)).willReturn(noteEntity)
        given(repository.save(noteEntity)).willReturn(noteEntity)
        given(noteEntityToLDM.transform(noteEntity)).willReturn(note)
        assertThat(persistentNoteStore.saveNote(note)).usingRecursiveComparison().isEqualTo(note)
    }
}