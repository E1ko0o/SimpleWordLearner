package com.e1ko0o.android.simplewordlearner.models

data class Word(
    val word: String,
    val translate: String,
    val pronunciation: String,
    val srcOfImage: String,
    val definition: String,
    val synonyms: Array<String>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Word

        if (!synonyms.contentEquals(other.synonyms)) return false

        return true
    }

    override fun hashCode(): Int {
        return synonyms.contentHashCode()
    }
}