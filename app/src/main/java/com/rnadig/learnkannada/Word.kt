package com.rnadig.learnkannada

data class Word(val englishTranslation: String, val kannadaTranslation: String, val imageId: Int = -1, val audioId: Int) {
    constructor(englishTranslation: String, kannadaTranslation: String, audioId: Int)
            : this(englishTranslation, kannadaTranslation, -1, audioId)
}