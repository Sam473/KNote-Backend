package com.jnote.backend.model.tranformer

interface OneToOneTransformer<FROM, TO> {
    fun transform(toTransform: FROM): TO
}