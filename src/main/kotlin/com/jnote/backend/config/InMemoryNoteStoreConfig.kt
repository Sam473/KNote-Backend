package com.jnote.backend.config;

import com.jnote.backend.model.interfaces.INote
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InMemoryNoteStoreConfig {

    @Bean
    fun notes(): MutableList<INote> {
        return mutableListOf()
    }

}
