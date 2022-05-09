package com.jnote.backend.controller;

import com.jnote.backend.model.interfaces.INote
import com.jnote.backend.service.NoteStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/note")
class NoteController(@Autowired val storageService: NoteStorageService) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun saveNote(@RequestBody note: INote): INote {
        return storageService.saveNote(note)
    }
}
